package com.mozhimen.libk.google.firebase.analytics.helpers

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.ParametersBuilder
import com.google.firebase.analytics.ktx.logEvent
import com.mozhimen.basick.elemk.commons.IExt_Listener
import com.mozhimen.libk.google.firebase.analytics.cons.CLogEvent
import com.mozhimen.libk.google.firebase.analytics.cons.CLogParam

/**
 * @ClassName LogEventProvider
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/12
 * @Version 1.0
 */
class LogEventProvider(private val _firebaseAnalytics: FirebaseAnalytics?) {
    fun screenView(screenName: String, screenClass: String, content: String) {
        logEvent(CLogEvent.SCREEN_VIEW) {
            param(CLogParam.SCREEN_NAME, screenName)
            param(CLogParam.SCREEN_CLASS, screenClass)
            param(CLogParam.CONTENT, content)
        }
    }

    fun selectItem(itemId: String, itemName: String, contentType: String) {
        logEvent(CLogEvent.SELECT_ITEM) {
            param(CLogParam.ITEM_ID, itemId)
            param(CLogParam.ITEM_NAME, itemName)
            param(CLogParam.CONTENT_TYPE, contentType)
        }
    }

    ////////////////////////////////////////////////////////////////////

    //自定义事件
    fun logEvent(name: String, block: IExt_Listener<ParametersBuilder>) {
        _firebaseAnalytics?.logEvent(name, block)
    }
}