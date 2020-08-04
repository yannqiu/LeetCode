package com.yann.leetcode

/**
 * 寻找比目标字母大的最小字母
给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。

在比较时，字母是依序循环出现的。举个例子：

如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 

示例：

输入:
letters = ["c", "f", "j"]
target = "a"
输出: "c"

输入:
letters = ["c", "f", "j"]
target = "c"
输出: "f"

输入:
letters = ["c", "f", "j"]
target = "d"
输出: "f"

输入:
letters = ["c", "f", "j"]
target = "g"
输出: "j"

输入:
letters = ["c", "f", "j"]
target = "j"
输出: "c"

输入:
letters = ["c", "f", "j"]
target = "k"
输出: "c"
 

提示：

letters长度范围在[2, 10000]区间内。
letters 仅由小写字母组成，最少包含两个不同的字母。
目标字母target 是一个小写字母。
 */
class NextGreatestLetter {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        if (letters.size == 1) {
            return letters[0]
        }
        val left = letters[0]
        val right = letters[letters.size - 1]
        if (left > target || right <= target) {
            return left
        }
        var begin = 0
        var end = letters.size - 1
        while (begin + 1 < end) {
            val middle = begin + (end - begin) / 2
            val middleResult = letters[middle]
            if (middleResult > target) {
                end = middle
            } else {
                if (letters[middle + 1] > target) {
                    return letters[middle + 1]
                }
                begin = middle + 1
            }
        }
        if (letters[begin] > target) {
            return letters[begin]
        }
        if (letters[end] > target) {
            return letters[end]
        }
        return left
    }
}