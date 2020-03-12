package com.yann.leetcode

/**
 * 在一个给定的数组nums中，总是存在一个最大元素 。

查找数组中的最大元素是否至少是数组中每个其他数字的两倍。

如果是，则返回最大元素的索引，否则返回-1。

示例 1:

输入: nums = [3, 6, 1, 0]
输出: 1
解释: 6是最大的整数, 对于数组中的其他整数,
6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 */
class DominantIndex {
    fun dominantIndex(nums: IntArray): Int {
        if (nums.size == 1) {
            return 0
        }
        var maxNumberIndex = -1
        var maxNumber: Int? = null
        var secondMaxNumber: Int? = null
        nums.forEachIndexed { index, i ->
            if (maxNumber == null) {
                maxNumber = i
                maxNumberIndex = index
                return@forEachIndexed
            }
            if (i > maxNumber!!) {
                secondMaxNumber = maxNumber
                maxNumber = i
                maxNumberIndex = index
                return@forEachIndexed
            }
            if (secondMaxNumber == null || i > secondMaxNumber!!) {
                secondMaxNumber = i
            }

        }
        if (maxNumber == null || secondMaxNumber == null || maxNumber!! < secondMaxNumber!! * 2) {
            return -1
        }
        return maxNumberIndex
    }
}