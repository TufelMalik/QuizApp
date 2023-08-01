package com.tufelmalik.quizapp.ui

import android.graphics.ColorSpace.Model
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.tufelmalik.quizapp.R
import com.tufelmalik.quizapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.obottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_email))
//        binding.bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_email))
//        binding.bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.ic_email))
    }
}