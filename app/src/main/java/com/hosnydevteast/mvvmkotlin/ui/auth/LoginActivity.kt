package com.hosnydevteast.mvvmkotlin.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hosnydevteast.mvvmkotlin.R
import com.hosnydevteast.mvvmkotlin.data.db.entities.User
import com.hosnydevteast.mvvmkotlin.databinding.ActivityLoginBinding
import com.hosnydevteast.mvvmkotlin.util.alert
import com.hosnydevteast.mvvmkotlin.util.goneProgress
import com.hosnydevteast.mvvmkotlin.util.showProgress
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        binding.loginViewModel = viewModel
        viewModel.authListener = this

        text_view_sign_up.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    RegisterActivity::class.java
                )
            )
        }
    }

    override fun onStarted() {
        login_progress_bar.showProgress()
    }

    override fun onSuccess(user: User) {
        login_progress_bar.goneProgress()
        alert("${user.name} is login")
    }


    override fun onFailure(msg: String) {
        login_progress_bar.goneProgress()
        alert(msg)
    }
}
