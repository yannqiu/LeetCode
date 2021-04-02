package com.yann.leetcode

/**
 * 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。
1
1  1
1  2  1
1  3  3  1
1  4  6  4  1
1  5 10 10  5  1
示例:

输入: 3
输出: [1,3,3,1]
进阶：

你可以优化你的算法到 O(k) 空间复杂度吗？

 */
class GetRow {
    fun getRow(rowIndex: Int): List<Int> {
        val result = arrayListOf<Int>()
        for (i in 0 .. rowIndex) {
            result.add(getCResult(i, rowIndex))
        }
        return result
    }

    /**
     * 其实就是公式方法(注意数组越界问题)，还有就是从第一行开始硬算，因为是加的关系不需要考虑数组越界
     */
    fun getCResult(top: Int, bottom: Int): Int {
        if (top == bottom || top == 0) {
            return 1
        }
        var topFinal = top
        if (bottom - top < top) {
            topFinal = bottom - top
        }
        var result = 1L
        var bottomTemp = bottom
        for (i in 0 until topFinal) {
            result = result * bottomTemp / (i + 1)
            bottomTemp--
        }
        return result.toInt()
    }

    /**
     * 递归解法 注意的是rowIndex是从0开始的
     */
    fun getRow(rowIndex: Int): List<Int> {
        return generate(0, rowIndex, arrayListOf(1))
    }

    fun generate(currentRow: Int, rowIndex: Int, lastLine: List<Int>): List<Int> {
        if (currentRow > rowIndex) {
            return lastLine
        }
        if (currentRow == 0) {
            return generate(currentRow + 1, rowIndex, lastLine)
        }
        if (currentRow == 1) {
            return generate(currentRow + 1, rowIndex, arrayListOf(1, 1))
        }
        val resultLine = arrayListOf<Int>()
        if (currentRow > 1) {
            resultLine.add(1)
            for (i in 0..lastLine.size - 2) {
                resultLine.add(lastLine[i] + lastLine[i + 1])
            }
            resultLine.add(1)
        }
        return generate(currentRow + 1, rowIndex, resultLine)
    }
}