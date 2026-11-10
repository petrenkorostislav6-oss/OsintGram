# How to build OsintGram

## Requirements
- Android Studio (latest recommended)
- Android NDK 27+
- JDK 17+
- Own Telegram API credentials from https://my.telegram.org

## Steps

1. Clone the repository:
```bash
git clone --recursive https://github.com/petrenkorostislav6-oss/OsintGram.git
cd OsintGram
```

2. Open the project in Android Studio (**Open**, not Import).

3. Get your own `APP_ID` and `APP_HASH`:
   - Go to https://my.telegram.org
   - Create an application
   - Put them into `TMessagesProj/src/main/java/org/telegram/messenger/BuildVars.java`

4. (Optional but recommended) Replace the dummy keystore and google-services.json with your own.

5. Build a debug or release APK from Android Studio.

## Important notes
- Using official Telegram API credentials in a modified client violates Telegram Developer ToS.
- Ghost Mode logic is prepared (OsintGramConfig + Settings UI + Utils) but the actual network interception is not fully wired yet.
- The settings screen exists (`OsintGramSettingsActivity`) but is not yet linked from the main menu.

## Current Ghost Mode status
- Preferences storage: ready
- Settings UI: ready
- Helper methods: ready
- Actual blocking of online/typing/read receipts: needs further code changes in core classes
