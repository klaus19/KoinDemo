package com.tejas.koindemo.repository

import com.tejas.koindemo.model.GithubApi

class UserRepository(private val api:GithubApi) {

    suspend fun getAllUsers()=api.getUsers()
}