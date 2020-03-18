package com.yann.leetcode

/**
 * 旋转数组
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。

 */
class Rotate {
    fun rotate(nums: IntArray, k: Int): Unit {
        for (j in 0 until k) {
            nums.forEachIndexed { index, i ->
                if (index == nums.size - 1) {
                    return@forEachIndexed
                }
                val temp = nums[index + 1]
                nums[index + 1] = nums[0]
                nums[0] = temp
            }
        }
    }

    /**
     * 环状替换
     */
    fun rotate2(nums: IntArray, k: Int) {
        if (k % nums.size == 0) {
            return
        }
        var count = 0
        var i = 0
        while (count < nums.size) {
            var current = i
            var pre  = nums[i]
            do {
                val next = (current + k) % nums.size
                val temp = nums[next]
                nums[next] = pre
                pre = temp
                current = next
                count++
            } while (i != current)
            i++
        }
    }

    /**
     * 首先数组全部反转，然后针对后k个元素和剩下的元素分别反转
     * [1,2,3,4,5,6,7] 和 k = 3
     * [7,6,5,4,3,2,1]
     * [5,6,7,4,3,2,1]
     * [5,6,7,1,2,3,4]
     **/
    fun rotate3(nums: IntArray, k: Int) {
        val real = k % nums.size
        if (real == 0) {
            return
        }
        reverse(nums, 0, nums.size - 1)
        reverse(nums, 0, real - 1)
        reverse(nums, real, nums.size - 1)
        print(nums)
    }

    fun reverse(nums: IntArray, begin: Int, end: Int) {
        var left = begin
        var right = end
        for (i in 0..end - begin) {
            if (left >= right) {
                break
            }
            val temp = nums[right]
            nums[right] = nums[left]
            nums[left] = temp
            left++
            right--
        }
    }
}