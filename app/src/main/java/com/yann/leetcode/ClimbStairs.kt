package com.yann.leetcode

/**
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。
 */
class ClimbStairs {
    val result = hashMapOf<Int, Int>()
    fun climbStairs(n: Int): Int {
        if (n < 3) {
            return n
        }
        if (result.containsKey(n)) {
            return result[n]!!
        }
        val current =  climbStairs(n - 1) + climbStairs(n - 2)
        result[n] = current
        return current
    }

}