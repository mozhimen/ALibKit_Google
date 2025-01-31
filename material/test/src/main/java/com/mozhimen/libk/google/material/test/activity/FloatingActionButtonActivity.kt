package com.mozhimen.libk.google.material.test.activity

import android.os.Bundle
import com.google.android.material.appbar.MaterialToolbar
import  com.mozhimen.libk.google.material.test.R
import  com.mozhimen.libk.google.material.test.databinding.ActivityFloatingActionButtonBinding

class FloatingActionButtonActivity : ToolbarActivity<ActivityFloatingActionButtonBinding>() {

    override fun initMaterialToolbar(materialToolbar: MaterialToolbar?) {
        super.initMaterialToolbar(materialToolbar)
        materialToolbar?.setTitle(R.string.floating_action_button)
    }

    override fun initView(savedInstanceState: Bundle?) {
        vb.floatingButton.setOnClickListener {
        }
    }
}