package com.yann.leetcode

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 */
class YanghuiGenerate {

    fun generate(numRows: Int): List<List<Int>> {
        val result: MutableList<List<Int>> = arrayListOf()
        if (numRows == 0) {
            return result
        }
        generate(1, numRows, result)
        return result
    }

    fun generate(currentRow: Int, maxRows: Int, result: MutableList<List<Int>>) {
        if (currentRow > maxRows) {
            return
        }
        val resultLine = arrayListOf<Int>()
        if (currentRow == 1) {
            resultLine.add(1)
        }
        if (currentRow == 2) {
            resultLine.add(1)
            resultLine.add(1)
        }
        if (currentRow > 2) {
            val lastLine = result[currentRow - 2]
            resultLine.add(1)
            for (i in 0..lastLine.size - 2) {
                resultLine.add(lastLine[i] + lastLine[i + 1])
            }
            resultLine.add(1)
        }
        result.add(resultLine)
        generate(currentRow + 1, maxRows, result)
    }
}