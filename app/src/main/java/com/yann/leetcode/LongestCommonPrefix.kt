package com.yann.leetcode

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
 */
class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        val result = StringBuilder()
        var index = 0
        var encough = false
        if (strs.size == 1) {
            return strs[0]
        }
        while (index < strs.size) {
            if (strs[index] == "") {
                return ""
            }
            if (result.length == strs[index].length) {
                encough = true
            }
            if (index == 0) {
                if (result.isEmpty()) {
                    result.append(strs[0].substring(0, 1))
                } else {
                    if (strs[0].length <= result.length) {
                        return if (result.isEmpty()) {
                            ""
                        } else {
                            result.toString()
                        }
                    }
                    result.append(strs[0].substring(result.length, result.length + 1))
                }
            } else {
                if (strs[index].substring(0, result.length) != result.toString()) {
                    return if (result.isEmpty()) {
                        ""
                    } else {
                        result.substring(0, result.length - 1).toString()
                    }
                }
            }
            index++
            if (index == strs.size) {
                if (encough) {
                    return if (result.isEmpty()) {
                        ""
                    } else {
                        result.toString()
                    }
                }
                index = 0
            }
        }
        return ""
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }
        if (strs.size == 1) {
            return strs[0]
        }
        var minLength = strs[0].length
        strs.forEach {
            if (minLength > it.length) {
                minLength = it.length
            }
        }
        var left = 0
        var right = minLength
        while (left < right) {
            val middle = left + (right - left) / 2
            if (isValid(middle, strs)) {
                left = middle + 1
            } else {
                right = middle
            }
        }
        return strs[0].substring(0, left)
    }

    fun isValid(end: Int, arrayString: Array<String>): Boolean {
        var temp: String? = null
        arrayString.forEach {
            val currentTemp = it.substring(0, end+1)
            if (temp == null) {
                temp = currentTemp
                return@forEach
            }
            if (currentTemp != temp) {
                return false
            }
        }
        return true
    }
}