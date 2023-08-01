package com.tufelmalik.quizapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tufelmalik.quizapp.R
import com.tufelmalik.quizapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
        private lateinit var binding : ActivityLoginBinding
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

            //First change  from the college

    }
}