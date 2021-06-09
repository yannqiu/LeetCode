package com.yann.leetcode

import android.os.Build
import androidx.annotation.RequiresApi

/**
 * 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 */
class MinWindow {
    @RequiresApi(Build.VERSION_CODES.N)
    fun minWindow(s: String, t: String): String {
        if (s.isNullOrEmpty() || t.isNullOrEmpty()) {
            return ""
        }
        var needs = hashMapOf<Char, Int>()
        var windows = hashMapOf<Char, Int>()
        t.forEach {
            needs[it] = needs.getOrDefault(it, 0) + 1
        }
        var left = 0
        var right = 0
        var length = Int.MAX_VALUE
        var start = 0
        var valid = 0
        while (right < s.length) {
            val temp = s[right]
            if (needs.containsKey(temp)) {
                windows[temp] = windows.getOrDefault(temp, 0) + 1
                if (windows[temp] == needs[temp]) {
                    valid++
                }
            }
            right++
            while (valid > 0 && valid == needs.keys.size) {
                if (right - left < length) {
                    start = left
                    length = right - left
                }
                val leftTemp = s[left]
                if (needs.containsKey(leftTemp)) {
                    if (windows[leftTemp] == needs[leftTemp]) {
                         valid--
                     }
                    windows[leftTemp] = windows.getOrDefault(leftTemp, 0) - 1
                }
                left++
            }
        }
        return if (length == Int.MAX_VALUE) {
            ""
        } else {
            s.substring(start, start + length)
        }
    }
}