package com.yann.leetcode

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：
输入: "cbbd"
输出: "bb"
 */
class LongestPalindrome {
    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""
        var max = intArrayOf(0, 0)
        s.forEachIndexed { index, c ->
            if (index == 0 || index == s.length - 1) {
                return@forEachIndexed
            }
            val jishu = maxLength(s, index, index)
            val oushu = maxLength(s, index, index + 1)
            if (max[1] - max[0] < jishu[1] - jishu[0]) {
                max = jishu
            }
            if (max[1] - max[0] < oushu[1] - oushu[0]) {
                max = oushu
            }
        }
        return s.substring(max[0], max[1] + 1)
    }

    fun maxLength(s: String, left: Int, right: Int): IntArray {
        var leftIndex = left
        var rightIndex = right
        var result = intArrayOf(0, 0)
        while (leftIndex >= 0 && rightIndex < s.length && s[leftIndex] == s[rightIndex]) {
            result = intArrayOf(leftIndex, rightIndex)
            leftIndex--
            rightIndex++
        }
        return result
    }
}