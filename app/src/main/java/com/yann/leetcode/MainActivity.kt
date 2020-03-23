package com.yann.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val result = RemoveDuplicates().removeDuplicates(intArrayOf(0,0,1,1,1,2,2,3,3,4))
        Log.d("Result", "Result is $result")

        val myQueue = MyQueue()
        myQueue.push(1)
        myQueue.push(2)
        myQueue.peek()

    }
}
