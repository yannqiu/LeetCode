package com.yann.leetcode

/**
 * 扁平化嵌套列表迭代器
 *
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。

列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
class NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     constructor()
 *
 *     // Constructor initializes a single integer.
 *     constructor(value: Int)
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     fun isInteger(): Boolean
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     fun getInteger(): Int?
 *
 *     // Set this NestedInteger to hold a single integer.
 *     fun setInteger(value: Int): Unit
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     fun add(ni: NestedInteger): Unit
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     fun getList(): List<NestedInteger>?
 * }

 */
class NestedIterator(nestedList: List<NestedInteger>) {

    private var currentIndex = -1
    private val resultList = ArrayList<NestedInteger>()
    init {
        nestedList.forEach {
            calculate(it)
        }
    }


    fun next(): Int {
        return resultList[currentIndex].getInteger()
    }

    fun hasNext(): Boolean {
        if (++currentIndex >= resultList.size) {
            return false
        }
        return true
    }

    private fun calculate(nestedInteger: NestedInteger) {
        if (nestedInteger.isInteger()) {
            resultList.add(nestedInteger)
            return
        }
        nestedInteger.getList().forEach {
            calculate(it)
        }
    }
}