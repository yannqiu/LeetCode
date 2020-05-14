package com.yann.leetcode

import java.lang.StringBuilder

/**
 *理解Manacher算法的字符串的最长回文
 */
class MlcLongestPalindrome {
    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""
        val changeString = constructString(s)
        val helpArray = IntArray(changeString.length)
        var maxCenterIndex = 0
        var maxRightIndex = 0
        changeString.forEachIndexed { index, c ->
            if (index >= maxRightIndex || index <= maxCenterIndex) {
                val currentRadiu = maxLength(changeString, index)
                helpArray[index] = currentRadiu
                if (currentRadiu > 0 && maxRightIndex < index + currentRadiu) {
                    maxRightIndex = index + currentRadiu
                    maxCenterIndex = index
                }
            } else {
                val iMirrorIndex = maxCenterIndex - (index - maxCenterIndex)
                val mirror = helpArray[iMirrorIndex]
                if (mirror < maxRightIndex - index) {
                    helpArray[index] = mirror
                } else {
                    var left = index - (maxRightIndex - index) - 1
                    var right = maxRightIndex + 1
                    var newCount = 0
                    while (left >= 0 && right < changeString.length && changeString[left] == changeString[right]) {
                        newCount++
                        right++
                        left--
                    }
                    val current = newCount + maxRightIndex - index
                    helpArray[index] = current
                    maxCenterIndex = index
                    maxRightIndex += newCount
                }
            }
        }
        var maxRadiu = 0
        var maxIndex = 0
        helpArray.forEachIndexed { index, i ->
            if (maxRadiu < i) {
                maxRadiu = i
                maxIndex = index
            }
        }
        return s.substring(
            (maxIndex - helpArray[maxIndex]) / 2,
            (maxIndex - helpArray[maxIndex]) / 2 + helpArray[maxIndex]
        )
    }

    /**
     * 为字符串增加字符使得字符串为奇数，两个字符之间增加#
     */
    fun constructString(s: String): String {
        val result = StringBuilder()
        s.forEachIndexed { index, c ->
            result.append('#')
            result.append(c)
        }
        result.append('#')
        return result.toString()
    }

    fun maxLength(s: String, currentIndex: Int): Int {
        var leftIndex = currentIndex - 1
        var rightIndex = currentIndex + 1
        var result = 0
        while (leftIndex >= 0 && rightIndex < s.length && s[leftIndex] == s[rightIndex]) {
            result++
            leftIndex--
            rightIndex++
        }
        return result
    }
}