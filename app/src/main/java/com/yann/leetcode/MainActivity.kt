package com.yann.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val minStack = MinStack()
        minStack.push(-2)
        minStack.push(0)
        minStack.push(-1)
        minStack.getMin()
        minStack.top()
        minStack.pop()
        minStack.getMin()
    }
}
