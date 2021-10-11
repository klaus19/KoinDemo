package com.tejas.koindemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.tejas.koindemo.R
import com.tejas.koindemo.status.LoadingState
import com.tejas.koindemo.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val userViewModel by viewModel<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        userViewModel.data.observe(this, Observer {
            //Populate the UI
        })

        userViewModel.loadingState.observe(this, Observer {

            //observe the loading state
        })
    }
}