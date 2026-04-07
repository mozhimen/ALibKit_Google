package com.mozhimen.libk.google.android.ump.optins

/**
 * @ClassName OMetaData_APPLICATION_ID
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/2/4
 * @Version 1.0
 */
const val GMS_ADS_APPLICATION_ID = """
<manifest>
  <application>
    <!-- Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713 -->
    <meta-data
        android:name="com.google.android.gms.ads.APPLICATION_ID"
        android:value="ca-app-pub-xxxxxxxxxxxxxxxx~yyyyyyyyyy"/>
  </application>
</manifest>
    """

@RequiresOptIn("The api is must add this metadata to your AndroidManifest.xml. 需要声明此Metadata到你的AndroidManifest.xml $GMS_ADS_APPLICATION_ID", RequiresOptIn.Level.WARNING)
annotation class OMetaData_GMS_ADS_APPLICATION_ID