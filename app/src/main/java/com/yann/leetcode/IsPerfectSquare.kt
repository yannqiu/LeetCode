package com.yann.leetcode

/**
 * 有效的完全平方数
给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。

说明：不要使用任何内置的库函数，如  sqrt。

示例 1：

输入：16
输出：True
示例 2：

输入：14
输出：False
 */
class IsPerfectSquare {
    fun isPerfectSquare(num: Int): Boolean {
        if (num < 2) {
            return true
        }
        var small = 2
        var big = num / 2
        while (small <= big) {
            val temp = small + (big - small) / 2
            val result = temp.toLong() * temp.toLong()
            if (result == num.toLong()) {
                return true
            } else if (result > num) {
                big = temp - 1
            } else {
                small = temp + 1
            }
        }
        return false
    }
}