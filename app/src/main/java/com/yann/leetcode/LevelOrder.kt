package com.yann.leetcode

import java.util.*
import kotlin.collections.ArrayList

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 *
 **/
class LevelOrder {

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        val treeNodeQueue = ArrayDeque<TreeNode>()
        if (root == null) {
            return result
        }
        treeNodeQueue.offer(root)
        while (treeNodeQueue.isNotEmpty()) {
            val size = treeNodeQueue.size
            val currentLine = ArrayList<Int>()
            for (i in 0 until size) {
                val current = treeNodeQueue.poll()
                currentLine.add(current.`val`)
                if (current.left != null) {
                    treeNodeQueue.offer(current.left)
                }
                if (current.right != null) {
                    treeNodeQueue.offer(current.right)
                }
            }
            result.add(currentLine)
        }
        return result
    }
}