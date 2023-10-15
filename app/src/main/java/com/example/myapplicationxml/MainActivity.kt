package com.example.myapplicationxml

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationxml.databinding.ActivityMainBinding
import com.example.myapplicationxml.view.CustomAdapter
import com.example.myapplicationxml.view.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpUI()
        setUpData()
    }


    private fun setUpUI() {
        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(this@MainActivity, LinearLayout.VERTICAL))
        }
    }

    private fun setUpData() {

        mainViewModel.userDataList.observe(this) {
            /*  it.let {
                  binding.recyclerview.apply {
                      with(adapter as CustomAdapter){
                          dataList = it
                          Log.e("TAG", "set upping data: $dataList")
                          binding.recyclerview.adapter = adapter
                      }
                  }
              }*/

            binding.recyclerview.layoutManager = LinearLayoutManager(this)
            binding.recyclerview.adapter = CustomAdapter(it)
        }

    }
}