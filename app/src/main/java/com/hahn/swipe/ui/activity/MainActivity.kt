package com.hahn.swipe.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hahn.swipe.databinding.ActivityMainBinding
import com.hahn.swipe.ui.recyclerview.adapter.RecyclerAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var rvAdapder = RecyclerAdapter
    private  val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }

}