package com.yann.leetcode

/**
 * Pow(x, n)
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
class MyPow {
    fun myPow(x: Double, n: Int): Double {
        return if (n >= 0) {
            quick(x, n.toLong())
        } else {
            1.0 / quick(x, -n.toLong())
        }
    }

    fun quick(x: Double, n: Long): Double {
        if (n == 0L) {
            return 1.0
        }
        val tempResult = quick(x, n / 2)
        return if (n % 2 == 1L) {
            tempResult * tempResult * x
        } else {
            tempResult * tempResult
        }
    }

    fun forQuick(x: Double, n: Long): Double {
        var nTemp = n
        var result = 1.0
        var temp = x
        while (nTemp > 0) {
            if (nTemp % 2 == 1L) {
                result *= x
            }
            temp *= temp
            nTemp /= 2
        }
        return result
    }
}