package com.yann.leetcode

import org.w3c.dom.Node
import java.util.*

/**
 * 填充每个节点的下一个右侧节点指针
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

struct Node {
int val;
Node *left;
Node *right;
Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。
 *  * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */
class ConnectPerfectTree {
    /**
     * BFS遍历方式
     * 时间复杂度 o（n）
     * 控件复杂度 o（n）
     */
    fun connect(root: Node?): Node? {
        if (root == null) {
            return null
        }
        val nodeQueue = ArrayDeque<Node>()
        nodeQueue.offer(root)
        while (nodeQueue.isNotEmpty()) {
            val size = nodeQueue.size
            val nodeListThisLine = arrayListOf<Node>()
            for (i in 0 until size) {
                val current = nodeQueue.poll()
                nodeListThisLine.add(current)
                current.left?.let {
                    nodeQueue.offer(it)
                }
                current.right?.let {
                    nodeQueue.offer(it)
                }
            }
            for (i in 0 until nodeListThisLine.size) {
                if (i == nodeListThisLine.size - 1) {
                    nodeListThisLine[i].next = null
                    break
                }
                nodeListThisLine[i].next = nodeListThisLine[i + 1]
            }
        }
        return root
    }

    /**
     * 迭代
     * 时间复杂度 o（n）
     * 空间复杂度 o（1）
     */
    fun connect(root: Node?): Node? {
        if (root == null) {
            return null
        }
        var leftMost = root
        while (leftMost.left != null) {
            leftMost.left.next = leftMost.right
            var leftNext = leftMost.next
            if (leftNext != null) {
                leftMost.right.next = leftNext.left
            }
            while (leftNext != null) {
                leftNext.left.next = leftNext.right
                if (leftNext.next != null) {
                    leftNext.right.next = leftNext.next.left
                }
                leftNext = leftNext.next
            }
            leftMost = leftMost.left
        }
        return root
    }
}