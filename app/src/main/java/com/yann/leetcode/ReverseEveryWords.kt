package com.yann.leetcode

/**
 * 反转字符串中的单词 III
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
示例 1:

输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc"
注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
class ReverseEveryWords {
    fun reverseWords(s: String): String {
        val charArray = s.toCharArray()
        var begin = -1
        var end = -1
        charArray.forEachIndexed { index, c ->
            if (c != ' ' && begin == -1) {
                begin = index
            }
            if (begin != -1 && c != ' ') {
                end = index
            }
            if (begin != -1 && end != -1 && (c == ' ' || index == charArray.size - 1)) {
                rever(begin, end, charArray)
                begin = -1
                end = -1
            }
        }
        return String(charArray)
    }

    fun rever(begin: Int, end: Int, origin: CharArray) {
        var beginTemp = begin
        var endTemp = end
        while (beginTemp < endTemp) {
            val temp = origin[beginTemp]
            origin[beginTemp] = origin[endTemp]
            origin[endTemp] = temp
            beginTemp++
            endTemp--
        }
    }
}