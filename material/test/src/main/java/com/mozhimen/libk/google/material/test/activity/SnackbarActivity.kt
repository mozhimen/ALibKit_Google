package com.mozhimen.libk.google.material.test.activity

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.snackbar.Snackbar
import com.mozhimen.kotlin.utilk.android.widget.showToast
import com.mozhimen.libk.google.material.test.R
import com.mozhimen.libk.google.material.test.databinding.ActivitySnackbarBinding

class SnackbarActivity : ToolbarActivity<ActivitySnackbarBinding>() {

    override fun initMaterialToolbar(materialToolbar: MaterialToolbar?) {
        super.initMaterialToolbar(materialToolbar)
        materialToolbar?.setTitle(R.string.snack_bar)
    }

    override fun initView(savedInstanceState: Bundle?) {

        vb.button.setOnClickListener {
            Snackbar.make(vb.constraintLayout, "已加入行程", Snackbar.LENGTH_SHORT).show()
        }

        vb.button2.setOnClickListener {
            val mSnackbar = Snackbar.make(vb.constraintLayout, "已加入行程", Snackbar.LENGTH_INDEFINITE)
            mSnackbar.setAction("知道了") {//设置Action并监听事件
                "好的".showToast()
            }.show()
        }

        vb.button3.setOnClickListener {
            val mSnackbar = Snackbar.make(vb.constraintLayout, "已加入行程", Snackbar.LENGTH_INDEFINITE)
            mSnackbar.view.setBackgroundColor(ContextCompat.getColor(this@SnackbarActivity, R.color.colorPrimary))//设置Snackbar的背景颜色
            mSnackbar.setActionTextColor(Color.WHITE)//设置Action文字的背景颜色
            mSnackbar.setAction("知道了") {//设置Action并监听事件
                "好的".showToast()
            }.show()
            mSnackbar.addCallback(object : Snackbar.Callback() {//添加回调
                override fun onDismissed(transientBottomBar: Snackbar, event: Int) {
                    Log.i(TAG, "onDismissed--->> " + "onDismissed")
                }

                override fun onShown(sb: Snackbar) {
                    Log.i(TAG, "onShown--->> " + "onShown")
                }
            })
        }
    }
}