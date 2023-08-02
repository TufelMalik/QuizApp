package com.tufelmalik.quizapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tufelmalik.quizapp.R
import com.tufelmalik.quizapp.databinding.ActivitySplashBinding
import com.tufelmalik.quizapp.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding : ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGotoSignIn.setOnClickListener {
            startActivity(Intent(this@StartActivity,LoginActivity::class.java))
        }

    }
}