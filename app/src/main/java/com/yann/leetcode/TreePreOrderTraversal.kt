package com.yann.leetcode

import java.util.*
import kotlin.collections.ArrayList

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class TreePreOrderTraversal {

    fun preorderTraversal(root: TreeNode?): List<Int> {
        val result = arrayListOf<Int>()
        root?.let{
            displayNumber(result, root)
        }
        return result
    }

    /**
     * 递归算法
     */
    fun displayNumber(result: ArrayList<Int>, currentNode: TreeNode) {
        result.add(currentNode.`val`);
        currentNode.left?.let {
            displayNumber(result, it)
        }
        currentNode.right?.let {
            displayNumber(result, it)
        }
    }

    /**
     * 迭代算法
     */
    fun displayNumber(result: ArrayList<Int>, currentNode: TreeNode) {
        val stackNode = ArrayDeque<TreeNode>()
        stackNode.push(currentNode)
        while (!stackNode.isEmpty()) {
            val top = stackNode.pop()
            result.add(top.`val`)
            top.right?.let{
                stackNode.push(it)
            }
            top.left?.let{
                stackNode.push(it)
            }
        }
    }
}