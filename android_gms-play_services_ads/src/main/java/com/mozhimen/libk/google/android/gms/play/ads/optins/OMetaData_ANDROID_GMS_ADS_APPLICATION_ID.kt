package com.mozhimen.libk.google.android.gms.play.ads.optins

/**
 * @ClassName OMetaData_APPLICATION_ID
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/2/4
 * @Version 1.0
 */
/**
 * // 测试应用id
 * ApplicationId:"ca-app-pub-3940256099942544~3347511713"
 * // 测试插屏广告id
 * InterstitialUnitId:"ca-app-pub-3940256099942544/1033173712"
 * // 测试激励视频广告id
 * RewardedVideoUnitId:"ca-app-pub-3940256099942544/5224354917"
 * // 测试Banner广告id
 * BannerUnitId:"ca-app-pub-3940256099942544/6300978111"
 */
const val ANDROID_GMS_ADS_APPLICATION_ID = """
<manifest>
  <application>
    <!-- Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713 -->
    <meta-data
        android:name="com.google.android.gms.ads.APPLICATION_ID"
        android:value="ca-app-pub-xxxxxxxxxxxxxxxx~yyyyyyyyyy"/>
  </application>
</manifest>
    """

//The flag below optimizes the MobileAds.initialize() initialization call:
const val ANDROID_GMS_ADS_FLAG_OPTIMIZE_INITIALIZATION = """
<manifest>
  <application>
      <meta-data
          android:name="com.google.android.gms.ads.flag.OPTIMIZE_INITIALIZATION"
          android:value="true"/>
  </application>
</manifest>
    """

//The flag below optimizes ad load calls for all ad formats:
const val ANDROID_GMS_ADS_FLAG_OPTIMIZE_AD_LOADING = """
<manifest>
  <application>
      <meta-data
          android:name="com.google.android.gms.ads.flag.OPTIMIZE_AD_LOADING"
          android:value="true"/>
  </application>
</manifest>
    """

const val HARDWARE_ACCELERATED = """
<application android:hardwareAccelerated="true">
    <!-- For activities that use ads, hardwareAcceleration should be true. -->
    <activity android:hardwareAccelerated="true" />
    <!-- For activities that don't use ads, hardwareAcceleration can be false. -->
    <activity android:hardwareAccelerated="false" />
</application>
    """

@RequiresOptIn("The api is must add this metadata to your AndroidManifest.xml. 需要声明此Metadata到你的AndroidManifest.xml $ANDROID_GMS_ADS_APPLICATION_ID", RequiresOptIn.Level.WARNING)
annotation class OMetaData_ANDROID_GMS_ADS_APPLICATION_ID