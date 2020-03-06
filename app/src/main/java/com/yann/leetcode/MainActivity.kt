package com.yann.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val result = DecodeString().decodeString("3[a]2[bc]")
        Log.d("Result", "Result is $result")

        val myQueue = MyQueue()
        myQueue.push(1)
        myQueue.push(2)
        myQueue.peek()
    }
}
