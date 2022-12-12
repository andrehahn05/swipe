package com.hahn.swipe.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hahn.swipe.databinding.ActivityMainBinding
import com.hahn.swipe.model.DataList
import com.hahn.swipe.ui.recyclerview.adapter.RecyclerAdapter

class MainActivity : AppCompatActivity() {

    private  val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var rvAdapter: RecyclerAdapter
    private lateinit var dataList : List<DataList>

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadList()
        configLayoutManage()
        initAdapter()

    }

    private fun configLayoutManage() {
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.rvList.setLayoutManager(layoutManager)
        binding.rvList.setHasFixedSize(true)
    }

    private fun initAdapter() {
        rvAdapter = RecyclerAdapter(dataList)
        binding.rvList.adapter = rvAdapter
    }

    private fun loadList() {
        dataList = listOf(
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