# OsintGram

Telegram client for Android with **Ghost Mode**, enhanced anonymity and planned built-in OSINT tools.

Based on official Telegram Android source + architecture inspired by AyuGram / exteraGram.

## Current status (November 2026)

### Ready
- Project structure and branding (OsintGram)
- Ghost Mode settings storage (`OsintGramConfig`)
- Ghost Mode settings UI (`OsintGramSettingsActivity`)
- Helper classes and central hooks (`OsintGramUtils`, `OsintGramHooks`, `OsintGramBootstrap`)
- Detailed implementation guide (`GHOST_MODE_IMPLEMENTATION.md`)
- Placeholders for future OSINT modules

### Not yet working
- Actual Ghost Mode (online / typing / read receipts / stories) — hooks are prepared but **not wired** into core Telegram classes yet
- Settings screen is not linked from the main menu
- Own API credentials not set
- Real OSINT functionality

## How to continue development

1. Read `GHOST_MODE_IMPLEMENTATION.md`
2. Get your own `APP_ID` + `APP_HASH` from https://my.telegram.org and put them into `BuildVars.java`
3. Call `OsintGramBootstrap.init(context)` from `ApplicationLoader`
4. Insert the hook checks from `OsintGramHooks` into the relevant core methods
5. Add a menu entry that opens `OsintGramSettingsActivity`

## Build
See `BUILD_INSTRUCTIONS.md`

## Disclaimer
Unofficial client. Using official API credentials in modified clients violates Telegram Developer ToS. Use at your own risk. For educational and privacy purposes only.
