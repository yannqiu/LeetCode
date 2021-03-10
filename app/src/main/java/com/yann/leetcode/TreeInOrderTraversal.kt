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
class TreeInOrderTraversal {
    fun inorderTraversal(root: TreeNode?): List<Int> {
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
        result.add(currentNode.`val`);
        currentNode.right?.let {
            displayNumber(result, it)
        }
    }

    /**
     * 迭代算法
     */
    fun displayNumber(result: ArrayList<Int>, currentNode: TreeNode) {
        val stackNode = ArrayDeque<NodeEntity>()
        stackNode.push(NodeEntity(currentNode, false))
        while (stackNode.isNotEmpty()) {
            val top = stackNode.pop()
            if (top.hasEnter) {
                result.add(top.treeNode.`val`)
                continue
            }
            val leftNode = top.treeNode.left
            val rightNode = top.treeNode.right
            if (rightNode != null) {
                stackNode.push(NodeEntity(rightNode, false))
            }
            stackNode.push(NodeEntity(top.treeNode, true))
            if (leftNode != null) {
                stackNode.push(NodeEntity(leftNode, false))
            }
        }
    }

    /**
     * 迭代算法(不引入多余的对象)
     */
    fun displayNumber(result: ArrayList<Int>, currentNode: TreeNode) {
        val stackNode = ArrayDeque<NodeEntity>()
        var temp: TreeNode? = currentNode
        while (stackNode.isNotEmpty() || temp != null) {
            while (temp != null) {
                stackNode.push(temp)
                temp = temp.left
            }
            val top = stackNode.pop()
            result.add(top.`val`)
            if (top.right != null) {
                temp = top.right
            }
        }
    }

    class NodeEntity(val treeNode: TreeNode, val hasEnter: Boolean)
}