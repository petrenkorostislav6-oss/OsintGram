package org.telegram.messenger;

/**
 * Central place for OsintGram hooks.
 * Call these methods from core classes when implementing Ghost Mode.
 */
public class OsintGramHooks {

    /**
     * Call before sending online status update.
     * @return true if the update should be blocked
     */
    public static boolean shouldBlockOnlineStatus() {
        return OsintGramUtils.shouldHideOnline();
    }

    /**
     * Call before sending typing action.
     * @return true if typing should be blocked
     */
    public static boolean shouldBlockTyping() {
        return OsintGramUtils.shouldHideTyping();
    }

    /**
     * Call before sending read receipts.
     * @return true if read receipts should be blocked
     */
    public static boolean shouldBlockReadReceipts() {
        return OsintGramUtils.shouldHideReadReceipts();
    }

    /**
     * Call before marking story as viewed.
     * @return true if story view should be blocked
     */
    public static boolean shouldBlockStoryView() {
        return OsintGramUtils.shouldHideStoryViews();
    }

    /**
     * Whether the client should try to go offline automatically.
     */
    public static boolean shouldForceOffline() {
        return OsintGramUtils.shouldAutoOffline();
    }
}
