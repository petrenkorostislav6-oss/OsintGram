package org.telegram.messenger;

import android.content.Context;

/**
 * Bootstrap class for OsintGram.
 * Call OsintGramBootstrap.init(context) early in ApplicationLoader.
 */
public class OsintGramBootstrap {

    private static boolean initialized = false;

    public static void init(Context context) {
        if (initialized || context == null) {
            return;
        }
        OsintGramConfig.load(context);
        initialized = true;
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("OsintGram bootstrap completed. GhostMode=" + OsintGramConfig.ghostModeEnabled);
        }
    }
}
