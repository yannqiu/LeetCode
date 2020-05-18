package com.yann.leetcode

/**
 * 字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.


注意事项：您可以假定该字符串只包含小写字母。
 */
class FirstUniqChar {
    fun firstUniqChar(s: String): Int {
        val hashMap = HashMap<Char, Int>()
        s.forEachIndexed { index, c ->
            if (!hashMap.containsKey(c)) {
                hashMap[c] = index
            } else {
                hashMap[c] = -1
            }
        }
        var minIndex = -1
        hashMap.values.forEach {
            if (minIndex == -1 || (minIndex > it && it != -1)) {
                minIndex = it
            }
        }
        return minIndex
    }
}