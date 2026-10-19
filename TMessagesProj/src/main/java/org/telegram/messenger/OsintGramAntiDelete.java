/*
 * OsintGram - Anti-Delete Messages
 * Saves deleted messages locally so they can still be viewed.
 */

package org.telegram.messenger;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;

import org.telegram.tgnet.TLRPC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Handles anti-delete functionality for OsintGram.
 * When enabled, messages deleted by the other side are kept in a local archive
 * and can still be displayed in the chat.
 */
public class OsintGramAntiDelete {

    private static final String PREFS_NAME = "osintgram_antidelete";
    private static final String KEY_ENABLED = "enabled";
    private static final String KEY_SAVE_MEDIA = "save_media";
    private static final String KEY_SHOW_IN_CHAT = "show_in_chat";

    // dialogId -> set of message ids that were deleted by the other party
    private static final Map<Long, Set<Integer>> deletedMessageIds = new HashMap<>();

    // dialogId -> messageId -> saved message object (lightweight cache)
    private static final Map<Long, SparseArray<TLRPC.Message>> deletedMessagesCache = new HashMap<>();

    private static SharedPreferences prefs;

    public static void init(Context context) {
        if (prefs == null) {
            prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        }
    }

    public static boolean isEnabled() {
        if (prefs == null) return true; // default on
        return prefs.getBoolean(KEY_ENABLED, true);
    }

    public static void setEnabled(boolean enabled) {
        if (prefs != null) {
            prefs.edit().putBoolean(KEY_ENABLED, enabled).apply();
        }
    }

    public static boolean isSaveMedia() {
        if (prefs == null) return true;
        return prefs.getBoolean(KEY_SAVE_MEDIA, true);
    }

    public static void setSaveMedia(boolean save) {
        if (prefs != null) {
            prefs.edit().putBoolean(KEY_SAVE_MEDIA, save).apply();
        }
    }

    public static boolean isShowInChat() {
        if (prefs == null) return true;
        return prefs.getBoolean(KEY_SHOW_IN_CHAT, true);
    }

    public static void setShowInChat(boolean show) {
        if (prefs != null) {
            prefs.edit().putBoolean(KEY_SHOW_IN_CHAT, show).apply();
        }
    }

    /**
     * Call this BEFORE the message is removed from the database.
     * Saves the message so it can be restored / shown later.
     */
    public static void onMessageAboutToBeDeleted(long dialogId, TLRPC.Message message, boolean fromServer) {
        if (!isEnabled() || message == null) {
            return;
        }

        // Only protect messages deleted by the other side (server push),
        // not when the user himself deletes them.
        if (!fromServer) {
            return;
        }

        synchronized (deletedMessageIds) {
            Set<Integer> ids = deletedMessageIds.get(dialogId);
            if (ids == null) {
                ids = new HashSet<>();
                deletedMessageIds.put(dialogId, ids);
            }
            ids.add(message.id);

            SparseArray<TLRPC.Message> cache = deletedMessagesCache.get(dialogId);
            if (cache == null) {
                cache = new SparseArray<>();
                deletedMessagesCache.put(dialogId, cache);
            }
            // Keep a copy of the message
            cache.put(message.id, message);
        }

        FileLog.d("OsintGramAntiDelete: saved deleted message id=" + message.id + " dialog=" + dialogId);
    }

    /**
     * Returns true if this message id was deleted by the other party and we still have it.
     */
    public static boolean isDeletedButSaved(long dialogId, int messageId) {
        synchronized (deletedMessageIds) {
            Set<Integer> ids = deletedMessageIds.get(dialogId);
            return ids != null && ids.contains(messageId);
        }
    }

    public static TLRPC.Message getSavedDeletedMessage(long dialogId, int messageId) {
        synchronized (deletedMessageIds) {
            SparseArray<TLRPC.Message> cache = deletedMessagesCache.get(dialogId);
            if (cache != null) {
                return cache.get(messageId);
            }
            return null;
        }
    }

    public static ArrayList<TLRPC.Message> getAllSavedForDialog(long dialogId) {
        ArrayList<TLRPC.Message> result = new ArrayList<>();
        synchronized (deletedMessageIds) {
            SparseArray<TLRPC.Message> cache = deletedMessagesCache.get(dialogId);
            if (cache != null) {
                for (int i = 0; i < cache.size(); i++) {
                    result.add(cache.valueAt(i));
                }
            }
        }
        return result;
    }

    public static void clearForDialog(long dialogId) {
        synchronized (deletedMessageIds) {
            deletedMessageIds.remove(dialogId);
            deletedMessagesCache.remove(dialogId);
        }
    }

    public static void clearAll() {
        synchronized (deletedMessageIds) {
            deletedMessageIds.clear();
            deletedMessagesCache.clear();
        }
    }
}
