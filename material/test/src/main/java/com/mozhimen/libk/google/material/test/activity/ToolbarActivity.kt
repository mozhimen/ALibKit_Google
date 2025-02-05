package com.mozhimen.libk.google.material.test.activity

import android.graphics.Color
import androidx.annotation.CallSuper
import androidx.viewbinding.ViewBinding
import com.google.android.material.appbar.MaterialToolbar
import com.mozhimen.kotlin.utilk.android.widget.showToast
import com.mozhimen.uik.databinding.bases.viewbinding.activity.BaseActivityVB
import com.mozhimen.kotlin.elemk.google.material.CSnackbar
import com.mozhimen.kotlin.utilk.google.material.UtilKSnackbar

abstract class ToolbarActivity<VB : ViewBinding> : BaseActivityVB<VB>() {

    override fun initLayout() {
        super.initLayout()
        val materialToolbar: MaterialToolbar? = findViewById(com.mozhimen.libk.google.material.test.R.id.toolbar)

        initMaterialToolbar(materialToolbar)
    }

    @CallSuper
    protected open fun initMaterialToolbar(materialToolbar: MaterialToolbar?) {
        /**
         * toolbar上back的事件处理
         */
        materialToolbar?.setNavigationOnClickListener {
            finish()
        }

        /**
         * toolbar上menu的事件处理
         */
        materialToolbar?.setOnMenuItemClickListener {
            when (it.itemId) {
                com.mozhimen.libk.google.material.test.R.id.menu_author -> {
                    UtilKSnackbar.make(vb.root, "Snackbar", CSnackbar.LENGTH_SHORT).apply {
                        setAction("好的") {
                            "祝你一夜暴富!".showToast()
                        }
                        show()
                    }
                }

                com.mozhimen.libk.google.material.test.R.id.menu_share -> "分享".showToast()
                com.mozhimen.libk.google.material.test.R.id.menu_settings -> "设置".showToast()
            }
            return@setOnMenuItemClickListener true
        }
    }

    /**
     * 代码获取 ?attr/colorPrimary
     */
    protected fun getAttrColorPrimary(): Int {
        val attribute = intArrayOf(android.R.attr.colorPrimary)
        val array = this.theme.obtainStyledAttributes(attribute)
        val color = array.getColor(0, Color.TRANSPARENT)
        array.recycle()
        return color
    }
}