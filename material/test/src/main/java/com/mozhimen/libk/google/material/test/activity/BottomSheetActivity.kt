package com.mozhimen.libk.google.material.test.activity

import android.os.Bundle
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import  com.mozhimen.libk.google.material.test.databinding.ActivityBottomSheetBinding
import  com.mozhimen.libk.google.material.test.dialog.MyBottomSheetDialog
import com.mozhimen.libk.google.material.test.R
import com.mozhimen.libk.google.material.test.dialog.MyFullDialog

class BottomSheetActivity : ToolbarActivity<ActivityBottomSheetBinding>() {

    override fun initMaterialToolbar(materialToolbar: MaterialToolbar?) {
        super.initMaterialToolbar(materialToolbar)
        materialToolbar?.setTitle(R.string.bottom_sheet)
    }

    override fun initView(savedInstanceState: Bundle?) {

        vb.btnBottomSheet.setOnClickListener {
            val behavior = BottomSheetBehavior.from(vb.llBottomSheet)
            if (behavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                //如果是展开状态，则关闭，反之亦然
                behavior.state = BottomSheetBehavior.STATE_COLLAPSED
            } else {
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }

        vb.btnBottomSheetDialog.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(this)
            bottomSheetDialog.setContentView(R.layout.dialog_bottom_sheet)
            bottomSheetDialog.show()
        }

        vb.btnBottomSheetDialogFragment.setOnClickListener {
            MyBottomSheetDialog().show(supportFragmentManager, "MyBottomSheetDialog")
        }

        vb.btnFull.setOnClickListener {
            MyFullDialog().show(supportFragmentManager, "MyFullDialog")
        }
    }

}