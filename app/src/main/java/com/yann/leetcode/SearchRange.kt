package com.yann.leetcode

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
 */
class SearchRange {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val result = IntArray(2)
        result[0] = -1
        result[1] = -1
        if (nums.isEmpty()) {
            return result
        }
        var left = 0
        var right = nums.size - 1
        while (left + 1 < right) {
            var middle = left + (right - left) / 2
            val middleResult = nums[middle]
            if (middleResult == target) {
                result[0] = middle
                result[1] = middle
                while (--middle >= 0 && nums[middle] == target) {
                    result[0] = middle
                }
                while (++middle < nums.size && nums[middle] == target) {
                    result[1] = middle
                }
                return result
            } else if (middleResult > target) {
                right = middle
            } else {
                left = middle
            }
        }
        if (nums[left] == target) {
            result[0] = left
            result[1] = left
            if (nums[right] == target) {
                result[1] = right
            }
        }
        if (nums[right] == target) {
            result[0] = right
            result[1] = right
            if (nums[left] == target) {
                result[0] = left
            }
        }
        return result
    }
}