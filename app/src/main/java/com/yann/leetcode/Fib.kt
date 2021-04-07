package com.yann.leetcode

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 */
class Fib {

    fun fib(n: Int): Int {
        if (n < 2) {
            return n
        }
        return fib(n - 1) + fib(n - 2)
    }
}