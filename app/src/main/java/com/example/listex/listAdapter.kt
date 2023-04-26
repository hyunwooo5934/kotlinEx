package com.example.listex

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listex.model.dayMovieInfo

class listAdapter(private val context : Context) : RecyclerView.Adapter<listAdapter.viewHolder>() {

    var datas = mutableListOf<dayMovieInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bind(datas.get(position))
    }


    inner class viewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val rank : TextView = itemView.findViewById(R.id.rank)
        private val movieNm : TextView = itemView.findViewById(R.id.movieNm)
        private val salesAcc : TextView = itemView.findViewById(R.id.salesAcc)

        fun bind(item: dayMovieInfo){
            rank.text = item.rank
            movieNm.text = item.movieNm
            salesAcc.text = item.salesAcc
        }
    }


}