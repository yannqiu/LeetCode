package com.yann.leetcode

/**
 * 寻找旋转排序数组中的最小值
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。

示例 1:

输入: [3,4,5,1,2]
输出: 1
示例 2:

输入: [4,5,6,7,0,1,2]
输出: 0
 */
class FindMin {
    fun findMin(nums: IntArray): Int {
        val size = nums.size
        if (size == 1) {
            return nums[0]
        }
        var left = 0
        var right = size - 1
        if (nums[right] > nums[left]) {
            return nums[left]
        }
        while (left <= right) {
            val middle = left + (right - left) / 2
            val middleResult = nums[middle]
            if (middleResult > nums[middle + 1]) {
                return nums[middle + 1]
            }
            if (middleResult < nums[middle - 1]) {
                return middleResult
            }
            if (middleResult > nums[0]) {
                left = middle + 1
            } else {
                right = middle - 1
            }
        }
        return -1
    }
}