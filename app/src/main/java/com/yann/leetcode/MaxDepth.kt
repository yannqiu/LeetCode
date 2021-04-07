package com.yann.leetcode

import java.util.*

/**
 * 二叉树的最大深度
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }

 */
class MaxDepth {

    fun maxDepth(root: TreeNode?): Int {
        var maxDepth = 0
        if (root == null) {
            return maxDepth
        }
        return calculateDepth(root, maxDepth)
    }

    fun calculateDepth(root: TreeNode, currentDepth: Int): Int {
        var maxDepth = currentDepth
        maxDepth++
        val leftDepth = root.left?.let{
            calculateDepth(it, maxDepth)
        } ?: maxDepth
        val rightDepth = root.right?.let{
            calculateDepth(it, maxDepth)
        } ?: maxDepth
        if (maxDepth < leftDepth) {
            maxDepth = leftDepth
        }
        if (maxDepth < rightDepth) {
            maxDepth = rightDepth
        }
        return maxDepth
    }

    /**
     * 广度优先
     */
    fun maxDepth(root: TreeNode?): Int {
        val queue = ArrayDeque<TreeNode>()
        var maxDepth = 0
        root?.let {
            queue.offer(root)
        }
        while (queue.isNotEmpty()) {
            maxDepth++
            for (i in 0 until queue.size) {
                val top = queue.poll()
                top.left?.let {
                    queue.offer(it)
                }
                top.right?.let {
                    queue.offer(it)
                }
            }
        }
        return maxDepth
    }
}