package com.yann.leetcode

import java.util.*
import kotlin.collections.HashSet

/**
 * 长度最小的子数组
 *
 *给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。

示例:

输入: s = 7, nums = [2,3,1,2,4,3]
输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
进阶:

如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 */
class MinSubArrayLen {
    fun minSubArrayLen(s: Int, nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var left = 0
        var right = 0
        var currentSize = 1
        var currentSum = nums[0]
        var minSize = 0
        while (left <= right) {
            if (currentSum >= s) {
                if (minSize == 0 || minSize > currentSize) {
                    minSize = currentSize
                }
                currentSum -= nums[left]
                left++
                if (right > nums.size - 1 || left > nums.size - 1) {
                    break
                }
                currentSize--
            } else {
                right++
                if (right > nums.size - 1 || left > nums.size - 1) {
                    break
                }
                currentSum += nums[right]
                currentSize++
            }
        }
        return minSize
    }

}