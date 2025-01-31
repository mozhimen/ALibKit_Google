package com.mozhimen.libk.google.material.test.activity

import android.os.Bundle
import com.google.android.material.appbar.MaterialToolbar
import com.mozhimen.kotlin.utilk.android.widget.showToast
import com.mozhimen.libk.google.material.test.databinding.ActivityCardViewBinding
import com.mozhimen.libk.google.material.test.R

class CardViewActivity : ToolbarActivity<ActivityCardViewBinding>() {

    override fun initMaterialToolbar(materialToolbar: MaterialToolbar?) {
        super.initMaterialToolbar(materialToolbar)
        materialToolbar?.setTitle(R.string.card_view)
    }

    override fun initView(savedInstanceState: Bundle?) {
        vb.cardViewElevated.setOnClickListener {
            "CardView".showToast()
        }
    }
}