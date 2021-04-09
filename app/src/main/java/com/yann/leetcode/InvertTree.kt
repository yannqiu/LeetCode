package com.yann.leetcode

/**
 * 翻转二叉树
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 *
 */
class InvertTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        val leftTemp = root.left
        root.left = root.right
        root.right = leftTemp
        invertTree(root.left)
        invertTree(root.right)
        return root
    }
}