package com.hosnydevteast.mvvmkotlin.ui.auth

import com.hosnydevteast.mvvmkotlin.data.db.entities.User

interface AuthListener {
    fun onStarted()// to show progressbar
    fun onSuccess(user: User)
    fun onFailure(msg: String)
}