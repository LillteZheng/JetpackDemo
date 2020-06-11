package com.zhengsr.jetpackdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @author by zhengshaorui on 2020/6/11
 * Describe:
 */
class MainViewModelFactory(val count:Int):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return MainViewModel(count) as T
    }
}