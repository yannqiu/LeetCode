package com.yann.leetcode

/**
 * 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
class LengthOfLongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }
        var maxLength = 0
        val hasSet = hashSetOf<Char>()
        s.forEachIndexed { index, c ->
            hasSet.clear()
            var currentHeadMax = 0
            if (hasSet.add(c)) {
                currentHeadMax++
            }
            for (i in index + 1 until s.length) {
                if (hasSet.add(s[i])) {
                    currentHeadMax++
                } else {
                    if (maxLength < currentHeadMax) {
                        maxLength = currentHeadMax
                    }
                    return@forEachIndexed
                }
            }
            if (maxLength < currentHeadMax) {
                maxLength = currentHeadMax
            }
        }
        return maxLength
    }

    fun lengthOfLongestSubstring(s: String): Int {
        var right = 0
        var left = 0
        val windows = hashMapOf<Char, Int>()
        var maxLength = 0
        while (right < s.length) {
            val temp = s[right]
            windows[temp] = windows.getOrDefault(temp, 0) + 1
            right++
            while (windows.getOrDefault(temp, 0) > 1) {
                val leftTemp = s[left]
                left++
                if (windows.getOrDefault(leftTemp, 0) > 0) {
                    windows[leftTemp] = windows[leftTemp]!! - 1
                }
            }
            maxLength = if (right - left > maxLength) {
                right - left
            } else {
                maxLength
            }
        }
        return maxLength
    }
}