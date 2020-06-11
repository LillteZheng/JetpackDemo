package com.zhengsr.jetpackdemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zhengsr.jetpackdemo.activity.ViewModelActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datas = listOf("ViewModel","Room")

        val manager = LinearLayoutManager(this)

        recyclerview.layoutManager = manager
        val adapter = ItemAdapter(datas)
        recyclerview.adapter = adapter


        adapter.setOnItemClickListener(object:ItemAdapter.onItemClickListener{
            override fun onItemClick(holder: ItemAdapter.ViewHolder, view: View, position: Int) {
                 when(position){
                     0 -> startActivity<ViewModelActivity>(view.context)
                 }
            }
        })
    }


    inline fun <reified T>startActivity(context:Context){
        val zClass = T::class.java
        val intent = Intent(context,zClass)
        context.startActivity(intent)
    }


    class ItemAdapter(val datas: List<String>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textView: TextView = view.findViewById(R.id.item_text)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false)
            val viewHolder = ViewHolder(view)
            viewHolder.textView.setOnClickListener{
                listener.onItemClick(viewHolder,view,viewHolder.layoutPosition)
            }
            return viewHolder
        }

        override fun getItemCount(): Int {
            return datas.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val msg = datas[position]
            holder.textView.text = msg
        }
        private lateinit var  listener :onItemClickListener;
        fun setOnItemClickListener(listener:onItemClickListener){
            this.listener = listener
        }

         interface onItemClickListener{
           fun onItemClick(holder:ViewHolder,view: View,position: Int)
        }
    }
}