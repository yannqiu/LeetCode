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


    /**
     * 两种方式，都是使用递归
     */
    private val hashMapIndexInOrder = hashMapOf<Int, Int>()
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        inorder.forEachIndexed { index, i ->
            hashMapIndexInOrder.put(i, index)
        }
        return buildTree(0, inorder.size -1, inorder, 0, preorder)
    }

    fun buildTree(leftInOrder: Int, rightInOrder: Int, inorder: IntArray, headIndexInPreOrder: Int, preorder: IntArray): TreeNode? {
        if (leftInOrder == rightInOrder) {
            return TreeNode(inorder[leftInOrder])
        }
        if(leftInOrder > rightInOrder) {
            return null
        }
        val head = preorder[headIndexInPreOrder]

        val headInOrder = hashMapIndexInOrder[head]!!
        val left = buildTree(leftInOrder, headInOrder - 1,inorder, headIndexInPreOrder + 1, preorder)
        val right = buildTree(headInOrder + 1, rightInOrder,inorder, headIndexInPreOrder + headInOrder - leftInOrder + 1, preorder)
        return TreeNode(head).apply {
            this.left = left
            this.right = right
        }
    }
}