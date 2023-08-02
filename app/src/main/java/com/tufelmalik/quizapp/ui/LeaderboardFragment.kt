package com.tufelmalik.quizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tufelmalik.quizapp.R
import com.tufelmalik.quizapp.databinding.FragmentLeaderboardBinding

class LeaderboardFragment : Fragment() {
    private lateinit var binding : FragmentLeaderboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = FragmentLeaderboardBinding.inflate(layoutInflater)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return binding.root
        }
    }

