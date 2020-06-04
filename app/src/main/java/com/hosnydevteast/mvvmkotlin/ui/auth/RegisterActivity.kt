package com.hosnydevteast.mvvmkotlin.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.hosnydevteast.mvvmkotlin.R
import com.hosnydevteast.mvvmkotlin.data.db.entities.User
import com.hosnydevteast.mvvmkotlin.databinding.ActivityLoginBinding
import com.hosnydevteast.mvvmkotlin.databinding.ActivityRegisterBinding
import com.hosnydevteast.mvvmkotlin.util.alert

class RegisterActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityRegisterBinding=
            DataBindingUtil.setContentView(this, R.layout.activity_register)
        val viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        binding.registerViewModel= viewModel
        viewModel.authListener = this

        findViewById<TextView>(R.id.text_view_login).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()

        }
    }

    override fun onStarted() {
        TODO("Not yet implemented")
    }

    override fun onSuccess(user: User) {
        TODO("Not yet implemented")
    }

    override fun onFailure(msg: String) {
        TODO("Not yet implemented")
    }
}
