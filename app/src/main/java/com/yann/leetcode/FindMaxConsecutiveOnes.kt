package com.yann.leetcode


/**
 * 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。

示例 1:

输入: [1,1,0,1,1,1]
输出: 3
解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
注意：

输入的数组只包含 0 和1。
输入数组的长度是正整数，且不超过 10,000。
 */
class FindMaxConsecutiveOnes {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var max = 0
        var current = 0
        nums.forEach {
            if (it == 1) {
                current++
            } else {
                if (max < current) {
                    max = current
                }
                current = 0
            }
        }
        if (max < current) {
            max = current
        }
        return max
    }
}