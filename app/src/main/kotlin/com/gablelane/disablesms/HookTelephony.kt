package com.gablelane.disablesms

import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage

class HookTelephony : IXposedHookLoadPackage {
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        XposedHelpers.findAndHookMethod(
            "android.telephony.TelephonyManager",
            lpparam.classLoader,
            "isSmsCapable",
            object : XC_MethodHook() {
                override fun beforeHookedMethod(param: MethodHookParam) {
                    param.setResult(false)
                }
            }
        )
        XposedHelpers.findAndHookMethod(
            "android.telephony.TelephonyManager",
            lpparam.classLoader,
            "isDeviceSmsCapable",
            object : XC_MethodHook() {
                override fun beforeHookedMethod(param: MethodHookParam) {
                    param.setResult(false)
                }
            }
        )
    }
}