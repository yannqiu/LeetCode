package com.yann.leetcode

import kotlin.math.min

/**
 * 二分查找
给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

示例 1:

输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
示例 2:

输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1


提示：

你可以假设 nums 中的所有元素是不重复的。
n 将在 [1, 10000]之间。
nums 的每个元素都将在 [-9999, 9999]之间。
 */
class BinarySearch {
    fun search(nums: IntArray, target: Int): Int {
        return binarySearch(0, nums.size - 1, nums, target)
    }

    fun binarySearch(begin: Int, end: Int, nums: IntArray, target: Int): Int {
        if (begin > end) {
            return -1
        }
        val middle = (begin + end) / 2
        if (nums[middle] == target) {
            return middle
        } else if (nums[middle] < target) {
            return binarySearch(middle + 1, end, nums, target)
        } else {
            return binarySearch(begin, middle - 1, nums, target)
        }
    }


    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val midIndex = (left + right) / 2
            if (nums[midIndex] ==  target) {
                return midIndex
            } else if (nums[midIndex] < target) {
                left = midIndex + 1
            } else if (nums[midIndex] > target) {
                right = midIndex - 1
            }
        }
        return -1
    }
}