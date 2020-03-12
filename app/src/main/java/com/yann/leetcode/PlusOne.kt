package com.yann.leetcode


/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
 */
class PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        val size = digits.size
        if (digits[size - 1] != 9) {
            digits[size - 1] = digits[size - 1] + 1
            return digits
        }
        var needAdd = true
        for (i in size - 1 downTo 0) {
            val current = digits[i]
            if (needAdd) {
                if (current == 9) {
                    digits[i] = 0
                    needAdd = true
                } else {
                    digits[i] = current + 1
                    needAdd = false
                }
            } else {
                break
            }
        }
        if (!needAdd) {
            return digits
        }
        val result = IntArray(digits.size + 1)
        result[0] = 1
        for (i in digits.indices) {
            result[i + 1] = digits[i]
        }
        return result
    }
}