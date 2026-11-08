package org.telegram.messenger;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * OsintGram specific configuration and Ghost Mode settings.
 * This is a starting point for anonymity features.
 */
public class OsintGramConfig {

    private static final String PREF_NAME = "osintgram_config";

    // Ghost Mode flags
    public static boolean ghostModeEnabled = false;
    public static boolean hideOnline = true;
    public static boolean hideTyping = true;
    public static boolean hideReadReceipts = true;
    public static boolean hideStoryViews = true;
    public static boolean autoOffline = false;

    public static void load(Context context) {
        if (context == null) return;
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        ghostModeEnabled = prefs.getBoolean("ghostModeEnabled", false);
        hideOnline = prefs.getBoolean("hideOnline", true);
        hideTyping = prefs.getBoolean("hideTyping", true);
        hideReadReceipts = prefs.getBoolean("hideReadReceipts", true);
        hideStoryViews = prefs.getBoolean("hideStoryViews", true);
        autoOffline = prefs.getBoolean("autoOffline", false);
    }

    public static void save(Context context) {
        if (context == null) return;
        SharedPreferences.Editor editor = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit();
        editor.putBoolean("ghostModeEnabled", ghostModeEnabled);
        editor.putBoolean("hideOnline", hideOnline);
        editor.putBoolean("hideTyping", hideTyping);
        editor.putBoolean("hideReadReceipts", hideReadReceipts);
        editor.putBoolean("hideStoryViews", hideStoryViews);
        editor.putBoolean("autoOffline", autoOffline);
        editor.apply();
    }

    public static boolean isGhostModeActive() {
        return ghostModeEnabled;
    }
}
