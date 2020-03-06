package com.yann.leetcode

import java.util.*

/**
 * 使用队列实现栈的下列操作：

push(x) -- 元素 x 入栈
pop() -- 移除栈顶元素
top() -- 获取栈顶元素
empty() -- 返回栈是否为空
注意:
你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 */
class MyStack {
    private var queue = ArrayDeque<Int>()

    /** Initialize your data structure here. */


    /** Push element x onto stack. */
    fun push(x: Int) {
        if (queue.isEmpty()) {
            queue.offer(x)
            return
        }
        val queueTemp = ArrayDeque<Int>()
        queueTemp.offer(x)
        while (queue.isNotEmpty()) {
            queueTemp.offer(queue.poll())
        }
        queue = queueTemp
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int {
        return queue.poll()
    }

    /** Get the top element. */
    fun top(): Int {
        return queue.peek()
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
       return queue.isEmpty()
    }

}