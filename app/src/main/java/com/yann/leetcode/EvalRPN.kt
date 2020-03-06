package com.example.yann.waveapplication

import java.util.*

/**
 * 根据逆波兰表示法，求表达式的值。

有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

说明：

整数除法只保留整数部分。
给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
输入: ["2", "1", "+", "3", "*"]
输出: 9
解释: ((2 + 1) * 3) = 9
 */
class EvalRPN {
    private val stack = ArrayDeque<String>()

    fun evalRPN(tokens: Array<String>): Int {
        tokens.forEach {
            if (isCalculate(it)) {
                val number1 = stack.pop()
                val number2 = stack.pop()
                stack.push(getResult(number2,number1, it).toString())
            } else {
                stack.push(it)
            }
        }
        return stack.pop().toInt()

    }

    fun isCalculate(string: String): Boolean {
        return string == "+" || string == "-" || string == "/" || string == "*"
    }

    fun getResult(number1: String, number2: String, symbol: String): Int {
        return when (symbol) {
            "+" -> number1.toInt() + number2.toInt()
            "-" -> number1.toInt() - number2.toInt()
            "*" -> number1.toInt() * number2.toInt()
            "/" -> number1.toInt() / number2.toInt()
            else -> 0
        }
    }
}