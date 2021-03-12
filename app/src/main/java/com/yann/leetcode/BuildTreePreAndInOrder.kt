package com.yann.leetcode

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
注意:
你可以假设树中没有重复的元素。
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class BuildTreePreAndInOrder {

    private val inorderStartHashMap = HashMap<Int, Int>()
    private lateinit var preorderArray: IntArray

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if(preorder.isEmpty() || inorder.isEmpty()) {
            return null
        }
        preorderArray = preorder
        inorder.forEachIndexed { index, i ->
            inorderStartHashMap[i] = index
        }
        return buildTree(0, preorder.size - 1, 0, inorder.size)
    }

    fun buildTree(preorderStart: Int, preorderEnd: Int, inorderStart: Int, inorderEnd: Int): TreeNode? {
        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null
        }
        val rootNumber = preorderArray.get(preorderStart)
        val rootIndexInOrder = inorderStartHashMap[rootNumber]
        val treeNode = TreeNode(rootNumber)
        treeNode.left = buildTree(preorderStart+ 1, preorderStart + rootIndexInOrder!! - inorderStart, inorderStart, rootIndexInOrder -1 )
        treeNode.right = buildTree(preorderStart + rootIndexInOrder - inorderStart + 1, preorderEnd, rootIndexInOrder + 1, inorderEnd)
        return treeNode
    }
}