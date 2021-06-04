package com.yann.leetcode

/**
 *
 * 扁平化嵌套列表迭代器
 *
 * * class NestedInteger {
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
class NestedIterator2(nestedList: List<NestedInteger>) {

    private val resultList = ArrayList<NestedInteger>()

    init {
        resultList.addAll(nestedList)
    }

    fun next(): Int {
        return resultList.removeAt(0).getInteger()
    }

    fun hasNext(): Boolean {
        while (resultList.isNotEmpty() && !resultList[0].isInteger()) {
            val tempList = resultList.removeAt(0).getList()
            for (i in 0 until tempList.size) {
                resultList.add(i, tempList[i])
            }
        }
        return !resultList.isEmpty()
    }
}