package com.mozhimen.libk.google.material.test.fragment

import android.os.Bundle
import com.mozhimen.bindk.bases.viewbinding.fragment.BaseFragmentVB
import com.mozhimen.libk.google.material.test.adapter.StringAdapter
import com.mozhimen.libk.google.material.test.databinding.FragmentFragment4Binding

class Fragment4 : BaseFragmentVB<FragmentFragment4Binding>() {

    private var mList: MutableList<String> = mutableListOf()

    override fun initData(savedInstanceState: Bundle?) {
        for (i in 0..19) {
            mList.add("MaterialDesign$i")
        }
        super.initData(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        vb.recycleView.adapter = StringAdapter(activity, mList)
    }
}