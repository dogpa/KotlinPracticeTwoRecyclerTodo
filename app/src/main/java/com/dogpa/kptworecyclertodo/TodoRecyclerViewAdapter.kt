package com.dogpa.kotlinpractice2recyclerviewtodo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dogpa.kptworecyclertodo.R


class TodoRecyclerViewAdapter(var todos: MutableList<String> ): RecyclerView.Adapter<TodoRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //綁定顯示的元件類似UIKit綁定TableViewCell的delegate作法
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        // 類似UIKit的numberOfRow的delegate 告知Recycler顯示幾個欄位
        return todos.size
    }

    override fun onBindViewHolder(holder: TodoRecyclerViewAdapter.ViewHolder, position: Int) {
        // 設定文字顯示的內容
        holder.titleET.text = todos[position]
    }

    // 建立後onBindViewHolder才能知道在哪個元件顯示想顯示的值。
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var titleET: TextView
        init {
            titleET = itemView.findViewById(R.id.todoTitleTV)
        }
    }
}