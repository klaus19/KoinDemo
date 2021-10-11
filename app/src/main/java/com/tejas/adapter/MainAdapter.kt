package com.tejas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.tejas.koindemo.R
import com.tejas.koindemo.model.GithubUser

class MainAdapter(private val users:ArrayList<GithubUser>):
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var textId:AppCompatTextView?=null
        private var textlogin:AppCompatTextView?=null
        private var textavatar:AppCompatTextView?=null
        fun bind(user: GithubUser) {
           textId=itemView.findViewById(R.id.textId)
            textlogin=itemView.findViewById(R.id.textLogin)
            textavatar=itemView.findViewById(R.id.textavatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        DataViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout,parent,
            false)
    )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) = holder.bind(users[position])

    override fun getItemCount(): Int =users.size

    fun addData(list: List<GithubUser>){
        users.addAll(list)
    }
}