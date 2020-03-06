package com.yann.leetcode

import java.lang.StringBuilder
import java.util.*

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例:

s = "3[a]2[bc]", 返回 "aaabcbc".
s = "3[a2[c]]", 返回 "accaccacc".
s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
class DecodeString {
    private val stack = ArrayDeque<String>()
    fun decodeString(s: String): String {
        val numberBuffer = StringBuilder()
        s.forEach {
            if (it != ']') {
                if (it in charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')) {
                    numberBuffer.append(it)
                } else {
                    if (numberBuffer.isNotEmpty()) {
                        stack.push(numberBuffer.toString())
                        numberBuffer.clear()
                    }
                    stack.push(it.toString())
                }
                return@forEach
            }
            val stringStack = ArrayDeque<String>()
            while (stack.isNotEmpty()) {
                val top = stack.pop()
                if (top == "[") {
                    var times  = stack.pop().toInt()
                    val stringBuffer = StringBuffer()
                    while (stringStack.isNotEmpty()) {
                        stringBuffer.append(stringStack.pop())
                    }
                    val copy = stringBuffer.toString()
                    for (i in 1 until times) {
                        stringBuffer.append(copy)
                    }
                    stack.push(stringBuffer.toString())
                    stringStack.clear()
                    return@forEach
                } else {
                    stringStack.push(top)
                }
            }
        }
        val stackTemp = ArrayDeque<String>()
        while (stack.isNotEmpty()) {
            stackTemp.push(stack.pop())
        }
        val string = StringBuffer()
        while (stackTemp.isNotEmpty()) {
            string.append(stackTemp.pop())
        }
        return string.toString()
    }
}