# OsintGram Development Notes

## Important

1. **API Credentials**
   - Current APP_ID / APP_HASH are official Telegram ones.
   - For a real mod you **must** get your own from https://my.telegram.org
   - Using official credentials in a modified client is against Telegram ToS.

2. **Ghost Mode implementation**
   - OsintGramConfig.java is the starting storage for settings.
   - Actual interception of online status, typing, read receipts and story views needs to be done in:
     - ConnectionsManager
     - MessagesController
     - SendMessagesHelper
     - NotificationCenter related places
     - Story related classes
   - Best approach: study open source patches from AyuGram / exteraGram / re-extera and port them carefully.

3. **Building**
   - Requires Android Studio, NDK, proper keystore and google-services.json
   - See original README for detailed build steps.

4. **Next technical steps**
   - Hook ApplicationLoader to load OsintGramConfig on start
   - Create settings UI for Ghost Mode
   - Implement the actual send-status blocking logic

## Current commits made by AI assistant
- README rewrite
- BuildVars adjustments
- ROADMAP.md
- OsintGramConfig.java (Ghost Mode prefs stub)
