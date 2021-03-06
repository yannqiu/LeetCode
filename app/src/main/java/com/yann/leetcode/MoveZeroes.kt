package com.yann.leetcode

/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
 */
class MoveZeroes {
    fun moveZeroes(nums: IntArray): Unit {
        var zero = -1
        var noZero = -1
        nums.forEachIndexed { index, number ->
            if (number == 0) {
                for (i in index + 1 until nums.size) {
                    val temp = nums[i]
                    if (temp != 0) {
                        exchangeNumber(index, i, nums)
                        return@forEachIndexed
                    }
                }
            }
        }
    }

    fun exchangeNumber(begin: Int, end: Int, nums: IntArray) {
        if (begin == end) {
            return
        }
        val temp = nums[begin]
        nums[begin] = nums[end]
        nums[end] = temp
    }
}