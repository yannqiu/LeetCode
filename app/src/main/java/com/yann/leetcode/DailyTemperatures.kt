package com.example.yann.waveapplication

import java.util.*

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
class DailyTemperatures {
    private val stack = ArrayDeque<NumberWithIndex>()
    fun dailyTemperatures(T: IntArray): IntArray {
        val results = IntArray(T.size) {
            0
        }
        T.forEachIndexed { index, i ->
            if (stack.isEmpty()) {
                stack.push(NumberWithIndex(i, index))
                return@forEachIndexed
            }
            while (stack.isNotEmpty()) {
                val top = stack.pop()
                if (top.number < i) {
                    results[top.index] = index - top.index
                    if (stack.isEmpty()) {
                        stack.push(NumberWithIndex(i, index))
                        return@forEachIndexed
                    }
                } else {
                    stack.push(top)
                    stack.push(NumberWithIndex(i, index))
                    return@forEachIndexed
                }
            }
        }
        return results
    }
}

class NumberWithIndex(val number: Int, val index: Int)