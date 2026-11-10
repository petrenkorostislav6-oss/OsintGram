# Ghost Mode Implementation Guide for OsintGram

## Current state

Foundation is ready:
- `OsintGramConfig` — stores toggles
- `OsintGramSettingsActivity` — UI
- `OsintGramUtils` / `OsintGramHooks` — helper methods
- `OsintGramBootstrap` — easy init

## What still needs to be done (core changes)

To make Ghost Mode actually work you must call the hooks from Telegram core classes.

### 1. Load config on startup
In `ApplicationLoader.postInitApplication()` or `onCreate()` add:
```java
OsintGramBootstrap.init(applicationContext);
```

### 2. Block online status
Find places that send `TL_account_updateStatus` or set user online.
Usually in `ConnectionsManager` / `MessagesController` / related online update methods.
Add at the beginning:
```java
if (OsintGramHooks.shouldBlockOnlineStatus()) {
    return;
}
```

### 3. Block typing
Find `sendTyping` / `TL_messages_setTyping` calls.
Add:
```java
if (OsintGramHooks.shouldBlockTyping()) {
    return;
}
```

### 4. Block read receipts
Find methods that send `TL_messages_readHistory` or mark messages as read.
Add the corresponding hook check.

### 5. Block story views
Find story view reporting methods and add `OsintGramHooks.shouldBlockStoryView()`.

### 6. Add settings entry
In the main Settings activity (usually `SettingsActivity` or `ProfileActivity`) add a cell that opens `new OsintGramSettingsActivity()`.

## Recommended approach
The cleanest way is to study open-source clients that already have working Ghost Mode
(AyuGram, exteraGram, re-extera) and carefully port the relevant patches.

Directly editing official Telegram source without those patches is possible but requires a lot of testing.
