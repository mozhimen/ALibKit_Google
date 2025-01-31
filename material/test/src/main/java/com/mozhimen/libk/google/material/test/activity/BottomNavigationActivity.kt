package com.mozhimen.libk.google.material.test.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.navigation.NavigationBarView
import com.mozhimen.libk.google.material.test.databinding.ActivityBottomNavigationBinding
import com.mozhimen.libk.google.material.test.R
class BottomNavigationActivity : ToolbarActivity<ActivityBottomNavigationBinding>() {

    override fun initMaterialToolbar(materialToolbar: MaterialToolbar?) {
        super.initMaterialToolbar(materialToolbar)
        materialToolbar?.setTitle(R.string.bottom_navigation)
    }

    override fun initView(savedInstanceState: Bundle?) {
        vb.navigation.setOnItemSelectedListener(mOnNavigationItemSelectedListener)
        vb.navigation2.setOnItemSelectedListener(mOnNavigationItemSelectedListener)
        vb.navigation2.selectedItemId = R.id.navigation_dashboard
        vb.navigation3.setOnItemSelectedListener(mOnNavigationItemSelectedListener)
        setBadge(2, 5)
    }

    private val mOnNavigationItemSelectedListener = NavigationBarView.OnItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                vb.message.setText(R.string.title_home)
                return@OnItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                vb.message.setText(R.string.title_dashboard)
                return@OnItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                vb.message.setText(R.string.title_notifications)
                return@OnItemSelectedListener true
            }
            R.id.navigation_test -> {
                vb.message.setText(R.string.title_test)
                return@OnItemSelectedListener true
            }
        }
        false
    }

    /**
     * 给BottomNavigationView 设置Badge 小红点
     *
     * BottomNavigationMenuView中的每一个Tab是一个FrameLayout，所以可以在上面随意添加View、这样就可以实现角标了
     */
    @SuppressLint("RestrictedApi", "MissingInflatedId")
    private fun setBadge(index: Int, count: Int) {
        //获取底部菜单view
        val menuView = vb.navigation3.getChildAt(0) as BottomNavigationMenuView
        //获取第2个itemView
        val itemView = menuView.getChildAt(index) as BottomNavigationItemView
        //引入badgeView
        val badgeView = LayoutInflater.from(this).inflate(R.layout.layout_badge_view, menuView, false)
        //把badgeView添加到itemView中
        itemView.addView(badgeView)
        //获取子view并设置显示数目
        val countView = badgeView.findViewById<TextView>(R.id.tv_badge)
        countView.text = count.toString()

        countView.visibility = if (count > 0) View.VISIBLE else View.GONE
    }
}