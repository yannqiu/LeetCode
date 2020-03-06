package com.yann.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val result = FindTargetSumWays().findTargetSumWays(intArrayOf(1,1,1,1,1), 3)
        Log.d("Result", "Result is $result")
    }
}
