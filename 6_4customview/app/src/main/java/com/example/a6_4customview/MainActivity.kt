package com.example.a6_4customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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


        // 어댑터 생성 및 연결
        binding.listView.adapter = MyAdapter(this, dataList)

        // 항목 클릭 이벤트 처리
        binding.listView.setOnItemClickListener{ parent, view, position, id ->
            val name: String = (binding.listView.adapter.getItem(position) as MyItem).aName
            Toast.makeText(this," $name 선택!", Toast.LENGTH_SHORT).show()
        }
    }
}