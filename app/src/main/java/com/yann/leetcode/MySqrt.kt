package com.yann.leetcode

/**
 *   x 的平方根
实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842...,
由于返回类型是整数，小数部分将被舍去。
 */
class MySqrt {

    fun mySqrt(x: Int): Int {
        var begin = 0L
        var end = x.toLong()
        while (begin <= end) {
            val middle = begin + (end - begin) / 2
            val result = middle * middle
            if (result == x.toLong()) {
                return middle.toInt()
            } else if (result < x) {
                val big = (middle + 1) * (middle + 1)
                if (big > x) {
                    return middle.toInt()
                } else if (big == x.toLong()) {
                    return (middle + 1).toInt()
                }
                begin = middle + 1
            } else {
                val small = (middle - 1) * (middle - 1)
                if (small <= x) {
                    return (middle - 1).toInt()
                }
                end = middle - 1
            }
        }
        return -1
    }
}