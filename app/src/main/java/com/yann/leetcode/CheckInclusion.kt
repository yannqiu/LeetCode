package com.yann.leetcode

import android.os.Build
import androidx.annotation.RequiresApi

/**
 *  字符串的排列
 *  给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 */
class CheckInclusion {
    @RequiresApi(Build.VERSION_CODES.N)
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.isNullOrEmpty() || s2.isNullOrEmpty() || s1.length > s2.length) {
            return false
        }
        val windows = hashMapOf<Char, Int>()
        val needs = hashMapOf<Char, Int>()
        s1.forEach {
            needs[it] = needs.getOrDefault(it, 0) + 1
        }
        var left = 0
        var right = 0
        var valid = 0
        while (right < s2.length) {
            val temp = s2[right]
            if (needs.containsKey(temp)) {
                windows[temp] = windows.getOrDefault(temp, 0) + 1
                if (windows[temp] == needs[temp]) {
                    valid++
                }
            }
            right++
            while (valid >0 && valid == needs.keys.size) {
                if (right - left == s1.length) {
                    return true
                }
                val leftTemp = s2[left]
                if (needs.containsKey(leftTemp)) {
                    if (windows[leftTemp] == needs[leftTemp]) {
                        valid--
                    }
                    windows[leftTemp] = windows.getOrDefault(leftTemp, 0) - 1
                }
                left++
            }
        }
        return false
    }
}