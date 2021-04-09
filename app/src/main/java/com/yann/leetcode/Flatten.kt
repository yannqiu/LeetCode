package com.yann.leetcode

import java.util.*
import kotlin.collections.ArrayList

/**
 * 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：

展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
class Flatten {
    private val nodeQueue = ArrayList<TreeNode>()

    /**
     * 实用了额外的o(N)的空间
     */
    fun flatten(root: TreeNode?): Unit {
        flatten(root, nodeQueue)
        for (i in 1 until nodeQueue.size) {
            val pre = nodeQueue[i-1]
            val current = nodeQueue[i]
            pre.left = null
            pre.right = current
        }
    }

    fun flatten(root: TreeNode?, nodeQueue: ArrayList<TreeNode>) {
        if (root == null) {
            return
        }
        nodeQueue.add(root)
        flatten(root?.left, nodeQueue)
        flatten(root?.right, nodeQueue)
    }


    fun flatten(root: TreeNode?): Unit {
        if (root == null) {
            return
        }
        flatten(root.left)
        flatten(root.right)

        val left = root.left
        val right = root.right

        root.right = left
        root.left = null

        var temp = root
        while (temp.next != null) {
            temp = temp.right
        }
        temp.right = right
    }

}