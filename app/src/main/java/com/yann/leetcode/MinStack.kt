package com.yann.leetcode

class MinStack() {
    private val origin = arrayListOf<Int>()
    private val sort = arrayListOf<Int>()
    /** initialize your data structure here. */

    fun push(x: Int) {
        origin.add(0, x)
        sort(x)
    }

    fun pop() {
        val top = top()
        top?.let {
            origin.removeAt(0)
            val index = sort.indexOfFirst { sort ->
                sort == it
            }
            sort.removeAt(index)
        }
    }

    fun top(): Int? {
        if (origin.isEmpty()) {
            return null
        }
        return origin[0]
    }

    fun getMin(): Int? {
        if (sort.isEmpty()) {
            return null
        }
        return sort[0]
    }

    fun sort(num: Int) {
        if (sort.isEmpty()) {
            sort.add(num)
            return
        }
        var indexNum = -1
        sort.forEachIndexed { index, numIn ->
            if (num < numIn && indexNum == -1) {
                indexNum = index
            }
        }
        if (indexNum > -1) {
            sort.add(indexNum, num)
        } else {
            sort.add(num)
        }
    }
}