package com.hahn.swipe.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hahn.swipe.databinding.ActivityMainBinding
import com.hahn.swipe.model.DataList
import com.hahn.swipe.ui.recyclerview.adapter.RecyclerAdapter
import com.tsuryo.swipeablerv.SwipeLeftRightCallback.Listener


class MainActivity : AppCompatActivity() {

    private  val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var rvAdapter: RecyclerAdapter
    private  var dataList = mutableListOf<DataList>()
    var removeList = mutableListOf<DataList>()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadList()
        removeList = dataList
        configLayoutManage()
        initRecyclerViewAdapter()
        switch()
    }

    private fun configLayoutManage() {
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.rvList.setLayoutManager(layoutManager)
        binding.rvList.setHasFixedSize(true)
    }

    private fun initRecyclerViewAdapter() {
        rvAdapter = RecyclerAdapter(removeList)
        binding.rvList.adapter = rvAdapter
        swipe()
    }

    private fun swipe() {
        binding.rvList.setListener(object : Listener {
            override fun onSwipedLeft(position : Int) {
                removeItem(position)
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onSwipedRight(position : Int) {
                //...
                Toast.makeText(this@MainActivity , "Editar" , Toast.LENGTH_SHORT).show()
                binding.rvList.adapter?.notifyDataSetChanged()
            }
        })
    }

    private fun removeItem(position: Int){
        val build = AlertDialog.Builder(this)
            .setTitle("Deseja remover este item ?")
            .setMessage("Aperte em sim para confirmar ou não para cancelar!")
            .setPositiveButton("Sim"){ _ , _ ->
                removeList.removeAt(position)
                binding.rvList.adapter?.notifyItemRemoved(position)
            }
            .setNegativeButton("Não"){ _ , _ ->
                binding.rvList.adapter?.notifyDataSetChanged()
            }
        val dialog = build.create()
        dialog.show()
    }

    private fun switch() {
        binding.btnDarkMode.setOnCheckedChangeListener { compoundButton , isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    private fun loadList() {
        dataList = mutableListOf(
            DataList("Java" , "Exp : 3 anos"),
            DataList("C#" , "Exp : 7 anos"),
            DataList("Kotlin" , "Exp : 3 anos"),
            DataList("Python" , "Exp : 4 anos"),
            DataList("JavaScript" , "Exp : 6 anos"),
            DataList("C" , "Exp : 5 anos"),
            DataList("C++" , "Exp : 5 anos"),
            DataList("Rust", "Exp: 2 anos"),
            DataList("Swift", "Exp: 3 anos"),
            DataList("Perl", "Exp: 2 anos"),
            DataList("Delphi", "Exp: 2 anos"),
            DataList("PHP" , "Exp : 1/2 ano"),

        )
    }

}