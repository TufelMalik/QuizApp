package com.tufelmalik.quizapp.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.google.android.material.navigation.NavigationView
import com.tufelmalik.quizapp.R
import com.tufelmalik.quizapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigation :  MeowBottomNavigation
    private lateinit var navigationView: NavigationView
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setBottomNav()
        bottomNavClickListners()

        setDrawer()



    }




    private fun setDrawer() {
        actionBarDrawerToggle = ActionBarDrawerToggle(this,binding.drawerLayout,0,0)
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)

        actionBarDrawerToggle.syncState()
        setDrawerClickListner()

    }

    private fun setDrawerClickListner() {
        binding.btnDrawer.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        binding.navigationView.setNavigationItemSelectedListener {menuItems->
            when (menuItems.itemId) {
                R.id.idNotes_Drawer -> {
                    Toast.makeText(this@MainActivity,"Notes",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.icSettings_Drawer -> {
                    Toast.makeText(this@MainActivity,"Settings",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.idAboutUs_Drawer -> {
                    Toast.makeText(this@MainActivity,"About Us",Toast.LENGTH_SHORT).show()
                    true
                }
                else->false
            }
        }
    }

    private fun setBottomNav() {
        bottomNavigation = findViewById<MeowBottomNavigation>(R.id.bottomNav)
        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_home))
        bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_leaderboard))
        bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.ic_person))
        bottomNavigation.show(1)        //Bydefault set to Home
        //  For more Detils -> https://github.com/oneHamidreza/MeowBottomNavigation

    }

    private fun bottomNavClickListners() {
        bottomNavigation.setOnClickMenuListener { model: MeowBottomNavigation.Model? ->




        }

        bottomNavigation.setOnShowListener { model: MeowBottomNavigation.Model? ->


        }
    }

    override fun onSupportNavigateUp(): Boolean {
        binding.drawerLayout.openDrawer(binding.navigationView)
        return true
    }
}
