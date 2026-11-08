# OsintGram Development Roadmap

## Phase 1 — Rebranding & Base (In progress)
- [x] Rename project to OsintGram
- [x] Update README
- [x] Adjust BuildVars (disable official updates, passkeys, change store link)
- [x] Create OsintGramConfig.java (Ghost Mode preferences storage)
- [x] Create OsintGramSettingsActivity (basic settings UI)
- [ ] Replace remaining visible "Telegram" strings with "OsintGram" where appropriate
- [ ] Custom icons / splash screen
- [ ] Get and set own APP_ID + APP_HASH from https://my.telegram.org
- [ ] Hook config loading into ApplicationLoader

## Phase 2 — Ghost Mode & Anonymity (Started)
- [x] Settings storage (OsintGramConfig)
- [x] Basic settings screen
- [ ] Hide online status (actual network logic)
- [ ] Disable typing indicator
- [ ] Disable read receipts
- [ ] Hide story views
- [ ] Auto offline / scheduled messages mode
- [ ] Per-account Ghost Mode settings

## Phase 3 — Plugins & Extensibility
- [ ] Plugin loading system (inspired by AyuGram / exteraGram)
- [ ] Basic privacy plugins

## Phase 4 — Built-in OSINT (Later)
- [ ] Instagram OSINT module
- [ ] Telegram user/channel analysis tools
- [ ] Export reports

## Notes
- Full Ghost Mode requires deep changes in connection, online status, and message read logic.
- Recommended base for advanced features: look at open source patches from AyuGram4A / re-extera / community forks.
- Always use your own API credentials.
- This client breaks Telegram Developer ToS. Use responsibly.
