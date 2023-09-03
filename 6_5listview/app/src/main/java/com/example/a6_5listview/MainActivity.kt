package com.example.a6_5listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a6_4customview.R
import com.example.a6_4customview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 데이터 원본 준비
        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.sample_0, "Bella", "1"))
        dataList.add(MyItem(R.drawable.sample_1, "Charlie", "2"))
        dataList.add(MyItem(R.drawable.sample_2, "Daisy", "1.5"))
        dataList.add(MyItem(R.drawable.sample_3, "Duke", "1"))
        dataList.add(MyItem(R.drawable.sample_4, "Max", "2"))
        dataList.add(MyItem(R.drawable.sample_5, "Happy", "4"))
        dataList.add(MyItem(R.drawable.sample_6, "Luna", "3"))
        dataList.add(MyItem(R.drawable.sample_7, "Bob", "2"))

        binding.recyclerView.adapter = MyAdapter(dataList)

        val adapter = MyAdapter(dataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val name: String = dataList[position].aName
                Toast.makeText(this@MainActivity," $name 선택!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}