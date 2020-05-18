package com.yann.leetcode

/**
 * 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

示例 1:

输入: nums = [1,2,3,1], k = 3
输出: true
示例 2:

输入: nums = [1,0,1,1], k = 1
输出: true
示例 3:

输入: nums = [1,2,3,1,2,3], k = 2
输出: false
 */
class ContainsNearbyDuplicate {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val hashMap = HashMap<Int, Int>()
        nums.forEachIndexed { index, num ->
            val tempIndex = hashMap[num]
            if (tempIndex == null) {
                hashMap[num] = index
                return@forEachIndexed
            }
            if (index - tempIndex <= k) {
                return true
            }
            hashMap[num] = index
        }
        return false
    }
}