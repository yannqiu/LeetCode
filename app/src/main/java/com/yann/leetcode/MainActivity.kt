package com.yann.leetcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val result = IsValidSudoku().isValidSudoku(arrayOf(
            charArrayOf('.','.','4','.','.','.','6','3','.'),
            charArrayOf('.','.','.','.','.','.','.','.','.'),
            charArrayOf('5','.','.','.','.','.','.','9','.'),
            charArrayOf('.','.','.','5','6','.','.','.','.'),
            charArrayOf('4','.','3','.','.','.','.','.','1'),
            charArrayOf('.','.','.','7','.','.','.','.','.'),
            charArrayOf('.','.','.','5','.','.','.','.','.'),
            charArrayOf('.','.','.','.','.','.','.','.','.'),
            charArrayOf('.','.','.','.','.','.','.','.','.')
        ))
        Log.d("Result", "Result is $result")
    }
}
