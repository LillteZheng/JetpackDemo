package com.zhengsr.jetpackdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.zhengsr.jetpackdemo.R
import com.zhengsr.jetpackdemo.viewmodel.MainViewModel
import com.zhengsr.jetpackdemo.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_view_model.*

class ViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        textcounter.setOnClickListener{
            viewModel.counter ++;

            infoText.text = viewModel.counter.toString()
        }

        infoText.text = viewModel.counter.toString()
    }


}