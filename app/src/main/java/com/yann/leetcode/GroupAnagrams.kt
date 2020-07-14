package com.yann.leetcode

/**
 * 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
["ate","eat","tea"],
["nat","tan"],
["bat"]
]

说明：

所有输入均为小写字母。
不考虑答案输出的顺序。
 */
class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val hashMap = HashMap<String, ArrayList<String>>()
        strs.forEach {
            val key = sortString(it)
            val list = hashMap[key] ?: arrayListOf()
            list.add(it)
            hashMap[key] = list
        }
        val result = arrayListOf<List<String>>()
        hashMap.values.forEach {
            result.add(it)
        }
        return result
    }

    fun sortString(s: String): String {
        val chars = s.toCharArray();
        for (i in 1 until chars.size) {
            for (j in i downTo 1) {
                if (chars[j] < chars[j - 1]) {
                    val temp = chars[j]
                    chars[j] = chars[j - 1]
                    chars[j - 1] = temp
                }
            }
        }
        return String(chars)
    }
}