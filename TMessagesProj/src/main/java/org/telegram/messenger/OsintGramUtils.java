package org.telegram.messenger;

/**
 * Utility helpers for OsintGram features.
 */
public class OsintGramUtils {

    public static boolean shouldHideOnline() {
        return OsintGramConfig.isGhostModeActive() && OsintGramConfig.hideOnline;
    }

    public static boolean shouldHideTyping() {
        return OsintGramConfig.isGhostModeActive() && OsintGramConfig.hideTyping;
    }

    public static boolean shouldHideReadReceipts() {
        return OsintGramConfig.isGhostModeActive() && OsintGramConfig.hideReadReceipts;
    }

    public static boolean shouldHideStoryViews() {
        return OsintGramConfig.isGhostModeActive() && OsintGramConfig.hideStoryViews;
    }

    public static boolean shouldAutoOffline() {
        return OsintGramConfig.isGhostModeActive() && OsintGramConfig.autoOffline;
    }
}
