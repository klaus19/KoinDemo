package com.tejas.koindemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tejas.koindemo.model.GithubUser
import com.tejas.koindemo.repository.UserRepository
import com.tejas.koindemo.status.LoadingState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class UserViewModel(private val repo:UserRepository):ViewModel(),Callback<List<GithubUser>> {

    private val _loadingstate = MutableLiveData<LoadingState>()
    val loadingState:LiveData<LoadingState>
    get() = _loadingstate

    private val _data = MutableLiveData<List<GithubUser>>()
    val data:LiveData<List<GithubUser>>
    get() = _data



    private suspend fun fetchData() {
        _loadingstate.postValue(LoadingState.LOADING)
        repo.getAllUsers().enqueue(this)
    }


    override fun onResponse(call: Call<List<GithubUser>>, response: Response<List<GithubUser>>) {
        if (response.isSuccessful){
            _data.postValue(response.body())
            _loadingstate.postValue(LoadingState.LOADED)

        }else{
            _loadingstate.postValue(LoadingState.error(response.errorBody().toString()))
        }
    }

    override fun onFailure(call: Call<List<GithubUser>>, t: Throwable) {
        _loadingstate.postValue(LoadingState.error(t.message))
    }


}