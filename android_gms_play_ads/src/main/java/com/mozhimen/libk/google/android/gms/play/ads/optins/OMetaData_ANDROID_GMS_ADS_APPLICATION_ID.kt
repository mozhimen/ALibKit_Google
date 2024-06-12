package com.mozhimen.libk.google.android.gms.play.ads.optins

import com.mozhimen.libk.google.android.gms.play.ads.cons.CMetaData
import com.mozhimen.basick.manifestk.annors.AManifestKRequire

/**
 * @ClassName OMetaData_APPLICATION_ID
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/2/4
 * @Version 1.0
 */
@AManifestKRequire(CMetaData.ANDROID_GMS_ADS_APPLICATION_ID)
@RequiresOptIn("The api is must add this metadata to your AndroidManifest.xml. 需要声明此Metadata到你的AndroidManifest.xml", RequiresOptIn.Level.WARNING)
annotation class OMetaData_ANDROID_GMS_ADS_APPLICATION_ID