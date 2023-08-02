package com.tufelmalik.quizapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.tufelmalik.quizapp.R
import com.tufelmalik.quizapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigation :  MeowBottomNavigation
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setBottomNav()
        bottomNavClickListner()
        setBottomNavClickListner()

        setDrawer()



    }

    private fun setBottomNavClickListner() {
        switchFragment(HomeFragment())
        bottomNavigation.setOnClickMenuListener { model: MeowBottomNavigation.Model? ->
            // Handle the item click event here based on the model
            // For example, switch fragments based on the selected model
            model?.let {
                when (it.id) {
                    R.id.idHome_menu -> switchFragment(HomeFragment())
                    R.id.idLeaderBorad_menu -> switchFragment(LeaderboardFragment())
                    R.id.idProfile_menu -> switchFragment(ProfileFragment())

                    else->false

                }
            }
            // Return true if you want to consume the click event or false otherwise
            true
        }

    }

    private fun switchFragment(fragment: Fragment): Any {
        val a = supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .commit()
        return a

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

    private fun bottomNavClickListner() {
        bottomNavigation.setOnClickMenuListener { model: MeowBottomNavigation.Model? ->




        }

        bottomNavigation.setOnShowListener { model: MeowBottomNavigation.Model? ->


        }
    }

    override fun onSupportNavigateUp(): Boolean {
        binding.drawerLayout.openDrawer(binding.navigationView)
        return true
    }
    override fun onBackPressed() {
        if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
