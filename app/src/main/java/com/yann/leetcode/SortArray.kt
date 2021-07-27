package com.yann.leetcode

/**
 * 912. 排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。
 */
class SortArray {
    fun sortArray(nums: IntArray): IntArray {
        quickSort(nums, 0, nums.size - 1)
        return nums
    }

    fun quickSort(nums: IntArray, left: Int, right: Int) {
        if(left < right) {
            val index = partPosition(nums, left, right)
            quickSort(nums, left, index - 1)
            quickSort(nums, index + 1, right)
        }
    }

    fun partPosition(nums: IntArray, left: Int, right: Int): Int {
        var leftTemp = left
        var rightTemp = right
        val temp = nums[left]
        while (leftTemp < rightTemp) {
            while (leftTemp < rightTemp && nums[rightTemp] >= temp) {
                rightTemp--
            }
            while (leftTemp < rightTemp && nums[leftTemp] <= temp) {
                leftTemp++
            }
            if (leftTemp >= rightTemp) {
                break
            }
            swap(nums, leftTemp, rightTemp)
        }
        swap(nums, left, leftTemp)
        return leftTemp
    }

    fun swap(nums: IntArray, left: Int, right: Int) {
        if (left == right) return
        val temp = nums[left]
        nums[left] = nums[right]
        nums[right] = temp
    }
}