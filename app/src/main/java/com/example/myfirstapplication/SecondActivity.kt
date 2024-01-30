package com.example.myfirstapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.myfirstapplication.databinding.RelativeLayoutBinding

class SecondActivity : AppCompatActivity() {

    private var _binding: RelativeLayoutBinding? = null
    private val binding: RelativeLayoutBinding get() = _binding!!
    var imageWord = "dog"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = RelativeLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val text = intent.getStringExtra("username")
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
        loadImageText()
        loadButtonText()
        binding.toolbar.title = text ?: "Empty"

    }

    private fun loadImageText() {
        val size = imageWord.length
        binding.name0.isVisible = size > 0
        binding.name1.isVisible = size > 1
        binding.name2.isVisible = size > 2
        binding.name3.isVisible = size > 3
        binding.name4.isVisible = size > 4
        binding.name5.isVisible = size > 5
        binding.name6.isVisible = size > 6
        binding.name7.isVisible = size > 7
    }

    private fun loadButtonText() {
        binding.character1.text = "T"
        binding.character2.text = "Z"
        binding.character3.text = "A"
        binding.character4.text = "D"
        binding.character5.text = "B"
        binding.character6.text = "A"
        binding.character7.text = "G"
        binding.character8.text = "I"
        binding.character9.text = "F"
        binding.character10.text = "O"
        binding.character11.text = "V"
        binding.character12.text = "G"
        binding.character13.text = "S"
        binding.character14.text = "A"
        binding.character15.text = "D"
        binding.character16.text = "X"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}