package com.yann.leetcode

import kotlin.math.abs

/**
 * 找到 K 个最接近的元素
给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。

示例 1:

输入: [1,2,3,4,5], k=4, x=3
输出: [1,2,3,4]
 

示例 2:

输入: [1,2,3,4,5], k=4, x=-1
输出: [1,2,3,4]
 

说明:

k 的值为正数，且总是小于给定排序数组的长度。
数组不为空，且长度不超过 10的四次方
数组里的每个元素与 x 的绝对值不超过 10的四次方
 

更新(2017/9/19):
这个参数 arr 已经被改变为一个整数数组（而不是整数列表）。 请重新加载代码定义以获取最新更改。
 */
class FindClosestElements {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        val result = arrayListOf<Int>()
        if (arr.isEmpty()) {
            return emptyList()
        }
        if (x <= arr[0]) {
            for (i in 0 until k) {
                result.add(arr[i])
            }
            return result
        }
        if (x >= arr[arr.size - 1]) {
            for (i in arr.size - k until arr.size) {
                result.add(arr[i])
            }
            return result
        }
        var left = 0
        var right = arr.size - 1
        while (left + 1 < right) {
            var middle = left + (right - left) / 2
            var middleResult = arr[middle]
            if (middleResult == x) {
                var beginIndex: Int = middle
                var endIndex: Int = middle
                for (i in 1 until k) {
                    var leftTemp: Int? = null
                    if (beginIndex - 1 >= 0) {
                        leftTemp = arr[beginIndex - 1]
                    }
                    var rightTemp: Int? = null
                    if (endIndex + 1 < arr.size) {
                        rightTemp = arr[endIndex + 1]
                    }
                    if (leftTemp != null && rightTemp != null) {
                        if (abs(leftTemp - x) > abs(rightTemp - x)) {
                            endIndex++
                        } else {
                            beginIndex--
                        }
                    } else if (rightTemp != null) {
                        endIndex++
                    } else if (leftTemp != null) {
                        beginIndex--
                    } else {
                        break
                    }
                }
                for (i in beginIndex..endIndex) {
                    result.add(arr[i])
                }

                return result
            } else if (middleResult > x) {
                if (arr[middle - 1] <= x) {
                    if (abs(middleResult - x) >= abs(arr[middle - 1] - x)) {
                        middle -= 1
                    }
                    var beginIndex: Int = middle
                    var endIndex: Int = middle
                    for (i in 1 until k) {
                        var leftTemp: Int? = null
                        if (beginIndex - 1 >= 0) {
                            leftTemp = arr[beginIndex - 1]
                        }
                        var rightTemp: Int? = null
                        if (endIndex + 1 < arr.size) {
                            rightTemp = arr[endIndex + 1]
                        }
                        if (leftTemp != null && rightTemp != null) {
                            if (abs(leftTemp - x) > abs(rightTemp - x)) {
                                endIndex++
                            } else {
                                beginIndex--
                            }
                        } else if (rightTemp != null) {
                            endIndex++
                        } else if (leftTemp != null) {
                            beginIndex--
                        } else {
                            break
                        }
                    }
                    for (i in beginIndex..endIndex) {
                        result.add(arr[i])
                    }
                    return result
                }
                right = middle
            } else {
                if (arr[middle + 1] >= x) {
                    if (abs(arr[middle + 1] - x) < abs(arr[middle] - x)) {
                        middle++
                    }
                    var beginIndex: Int = middle
                    var endIndex: Int = middle
                    for (i in 1 until k) {
                        var leftTemp: Int? = null
                        if (beginIndex - 1 >= 0) {
                            leftTemp = arr[beginIndex - 1]
                        }
                        var rightTemp: Int? = null
                        if (endIndex + 1 < arr.size) {
                            rightTemp = arr[endIndex + 1]
                        }
                        if (leftTemp != null && rightTemp != null) {
                            if (abs(leftTemp - x) > abs(rightTemp - x)) {
                                endIndex++
                            } else {
                                beginIndex--
                            }
                        } else if (rightTemp != null) {
                            endIndex++
                        } else if (leftTemp != null) {
                            beginIndex--
                        } else {
                            break
                        }
                    }
                    for (i in beginIndex..endIndex) {
                        result.add(arr[i])
                    }
                    return result
                }
                left = middle
            }
        }
        val leftTemp = arr[left]
        val rightTemp = arr[right]
        var beginIndex = if (abs(rightTemp - x) < abs(leftTemp - x)) {
            right
        } else {
            left
        }
        var endIndex = beginIndex
        for (i in 1 until k) {
            var leftTemp: Int? = null
            if (beginIndex - 1 >= 0) {
                leftTemp = arr[beginIndex - 1]
            }
            var rightTemp: Int? = null
            if (endIndex + 1 < arr.size) {
                rightTemp = arr[endIndex + 1]
            }
            if (leftTemp != null && rightTemp != null) {
                if (abs(leftTemp - x) > abs(rightTemp - x)) {
                    endIndex++
                } else {
                    beginIndex--
                }
            } else if (rightTemp != null) {
                endIndex++
            } else if (leftTemp != null) {
                beginIndex--
            } else {
                break
            }
        }
        for (i in beginIndex..endIndex) {
            result.add(arr[i])
        }
        return result
    }
}