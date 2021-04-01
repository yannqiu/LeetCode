package com.yann.leetcode

import java.util.*
import kotlin.collections.HashMap

/**
 * 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class LowestCommonAncestor {

    private val parentHashMap: HashMap<TreeNode, TreeNode> = hashMapOf()

    /**
     * 迭代方法
     */
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == p || root == q || root == null) {
            return root
        }
        var pEnter = false
        var qEnter = false
        val queue = ArrayDeque<TreeNode>()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            if (current!!.`val` == p!!.`val`) {
                pEnter = true
            }
            if (current!!.`val` == q!!.`val`) {
                qEnter = true
            }
            if (pEnter && qEnter) {
                break
            }
            current.left?.let{
                parentHashMap.put(it, current)
                queue.offer(it)
            }
            current.right?.let{
                parentHashMap.put(it, current)
                queue.offer(it)
            }
        }
        var pParent = p
        while (pParent != null) {
            var qParent = q
            while (qParent != null) {
                if (pParent.`val` == qParent.`val`) {
                    return qParent
                }
                qParent = parentHashMap[qParent]
            }
            pParent = parentHashMap[pParent]
        }
        return root
    }

    /**
     * 递归
     */
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == root || q == root) {
            return root
        }
        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)
        if (left == null) {
            return right
        }
        if (right == null) {
            return left
        }
        return root
    }
}