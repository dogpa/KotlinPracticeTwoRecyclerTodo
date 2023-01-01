package com.dogpa.kptworecyclertodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dogpa.kotlinpractice2recyclerviewtodo.TodoRecyclerViewAdapter
import com.dogpa.kptworecyclertodo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // ViewBinding
    lateinit var binding: ActivityMainBinding

    // 銜接Recycler的Adapter
    private lateinit var adapter: TodoRecyclerViewAdapter

    // 準備塞給adapter的字串陣列
    var todoMutableList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 指派adapter
        adapter = TodoRecyclerViewAdapter(mutableListOf())

        // 指派recyclerView的adapter與layout
        binding.todoRecyclerView.adapter = adapter
        binding.todoRecyclerView.layoutManager = LinearLayoutManager(this)

        // 設定recyclerView分隔線
        binding.todoRecyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

        // 送出按鈕監聽
        binding.addTodoBt.setOnClickListener {
            val addTitle = binding.inputTodoTitleET.text.toString()
            // 如果輸入的EditText不為空值
            // 將輸入的字加入到todoMutableList的todos後給adapter
            // 接著重新指派更動過後的todos的adapter給todoRecyclerView
            if (addTitle.isNotEmpty()) {
                todoMutableList.add(addTitle)
                adapter.todos = todoMutableList
                binding.todoRecyclerView.adapter = adapter
                binding.inputTodoTitleET.text.clear()
            }
        }
    }
}