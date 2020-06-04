package com.hosnydevteast.mvvmkotlin.data.network.responses

import com.hosnydevteast.mvvmkotlin.data.db.entities.User

data class AuthResponse(
    val isSuccessful: Boolean?,
    val message: String?,
    val user: User?
)