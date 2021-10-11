package com.tejas.koindemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.auth.User
import com.tejas.adapter.MainAdapter
import com.tejas.koindemo.R
import com.tejas.koindemo.databinding.ActivityMainBinding
import com.tejas.koindemo.model.GithubUser
import com.tejas.koindemo.status.LoadingState
import com.tejas.koindemo.status.LoadingState.Companion.LOADING
import com.tejas.koindemo.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val userViewModel:UserViewModel by viewModel()// we have injected viewModel here using by viewModel

    private lateinit var binding:ActivityMainBinding

    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


          with(userViewModel){

              data.observe(this@MainActivity, Observer {
                  binding.indeterminateBar.visibility = View.GONE
                  adapter?.addData(it)
              })

              loadingState.observe(this@MainActivity, Observer{
                  when(it.status){
                      LoadingState.Status.RUNNING->{
                          binding.indeterminateBar.visibility = View.VISIBLE
                          binding.recyclerView.visibility=View.GONE
                      }
                      LoadingState.Status.FAILED ->{
                          Toast.makeText(this@MainActivity,"Network Error",Toast.LENGTH_LONG).show()
                      }


                  }

              })
          }

    }

}