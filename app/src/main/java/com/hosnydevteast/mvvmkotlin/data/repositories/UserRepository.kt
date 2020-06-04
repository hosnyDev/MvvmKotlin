package com.hosnydevteast.mvvmkotlin.data.repositories

import com.hosnydevteast.mvvmkotlin.data.network.API
import com.hosnydevteast.mvvmkotlin.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository {

    suspend fun userLogin(email: String, password: String): Response<AuthResponse> {
        return API().userLogin(email, password)
    }

}