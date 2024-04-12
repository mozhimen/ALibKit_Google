package com.mozhimen.abilityk.google.android.gms.ads.cons

/**
 * @ClassName CApplication
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/4/1
 * @Version 1.0
 */
object CApplication {
    const val hardwareAccelerated = """
<application android:hardwareAccelerated="true">
    <!-- For activities that use ads, hardwareAcceleration should be true. -->
    <activity android:hardwareAccelerated="true" />
    <!-- For activities that don't use ads, hardwareAcceleration can be false. -->
    <activity android:hardwareAccelerated="false" />
</application>
    """
}