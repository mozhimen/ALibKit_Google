package com.mozhimen.libk.google.material.test.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import  com.mozhimen.libk.google.material.test.databinding.ActivityBottomSheetBinding
import com.mozhimen.libk.google.material.test.R
import com.mozhimen.libk.google.material.test.dialog.MyBottomSheetDialog
import com.mozhimen.libk.google.material.test.dialog.MyFullDialog
import com.mozhimen.xmlk.dialogk.bases.commons.IDialogKClickListener
import com.mozhimen.xmlk.dialogk.bottomsheet.bases.BaseDialogKBottomSheet

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
            val bottomSheetDialog =object :BaseDialogKBottomSheet(this,/*,R.style.BottomSheetDialog*/com.mozhimen.xmlk.R.style.ThemeK_Design_Light_BottomSheetDialog_Transparent){
                override fun onCreateView(inflater: LayoutInflater): View? {
                    return inflater.inflate(R.layout.dialog_bottom_sheet, null)
                }

                override fun onViewCreated(view: View) {
                }
            }
//            bottomSheetDialog.setContentView(R.layout.dialog_bottom_sheet)
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