package com.yann.leetcode

import java.util.*

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
输入: nums: [1, 1, 1, 1, 1], S: 3
输出: 5
解释:

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

一共有5种方法让最终目标和为3。
注意:

数组非空，且长度不会超过20。
初始的数组的和不会超过1000。
保证返回的最终结果能被32位整数存下。

其实类似于二叉树根结点为0，分叉分别为+和-
 */
class FindTargetSumWays {
    private val stack = ArrayDeque<ResultWithIndex>()
    private val queue = ArrayDeque<ResultWithIndex>()

    fun findTargetSumWays(nums: IntArray, S: Int): Int {
        stack.push(ResultWithIndex(0, -1))
        var count = 0
        while (stack.isNotEmpty()) {
            val top = stack.pop()
            if (top.index == nums.size - 1 && S == top.result) {
                count++
                continue
            }
            getNeighbor(top, nums)?.forEach {
                stack.push(it)
            }
        }
        return count
    }

    fun findTargetSumWaysBFS(nums: IntArray, S: Int): Int {
        queue.offer(ResultWithIndex(0, -1))
        var count = 0
        while (queue.isNotEmpty()) {
            val top = queue.poll()
            if (top.index == nums.size - 1 && S == top.result) {
                count++
                continue
            }
            getNeighbor(top, nums)?.forEach {
                queue.offer(it)
            }
        }
        return count
    }

    private fun getNeighbor(
        resultWithIndex: ResultWithIndex,
        nums: IntArray
    ): List<ResultWithIndex>? {
        if (resultWithIndex.index == nums.size - 1) {
            return null
        }
        return arrayListOf(
            ResultWithIndex(
                resultWithIndex.result + nums[resultWithIndex.index + 1],
                resultWithIndex.index + 1
            ),
            ResultWithIndex(
                resultWithIndex.result - nums[resultWithIndex.index + 1],
                resultWithIndex.index + 1
            )
        )
    }


}

class ResultWithIndex(val result: Int, val index: Int)