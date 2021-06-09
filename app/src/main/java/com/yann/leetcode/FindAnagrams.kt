package com.yann.leetcode

/**
 * 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：

字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。

 */
class FindAnagrams {
    fun findAnagrams(s: String, p: String): List<Int> {
        if (s.length < p.length) {
            return emptyList()
        }
        val needs = hashMapOf<Char, Int>()
        val windows = hashMapOf<Char, Int>()
        p.forEach {
            needs[it] = needs.getOrDefault(it, 0) + 1
        }
        var left = 0
        var right = 0
        var valid = 0
        val result = arrayListOf<Int>()
        while (right < s.length) {
            val temp = s[right]
            if (needs.containsKey(temp)) {
                windows[temp] = windows.getOrDefault(temp, 0) + 1
                if (windows[temp] == needs[temp]) {
                    valid++
                }
            }
            right++
            while (valid == needs.keys.size) {
                if (right - left == p.length) {
                    result.add(left)
                }
                val leftTemp = s[left]
                left++
                if (needs.containsKey(leftTemp)) {
                    if (windows[leftTemp] == needs[leftTemp]) {
                        valid--
                    }
                    windows[leftTemp] = windows.getOrDefault(leftTemp, 0) - 1
                }
            }
        }
        return result
    }
}