package org.telegram.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import org.telegram.messenger.AndroidUtilities;
import org.telegram.messenger.LocaleController;
import org.telegram.messenger.OsintGramConfig;
import org.telegram.messenger.R;
import org.telegram.ui.ActionBar.ActionBar;
import org.telegram.ui.ActionBar.BaseFragment;
import org.telegram.ui.ActionBar.Theme;
import org.telegram.ui.Cells.HeaderCell;
import org.telegram.ui.Cells.TextCheckCell;
import org.telegram.ui.Components.LayoutHelper;
import org.telegram.ui.Components.RecyclerListView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Basic settings screen for OsintGram Ghost Mode and anonymity options.
 * This is a starting point and will be expanded.
 */
public class OsintGramSettingsActivity extends BaseFragment {

    private RecyclerListView listView;
    private ListAdapter adapter;

    private int rowCount;
    private int ghostHeaderRow;
    private int ghostModeRow;
    private int hideOnlineRow;
    private int hideTypingRow;
    private int hideReadReceiptsRow;
    private int hideStoryViewsRow;
    private int autoOfflineRow;

    @Override
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        updateRows();
        return true;
    }

    private void updateRows() {
        rowCount = 0;
        ghostHeaderRow = rowCount++;
        ghostModeRow = rowCount++;
        hideOnlineRow = rowCount++;
        hideTypingRow = rowCount++;
        hideReadReceiptsRow = rowCount++;
        hideStoryViewsRow = rowCount++;
        autoOfflineRow = rowCount++;
    }

    @Override
    public View createView(Context context) {
        actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        actionBar.setTitle("OsintGram Settings");
        actionBar.setAllowOverlayTitle(true);
        actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() {
            @Override
            public void onItemClick(int id) {
                if (id == -1) {
                    finishFragment();
                }
            }
        });

        fragmentView = new FrameLayout(context);
        FrameLayout frameLayout = (FrameLayout) fragmentView;
        frameLayout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));

        listView = new RecyclerListView(context);
        listView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        listView.setVerticalScrollBarEnabled(false);
        frameLayout.addView(listView, LayoutHelper.createFrame(LayoutHelper.MATCH_PARENT, LayoutHelper.MATCH_PARENT));

        adapter = new ListAdapter(context);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((view, position) -> {
            if (position == ghostModeRow) {
                OsintGramConfig.ghostModeEnabled = !OsintGramConfig.ghostModeEnabled;
                OsintGramConfig.save(context);
                if (view instanceof TextCheckCell) {
                    ((TextCheckCell) view).setChecked(OsintGramConfig.ghostModeEnabled);
                }
            } else if (position == hideOnlineRow) {
                OsintGramConfig.hideOnline = !OsintGramConfig.hideOnline;
                OsintGramConfig.save(context);
                if (view instanceof TextCheckCell) {
                    ((TextCheckCell) view).setChecked(OsintGramConfig.hideOnline);
                }
            } else if (position == hideTypingRow) {
                OsintGramConfig.hideTyping = !OsintGramConfig.hideTyping;
                OsintGramConfig.save(context);
                if (view instanceof TextCheckCell) {
                    ((TextCheckCell) view).setChecked(OsintGramConfig.hideTyping);
                }
            } else if (position == hideReadReceiptsRow) {
                OsintGramConfig.hideReadReceipts = !OsintGramConfig.hideReadReceipts;
                OsintGramConfig.save(context);
                if (view instanceof TextCheckCell) {
                    ((TextCheckCell) view).setChecked(OsintGramConfig.hideReadReceipts);
                }
            } else if (position == hideStoryViewsRow) {
                OsintGramConfig.hideStoryViews = !OsintGramConfig.hideStoryViews;
                OsintGramConfig.save(context);
                if (view instanceof TextCheckCell) {
                    ((TextCheckCell) view).setChecked(OsintGramConfig.hideStoryViews);
                }
            } else if (position == autoOfflineRow) {
                OsintGramConfig.autoOffline = !OsintGramConfig.autoOffline;
                OsintGramConfig.save(context);
                if (view instanceof TextCheckCell) {
                    ((TextCheckCell) view).setChecked(OsintGramConfig.autoOffline);
                }
            }
        });

        return fragmentView;
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {

        private Context mContext;

        public ListAdapter(Context context) {
            mContext = context;
        }

        @Override
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int position = holder.getAdapterPosition();
            return position != ghostHeaderRow;
        }

        @Override
        public int getItemCount() {
            return rowCount;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            switch (viewType) {
                case 0:
                    view = new HeaderCell(mContext);
                    view.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 1:
                default:
                    view = new TextCheckCell(mContext);
                    view.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
            }
            return new RecyclerListView.Holder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            switch (holder.getItemViewType()) {
                case 0: {
                    HeaderCell headerCell = (HeaderCell) holder.itemView;
                    if (position == ghostHeaderRow) {
                        headerCell.setText("Ghost Mode");
                    }
                    break;
                }
                case 1: {
                    TextCheckCell checkCell = (TextCheckCell) holder.itemView;
                    if (position == ghostModeRow) {
                        checkCell.setTextAndCheck("Enable Ghost Mode", OsintGramConfig.ghostModeEnabled, true);
                    } else if (position == hideOnlineRow) {
                        checkCell.setTextAndCheck("Hide Online Status", OsintGramConfig.hideOnline, true);
                    } else if (position == hideTypingRow) {
                        checkCell.setTextAndCheck("Hide Typing Indicator", OsintGramConfig.hideTyping, true);
                    } else if (position == hideReadReceiptsRow) {
                        checkCell.setTextAndCheck("Hide Read Receipts", OsintGramConfig.hideReadReceipts, true);
                    } else if (position == hideStoryViewsRow) {
                        checkCell.setTextAndCheck("Hide Story Views", OsintGramConfig.hideStoryViews, true);
                    } else if (position == autoOfflineRow) {
                        checkCell.setTextAndCheck("Auto Offline", OsintGramConfig.autoOffline, false);
                    }
                    break;
                }
            }
        }

        @Override
        public int getItemViewType(int position) {
            if (position == ghostHeaderRow) {
                return 0;
            }
            return 1;
        }
    }
}
