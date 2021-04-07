package com.yann.leetcode

/**
 * 第K个语法符号
 *在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。

给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 *
 */
class KthGrammar {

    fun kthGrammar(N: Int, K: Int): Int {
        val resultArray = getCurrentLine(N)
        return resultArray.getOrNull(K - 1) ?: 0
    }

    /**
     * 空间复杂度过高
     */
    fun getCurrentLine(currentLine: Int): IntArray {
        if (currentLine == 1) {
            return IntArray(1) { 0 }
        }
        val lastLineArray = getCurrentLine(currentLine - 1)
        val newArray = IntArray(lastLineArray.size * 2)
        lastLineArray.forEachIndexed { index, i ->
            if (i == 0) {
                newArray[2 * index] = 0
                newArray[2 * index + 1] = 1
            } else {
                newArray[2 * index] = 1
                newArray[2 * index + 1] = 0
            }
        }
        return newArray
    }

    /**
     * 找规律递归
     */
    fun kthGrammar(N: Int, K: Int): Int {
        if (N == 1) {
            return 0
        }
        val lastNum = kthGrammar(N - 1, (K + 1) / 2)
        if ((K + 1) % 2 == 0) {
            return lastNum
        } else {
            return if (lastNum == 1) {
                0
            } else {
                1
            }
        }
    }
}