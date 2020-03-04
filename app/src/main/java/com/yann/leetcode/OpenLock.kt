package com.yann.leetcode

import java.util.*

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。

锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。

列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。

字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 */
class OpenLock {
    private val queue = ArrayDeque<String>()
    private lateinit var deadends: Array<String>
    private lateinit var target: String
    private val hasArriveNumber = hashSetOf<String>()
    private var step: Int = 0

    fun openLock(deadends: Array<String>, target: String): Int {
        this.deadends = deadends
        this.target = target
        if (target == "0000") {
            return 0
        }
        if (deadends.contains("0000")) {
            return -1
        }
        hasArriveNumber.add(target)
        queue.add(target)
        while (queue.isNotEmpty()) {
            val currentSize = queue.size
            for (i in 0 until currentSize) {
                val top = queue.pop()
                if (top == "0000") {
                    return step
                }
                val list = stepNext(top)
                list.forEach {
                    if (!deadends.contains(it) && hasArriveNumber.add(it)) {
                        queue.add(it)
                    }
                }
            }
            step++
        }
        return -1
    }

    private fun stepNext(number: String): List<String> {
        val results = arrayListOf<String>()
        for (i in 0 until 4) {
            val builder = StringBuffer(number)
            val char = number[i]
            builder.setCharAt(i, if (char == '0') {
                '9'
            } else {
                char - 1
            })
            results.add(builder.toString())
            builder.setCharAt(i, if (char == '9') {
                '0'
            } else {
                char + 1
            })
            results.add(builder.toString())
        }
        return results
    }
}