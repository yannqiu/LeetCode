package com.yann.leetcode

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.math.floor
import kotlin.math.sqrt

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *  输入: n = 12
输出: 3
解释: 12 = 4 + 4 + 4.
 */
class NumSquares {
    private val queue = ArrayDeque<Int>()
    private val hasArriveResult = HashSet<Int>()

    fun numSquares(n: Int): Int {
        queue.add(n)
        var step = 1
        if (n == 0) {
            return step
        }
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val top = queue.pop()
                val list = calculateSmallList(top)
                list.forEach {
                    val result = top - it
                    if (result == 0) {
                        return step
                    }
                    if (result > 0 && hasArriveResult.add(result)) {
                        queue.add(result)
                    }
                }
            }
            step++
        }
        return step
    }

    fun calculateSmallList(n: Int): ArrayList<Int> {
        val max: Int = floor(sqrt(n.toDouble())).toInt()
        val smallList = arrayListOf<Int>()
        for (i in 1..max) {
            smallList.add(i * i)
        }
        return smallList
    }

}