# OsintGram Development Notes

## Important

1. **API Credentials**
   - Current APP_ID / APP_HASH are official Telegram ones.
   - For a real mod you **must** get your own from https://my.telegram.org
   - Using official credentials in a modified client is against Telegram ToS.

2. **Ghost Mode implementation status**
   - OsintGramConfig.java — storage for settings (ready)
   - OsintGramSettingsActivity.java — UI for toggles (ready)
   - OsintGramUtils.java — helper checks (ready)
   - Actual interception of online status, typing, read receipts and story views still needs to be implemented in core classes (ConnectionsManager, MessagesController, SendMessagesHelper, etc.)

3. **Building**
   - See BUILD_INSTRUCTIONS.md

4. **Next technical steps**
   - Hook ApplicationLoader to call OsintGramConfig.load() on start
   - Add entry point to OsintGramSettingsActivity from main settings
   - Implement the actual send-status blocking logic using OsintGramUtils checks

## Files added by assistant
- README.md (updated)
- ROADMAP.md
- NOTES.md
- BUILD_INSTRUCTIONS.md
- OsintGramConfig.java
- OsintGramUtils.java
- OsintGramSettingsActivity.java
- BuildVars.java (adjusted)
