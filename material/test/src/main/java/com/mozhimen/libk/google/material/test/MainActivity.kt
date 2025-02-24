package com.mozhimen.libk.google.material.test

import android.os.Bundle
import android.view.Menu
import android.view.View
import com.google.android.material.appbar.MaterialToolbar
import com.mozhimen.kotlin.utilk.android.content.UtilKConfiguration
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.kotlin.utilk.androidx.appcompat.UtilKAppCompatDelegate
import com.mozhimen.libk.google.material.test.activity.BottomNavigationActivity
import com.mozhimen.libk.google.material.test.activity.BottomSheetActivity
import com.mozhimen.libk.google.material.test.activity.CardViewActivity
import com.mozhimen.libk.google.material.test.activity.FloatingActionButtonActivity
import com.mozhimen.libk.google.material.test.activity.SnackbarActivity
import com.mozhimen.libk.google.material.test.activity.SwipeRefreshLayoutActivity
import com.mozhimen.libk.google.material.test.activity.TabLayoutActivity
import com.mozhimen.libk.google.material.test.activity.ToolbarActivity
import com.mozhimen.libk.google.material.test.adapter.MainAdapter
import com.mozhimen.libk.google.material.test.databinding.ActivityMainBinding

class MainActivity : ToolbarActivity<ActivityMainBinding>() {

    override fun initMaterialToolbar(materialToolbar: MaterialToolbar?) {
        super.initMaterialToolbar(materialToolbar)
        materialToolbar?.navigationIcon = null
    }

    override fun initView(savedInstanceState: Bundle?) {
        //回调刷新toolbar的menu，页面初始化或者在需要的时候调用
        invalidateOptionsMenu()

        val mList = mutableListOf(
            getString(R.string.swipe_refresh_layout),
            getString(R.string.floating_action_button),
            getString(R.string.snack_bar),
            getString(R.string.tab_layout),
            getString(R.string.card_view),
            getString(R.string.bottom_navigation),
            getString(R.string.collapsing_toolbar),
            getString(R.string.text_input_layout),
            getString(R.string.search_view),
            getString(R.string.tab_layout_custom_view),
            getString(R.string.drawer_layout),
            getString(R.string.bottom_sheet),
            getString(R.string.material_button),
            getString(R.string.shapeable_image_view),
            getString(R.string.badge_drawable),
            getString(R.string.drag_recyclerview),
            getString(R.string.notification),
            getString(R.string.float_view),
            getString(R.string.guide_line),
            getString(R.string.divider),
            getString(R.string.dynamic_layout)

        )

        val mAdapter = MainAdapter(this, mList)
        vb.recycleView.adapter = mAdapter

        mAdapter.setOnItemClickListener(object : MainAdapter.OnItemClickListener {
            override fun onItemClick(v: View, position: Int) {
                when (position) {
                    0 -> startContext<SwipeRefreshLayoutActivity>()
                    1 -> startContext<FloatingActionButtonActivity>()
                    2 -> startContext<SnackbarActivity>()
                    3 -> startContext<TabLayoutActivity>()
                    4 -> startContext<CardViewActivity>()
                    5 -> startContext<BottomNavigationActivity>()
//                    6 -> startContext<CollapsingToolbarActivity>()
//                    7 -> startContext<TextInputLayoutActivity>()
//                    8 -> startContext<SearchViewActivity>()
//                    9 -> startContext<TabLayoutCustomViewActivity>()
//                    10 -> startContext<DrawerLayoutActivity>()
                    11 -> startContext<BottomSheetActivity>()
//                    12 -> startContext<MaterialButtonActivity>()
//                    13 -> startContext<ShapeableImageViewActivity>()
//                    14 -> startContext<BadgeDrawableActivity>()
//                    15 -> startContext<DragRecyclerViewActivity>()
//                    16 -> startContext<NotificationActivity>()
//                    17 -> startContext<FloatViewActivity>()
//                    18 -> startContext<GuideLineActivity>()
//                    19 -> startContext<DividerActivity>()
//                    20 -> startContext<DynamicLayoutActivity>()
                }
            }
        })

        vb.floatingButton.setOnClickListener {
            if (UtilKConfiguration.isNightMode_ofApp(this))
                UtilKAppCompatDelegate.applyLightMode()
            else
                UtilKAppCompatDelegate.applyNightMode()
        }

        initFloatingButtonImage()
    }

    /**
     * 修改主题后会重建，初始化显示icon
     */
    private fun initFloatingButtonImage() {
        if (UtilKConfiguration.isNightMode_ofApp(this)) {
            vb.floatingButton.setImageResource(R.drawable.ic_day)
        } else {
            vb.floatingButton.setImageResource(R.drawable.ic_night)
        }
    }

    /**
     * 重写onPrepareOptionsMenu，处理toolbar的menu，此处把搜索按钮去掉
     */
    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        //menu.findItem(R.id.action_search).setVisible(false);
        return super.onPrepareOptionsMenu(menu)
    }
}