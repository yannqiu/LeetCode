package com.yann.leetcode

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * /**
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
class IsSymmetric {
    fun isSymmetric(root: TreeNode?): Boolean {
        return if (root == null) {
            true
        } else {
            recur(root.left, root.right)
        }
    }

    fun recur(left: TreeNode?, right: TreeNode): Boolean {
        if (left == null && right == null) return true
        if (left == null || right == null) return false
        return left.`val` == right.`val` && recur(left.left, right.right) && recur(left.right, right.left)
    }
}