package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import com.example.myfirstapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!
    private var isSuccess = false
    val demoPassword = "Parol12345"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.passwordEt.addTextChangedListener {
            binding.passwordLy.helperText = ""
        }
        binding.userNameEt.addTextChangedListener {
            binding.userNameLy.helperText = ""
        }

        binding.loginBtn.setOnClickListener {
            val username = binding.userNameEt.text.toString()
            val password = binding.passwordEt.text.toString()
            if (isCheckUserName(username) && isCheckPassword(password)) {
                if (isSuccess) {
                    if (binding.acceptChb.isChecked) {
                        val intent = Intent(this, SecondActivity::class.java)
                        intent.putExtra("username", binding.userNameEt.text.toString())
                        startActivity(intent)
                    } else
                        Toast.makeText(this, "Wrong", Toast.LENGTH_LONG).show()
                } else {
                    binding.acceptLy.isVisible = true
                    binding.loginBtn.text = "Sign Up"
                    isSuccess = true
                }
            } else if (!isCheckUserName(username)) {
                isSuccess = false
            } else {
                binding.passwordLy.helperText = "Parolda kamchilik bor"
                isSuccess = false
            }
        }
    }

    private fun isCheckUserName(userName: String): Boolean {

        if (userName.isBlank()) {
            binding.userNameLy.helperText = "Username bo`sh bo`lishi mumkin emas"
            return false
        }

        if (!userName.matches(Regex(".*[A-Z].*"))) {
            binding.userNameLy.helperText = "Username kamida bitta bosh harf qatnashishi kerak"
            return false
        }
        if (!userName.matches(Regex(".*[a-z].*"))) {
            binding.userNameLy.helperText = "Username kamida bitta kichik qatnashishi kerak"
            return false
        }
        return true
    }

    private fun isCheckPassword(password: String): Boolean {
        return if (password.equals(demoPassword))
            true
        else
            false
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}