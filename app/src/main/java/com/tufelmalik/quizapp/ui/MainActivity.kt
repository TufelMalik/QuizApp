package com.tufelmalik.quizapp.ui

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.shashank.sony.fancytoastlib.FancyToast
import com.tufelmalik.quizapp.R
import com.tufelmalik.quizapp.databinding.ActivityMainBinding
import nl.joery.animatedbottombar.AnimatedBottomBar


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        replaceFragment(HomeFragment())
        binding.txtHeadingMain.setTextColor(resources.getColor(R.color.gold))
        setBottomNav()
        setDrawer()



    }

    private fun setBottomNav() {
        binding.mainBottomBar.setOnTabInterceptListener(object : AnimatedBottomBar.OnTabInterceptListener {
            override fun onTabIntercepted(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ): Boolean {
               when(newTab.id){
                   R.id.idHome_menu->{
                       binding.txtHeadingMain.setTextColor(resources.getColor(R.color.gold))
                       binding.txtHeadingMain.text = getText(R.string.app_name)
                       replaceFragment(HomeFragment())
                   }
                   R.id.idLeaderBorad_menu->{
                       binding.txtHeadingMain.setTextColor(resources.getColor(R.color.white))
                       binding.txtHeadingMain.text = getString(R.string.leader_board)
                       replaceFragment(LeaderboardFragment())
                   }
                   R.id.idProfile_menu->{
                       binding.txtHeadingMain.setTextColor(resources.getColor(R.color.white))
                       binding.txtHeadingMain.text = getString(R.string.profile)
                       replaceFragment(ProfileFragment())
                   }
                   else->false
               }
                return true
            }
        })
    }


    private fun setDrawer() {
        actionBarToggle = ActionBarDrawerToggle(this, binding.drawerLayout, 0, 0)
        binding.drawerLayout.addDrawerListener(actionBarToggle)
        actionBarToggle.syncState()
        setDrawerClickListner()
    }

    private fun setDrawerClickListner() {
        binding.btnDrawer.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        binding.navigationView.setNavigationItemSelectedListener {menuItems->
            when (menuItems.itemId) {
                R.id.idNotes_Drawer -> {
                    FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,false).show()
                    true
                }
                R.id.icSettings_Drawer -> {
                    FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show()
                    true
                }
                R.id.idAboutUs_Drawer -> {
                    FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_SHORT,FancyToast.ERROR,false).show()
                    true
                }
                R.id.idSyllbus_Drawer -> {
                    FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_SHORT,FancyToast.CONFUSING,false).show()
                    true
                }
                R.id.idShareApp_Drawer -> {
                    FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_SHORT,FancyToast.DEFAULT,false).show()
                    true
                }
                else->false
            }
        }
    }




    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        binding.drawerLayout.openDrawer(binding.navigationView)
        return true
    }
    override fun onBackPressed() {
        if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            finishAffinity()
            super.onBackPressed()
        }
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else finishAffinity()
    }
}
