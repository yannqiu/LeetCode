package com.yann.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val result = FloodFill().floodFill(arrayOf(intArrayOf(0,0,0), intArrayOf(1,0,0)), 1, 0, 2)
        Log.d("Result", "Result is $result")

        val myQueue = MyQueue()
        myQueue.push(1)
        myQueue.push(2)
        myQueue.peek()

    }
}
