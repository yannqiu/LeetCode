package com.yann.leetcode

/**
 *  二叉搜索树中的插入操作
 *  给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class InsertIntoBST {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) {
            return TreeNode(`val`)
        }
        if (root.`val` > `val`) {
            root.left = insertIntoBST(root.left, `val`)
        } else {
            root.right = insertIntoBST(root.right, `val`)
        }
        return root
    }
}