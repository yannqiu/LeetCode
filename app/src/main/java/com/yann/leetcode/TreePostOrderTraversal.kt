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
class TreePostOrderTraversal {

    fun postorderTraversal(root: TreeNode?): List<Int> {
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
        currentNode.left?.let {
            displayNumber(result, it)
        }
        currentNode.right?.let {
            displayNumber(result, it)
        }
        result.add(currentNode.`val`);
    }

    /**
     * 迭代算法
     */
    fun displayNumber(result: ArrayList<Int>, currentNode: TreeNode) {
        val stackNode = ArrayDeque<NodeEntity>()
        stackNode.push(NodeEntity(currentNode, false))
        while (!stackNode.isEmpty()) {
            val top = stackNode.pop()
            if (top.hasEnter) {
                result.add(top.treeNode.`val`)
                continue
            }
            val leftNode = top.treeNode.left
            val rightNode = top.treeNode.right
            stackNode.push(NodeEntity(top, true))
            if (rightNode != null) {
                stackNode.push(NodeEntity(rightNode, false))
            }
            if (leftNode != null) {
                stackNode.push(NodeEntity(leftNode, false))
            }
         }
    }

    class NodeEntity(val treeNode: TreeNode, val hasEnter: Boolean)
}