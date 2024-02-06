package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.example.myfirstapplication.databinding.ActivityMainBinding
import com.example.myfirstapplication.databinding.ActivityThirdBinding
import com.example.myfirstapplication.databinding.RelativeLayoutBinding

class ThirdActivity : AppCompatActivity() {
    private var _binding: ActivityThirdBinding? = null
    private val binding: ActivityThirdBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityThirdBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        val text = intent.getStringExtra("username")
        val correctCount = intent.getStringExtra("correctCount")
        binding.usernameEt.text = text ?: "Empty"
        binding.correctCount.text = correctCount ?: "0"

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}