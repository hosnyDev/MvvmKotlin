package com.hosnydevteast.mvvmkotlin.ui.auth

import android.util.Patterns
import android.view.View
import androidx.lifecycle.ViewModel
import com.hosnydevteast.mvvmkotlin.data.repositories.UserRepository
import com.hosnydevteast.mvvmkotlin.util.Coroutines

class AuthViewModel : ViewModel() {

    var authListener: AuthListener? = null
    var email: String? = null
    var password: String? = null
    var cPassword: String? = null
    var name: String? = null

    fun onLoginButtonClick() {

        authListener?.onStarted()

        // validation error
        if (email.isNullOrEmpty()) {
            authListener?.onFailure("Please add your email")
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            authListener?.onFailure("Please add valid email")
            return
        }

        if (password.isNullOrEmpty()) {
            authListener?.onFailure("Please add your password")

            return
        }


        if (password!!.length < 6) {
            authListener?.onFailure("password must be 6 char")

            return
        }

        Coroutines.main {
            // when all data is success
            val loginResponse = UserRepository().userLogin(email!!, password!!)
            if (loginResponse.isSuccessful)
                authListener?.onSuccess(loginResponse.body()?.user!!)
            else
                authListener?.onFailure("Error code ${loginResponse.code()}")
        }

    }

    fun onRegisterClickButton(view: View) {


        // validation error
        if (name.isNullOrEmpty()) {
            authListener?.onFailure("Please add your name")
            return
        }

        if (email.isNullOrEmpty()) {
            authListener?.onFailure("Please add your email")
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            authListener?.onFailure("Please add valid email")
            return
        }

        if (password.isNullOrEmpty()) {
            authListener?.onFailure("Please add your password")

            return
        }


        if (password!!.length < 6) {
            authListener?.onFailure("password must be 6 char")
            return
        }

        if (!password.equals(cPassword)) {
            authListener?.onFailure("tow password is not matches")
            return
        }

        Coroutines.main {
            // when all data is success
            val loginResponse = UserRepository().userLogin(email!!, password!!)
            if (loginResponse.isSuccessful) {
                authListener?.onSuccess(loginResponse.body()?.user!!)
            }
        }
    }


}