package com.tejas.koindemo.model

import com.tejas.koindemo.model.GithubUser
import retrofit2.Call
import retrofit2.http.GET

interface GithubApi {
    @GET("users")
    fun getUsers():Call<List<GithubUser>>
}