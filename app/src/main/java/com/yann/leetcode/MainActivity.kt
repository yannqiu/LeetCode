package com.yann.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val result = GroupAnagrams().groupAnagrams(arrayListOf("eat","tea","tan","ate","nat","bat"))
        Log.d("Result", "Result is $result")
    }
}
