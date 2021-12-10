package com.jmtrue.exampleapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.jmtrue.exampleapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    val fragmentFirst by lazy { FragmentFirst() }
    val fragmentSecond by lazy { FragmentSecond() }
    val fragmentThird by lazy { FragmentThird() }
    val fragmentPost by lazy { FragmentPost() }
    val fragmentLast by lazy { FragmentLast() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        initNavigationBar()

    }

    fun initNavigationBar(){
        binding.container.setOnNavigationItemReselectedListener(BottomNavigationView.OnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.bnv_home ->{ changeFragment(fragmentFirst) }
                R.id.bnv_search ->{ changeFragment(fragmentSecond) }
                R.id.bnv_choice ->{ changeFragment(fragmentThird) }
                R.id.bnv_post ->{ changeFragment(fragmentPost) }
                R.id.bnv_myrecall ->{ changeFragment(fragmentLast) }
            }
            true
        })
    }

    fun changeFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}