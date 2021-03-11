package com.yann.leetcode

import java.util.*

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。

叶子节点 是指没有子节点的节点。

提示：

树中节点的数目在范围 [0, 5000] 内
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000

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
 */
class HasPathSum {

    /**
     * 迭代
     */
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) {
            return false
        }
        val stackNode = ArrayDeque<TreeNode>()
        stackNode.push(root)
        while (stackNode.isNotEmpty()) {
            val top = stackNode.pop()
            if (top.`val` == targetSum && top.left == null && top.right == null) {
                return true
            }
            top.left?.let {
                it.`val` = it.`val` + top.`val`
                stackNode.push(it)
            }
            top.right?.let {
                it.`val` = it.`val` + top.`val`
                stackNode.push(it)
            }
        }
        return false
    }

    /**
     * 递归
     */
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) {
            return false
        }
        return calculateTotal(root, 0, targetSum)
    }

    /**
     * 递归
     */
    fun calculateTotal(treeNode: TreeNode, total: Int, targetSum: Int): Boolean {
        val current = total + treeNode.`val`
        if (treeNode.left == null && treeNode.right == null) {
            return current == targetSum
        }
        if (treeNode.left != null && treeNode.right != null) {
            return calculateTotal(treeNode.left, current, targetSum) || calculateTotal(treeNode.right, current, targetSum)
        }
        if (treeNode.left != null) {
            return calculateTotal(treeNode.left, current, targetSum)
        } else {
            return calculateTotal(treeNode.right, current, targetSum)
        }
    }
}