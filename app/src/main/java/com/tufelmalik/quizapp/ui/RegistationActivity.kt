package com.tufelmalik.quizapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tufelmalik.quizapp.ui.MainActivity
import com.tufelmalik.quizapp.R
import com.tufelmalik.quizapp.databinding.ActivityRegistationBinding

class RegistationActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegistationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            startActivity(Intent(this@RegistationActivity, com.tufelmalik.quizapp.ui.MainActivity::class.java))
        }



    }
}