package com.yann.leetcode

import java.util.*

class ValidString {
    private val stack = ArrayDeque<Char>()
    fun isValid(s: String): Boolean {
        if (s.length % 2 == 1) {
            return false
        }
        s.forEach {
            if (right(it)) {
                val pop = stack.poll()
                if (pop == null || !isMatched(pop, it)) {
                    return false
                }
            } else {
                stack.push(it)
            }
        }
        return stack.isEmpty()
    }

    fun isMatched(left: Char, right: Char): Boolean {
        return if (left == '{') {
            right == '}'
        } else if (left == '(') {
            right == ')'
        } else {
            right == ']'
        }
    }

    fun left(c: Char): Boolean {
        return c == '{' || c == '(' || c == '['
    }

    fun right(c: Char): Boolean {
        return c == '}' || c == ')' || c == ']'
    }
}