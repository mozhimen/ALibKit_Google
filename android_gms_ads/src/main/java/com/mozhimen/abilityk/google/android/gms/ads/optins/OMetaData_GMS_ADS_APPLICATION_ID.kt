package com.mozhimen.abilityk.google.android.gms.ads.optins

import com.mozhimen.abilityk.google.android.gms.ads.cons.CMetaData
import com.mozhimen.basick.manifestk.annors.AManifestKRequire

/**
 * @ClassName OMetaData_APPLICATION_ID
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/2/4
 * @Version 1.0
 */
@AManifestKRequire(CMetaData.GMS_ADS_APPLICATION_ID)
@RequiresOptIn("The api is must add this metadata to your AndroidManifest.xml. 需要声明此Metadata到你的AndroidManifest.xml", RequiresOptIn.Level.WARNING)
annotation class OMetaData_GMS_ADS_APPLICATION_ID