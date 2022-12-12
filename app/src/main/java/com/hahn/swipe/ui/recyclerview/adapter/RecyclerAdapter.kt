package com.hahn.swipe.ui.recyclerview.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hahn.swipe.databinding.ListItemBinding
import com.hahn.swipe.model.DataList

class RecyclerAdapter(var dataList : List<DataList>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent : ViewGroup , viewType : Int) : ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        Log.i("VH" , "vh:${binding} ")
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder : ViewHolder , position : Int) {
        holder.bind(dataList.get(position))
    }

    override fun getItemCount() : Int {
        return dataList.size
    }

    inner class ViewHolder(val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(get : DataList) {
            binding.txtLangName.text = get.name
            binding.txtExp.text = get.exp
        }
    }
}