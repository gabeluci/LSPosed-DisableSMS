# LSPosed - Pair a second phone to Google Messages

Running Google Messages on a tablet will let you pair it to your phone. However,
there is no way to do this on a second phone.

This LSPosed module will tell Google Messages that your device does not support
sending or receiving SMS. That will make Google Messages think it's a wifi-only
tablet and prompt you to pair with another phone.

**This will not combine SMS messages from two phones.** One phone will be the
primary, where all messages are sent and received.

## Why?

I made this for when I go on a trip and don't want to take my primary phone with
me out of the country. I can leave my primary phone plugged in at home and use
this module to pair a second phone that I take with me.

## Better than Google Messages for Web

Google Messages in "tablet" mode is really just a Progressive Web App (PWA)
for Google Messages for Web (https://messages.google.com/web). You _could_ open
Google Messages for Web in Chrome → 3-dot menu → Add to home screen → Install, and 
that would put an icon in your launcher like any other app. I've done this before
and found that it will not stay alive in the background, so I would stop getting
notifications from it shortly after closing it. I had to open the app to check
for new messages.

Using the official Google Messages app in tablet mode (with this module) will
stay open in the background and you will reliably get notifications.

## You can still use SMS

If you install a different SMS app, you can still send normal SMS messages using
that app as long as you only apply this module to Google Messages.

## This will work on any app

There is nothing in this module specific to Google Messages. All it does is tell
whatever app you apply it to that your device does not support SMS. More specifically,
it highjacks calls to [`TelephonyManager.isSmsCapable()`](https://developer.android.com/reference/android/telephony/TelephonyManager#isSmsCapable())
and the newer [`TelephonyManager.isDeviceSmsCapable()`](https://developer.android.com/reference/android/telephony/TelephonyManager#isDeviceSmsCapable())
and always returns `false`.

If you find a use case other than Google Messages device pairing, let me know!

## Installation

1. Make sure the prerequisites are installed:

    - [Magisk](https://github.com/topjohnwu/Magisk/)
    - [LSPosed](https://github.com/JingMatrix/LSPosed)

2. Download [DisableSMS.apk](https://github.com/gabeluci/LSPosed-DisableSMS/releases/latest/download/DisableSMS.apk) and install it.
3. LSPosed should prompt you to enable it. Enable it and select the "Messages"
app from the app list (it will be listed first if it's installed).
4. If you opened the Google Messages app before installing this module, you may
need to delete the app data for it.
5. Open Google Messages and follow the instructions to pair with your primary phone.

Apparently there's a way to run LSPosed modules without root (so I've read).
I've never done that and I don't know if this module would work without root.
If you try it, let me know how it goes.
