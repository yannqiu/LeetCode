package com.yann.leetcode

/**
 * 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 *
 *  * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class GenerateTrees {

    fun generateTrees(n: Int): List<TreeNode?> {
        if (n == 0) {
            return emptyList()
        }
        return generateTrees(1, n)
    }

    fun generateTrees(start: Int, end: Int): List<TreeNode?> {
        val allTrees = arrayListOf<TreeNode?>()
        if (start > end) {
            allTrees.add(null)
            return allTrees
        }
        for (i in start..end) {
            val leftTrees = generateTrees(start, i - 1)
            val rightTrees = generateTrees(i + 1, end)
            leftTrees.forEach { leftTree ->
                rightTrees.forEach { rightTree ->
                    val currentNode = TreeNode(i)
                    currentNode.left = leftTree
                    currentNode.right = rightTree
                    allTrees.add(currentNode)
                }
            }
        }
        return allTrees
    }
}