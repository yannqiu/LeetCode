package com.yann.leetcode

import java.util.*

/**
 * 用栈实现队列
 * 使用栈实现队列的下列操作：
push(x) -- 将一个元素放入队列的尾部。
pop() -- 从队列首部移除元素。
peek() -- 返回队列首部的元素。
empty() -- 返回队列是否为空
说明:

你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 */
class MyQueue {
    private val pushStack = ArrayDeque<Int>()
    private val popStack = ArrayDeque<Int>()

    /** Initialize your data structure here. */


    /** Push element x to the back of queue. */
    fun push(x: Int) {
        pushStack.push(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        if (popStack.isEmpty()) {
            while (pushStack.isNotEmpty()) {
                popStack.push(pushStack.pop())
            }
        }
        return popStack.pop()
    }

    /** Get the front element. */
    fun peek(): Int {
        if (popStack.isEmpty()) {
            while (pushStack.isNotEmpty()) {
                popStack.push(pushStack.pop())
            }
        }
        val top = popStack.pop()
        popStack.push(top)
        return top
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {
        return pushStack.isEmpty() && popStack.isEmpty()
    }

}