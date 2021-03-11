package com.yann.leetcode

/**
 * 从中序与后序遍历序列构造二叉树
 *  * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 *
 *
 */
class BuildTree {

    val hashMapInOrderArray = HashMap<Int, Int>()
    var postArray: IntArray? = null
    /**
     * 解题思路
     * 后续遍历的最后一个必位当前字树的根结点
     * 根据根节点在中序遍历中可以区分左子树和右子树
     * 不断的递归确定
     */
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        if (inorder.isEmpty() || postorder.isEmpty()) {
            return null
        }
        inorder.forEachIndexed { index, i ->
            hashMapInOrderArray.put(i, index)
        }
        postArray = postorder
        return buildTree(0, inorder.size -1, 0, postorder.size -1)
    }

    fun buildTree(inorderStart: Int, inorderEnd: Int, postorderStart: Int, postorderEnd: Int): TreeNode {
        if (inorderEnd < inorderStart || postorderEnd < postorderStart) return null
        val root = postArray!![postorderEnd]
        val rootIndexInOrder = hashMapInOrderArray[root]
        val rootNode = TreeNode(root)
        rootNode.left = buildTree(inorderStart, rootIndexInOrder!! - 1, postorderStart, postorderStart + rootIndexInOrder - inorderStart -1)
        rootNode.right = buildTree(rootIndexInOrder + 1, inorderEnd, postorderStart + rootIndexInOrder - inorderStart, postorderEnd - 1)
        return rootNode
    }
}