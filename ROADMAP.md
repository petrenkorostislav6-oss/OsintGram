# OsintGram Development Roadmap

## Phase 1 — Rebranding & Base (Current)
- [x] Rename project to OsintGram
- [x] Update README
- [x] Adjust BuildVars (disable official updates, passkeys, change store link)
- [ ] Replace remaining visible "Telegram" strings with "OsintGram" where appropriate
- [ ] Custom icons / splash screen
- [ ] Get and set own APP_ID + APP_HASH from https://my.telegram.org

## Phase 2 — Ghost Mode & Anonymity
- [ ] Hide online status
- [ ] Disable typing indicator
- [ ] Disable read receipts
- [ ] Hide story views
- [ ] Auto offline / scheduled messages mode
- [ ] Settings screen for Ghost Mode toggles
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
- Recommended base for advanced features: look at open-source patches from AyuGram4A / re-extera / community forks.
- Always use your own API credentials.
- This client breaks Telegram Developer ToS. Use responsibly.
