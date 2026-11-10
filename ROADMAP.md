# OsintGram Development Roadmap

## Phase 1 — Rebranding & Base
- [x] Rename project to OsintGram
- [x] Update README
- [x] Adjust BuildVars
- [x] Create OsintGramConfig.java
- [x] Create OsintGramSettingsActivity
- [x] Create OsintGramUtils + OsintGramHooks
- [x] BUILD_INSTRUCTIONS.md + NOTES.md
- [ ] Replace remaining visible "Telegram" strings
- [ ] Custom icons
- [ ] Own APP_ID + APP_HASH
- [ ] Hook config loading into ApplicationLoader
- [ ] Link settings screen from main menu

## Phase 2 — Ghost Mode (Foundation ready)
- [x] Settings storage
- [x] Settings UI
- [x] Helper methods and central hooks
- [ ] Wire hooks into ConnectionsManager / MessagesController / SendMessagesHelper
- [ ] Hide online status (network level)
- [ ] Disable typing indicator
- [ ] Disable read receipts
- [ ] Hide story views
- [ ] Auto offline logic

## Phase 3 — Plugins
- [ ] Plugin system

## Phase 4 — Built-in OSINT
- [ ] Instagram + Telegram OSINT modules

## Status
Foundation for Ghost Mode is in place (config + UI + hooks).  
Next real work is inserting the hook calls into core Telegram classes.
