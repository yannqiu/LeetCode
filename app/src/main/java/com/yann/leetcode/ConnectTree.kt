package com.yann.leetcode

import org.w3c.dom.Node

/**
 * 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树

struct Node {
int val;
Node *left;
Node *right;
Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。
 */
class ConnectTree {
    fun connect(root: Node?): Node? {
        if (root == null) {
            return root
        }
        var leftMostThisLine: Node? = root
        while (leftMostThisLine != null) {
            getTwoUnNextNode(leftMostThisLine).let {
                var first = it.first
                var second = it.second
                var currentParent = it.third
                while (first != null && second != null) {
                    first.next = second
                    getTwoUnNextNode(currentParent).let {
                        first = it.first
                        second = it.second
                        currentParent = it.third
                    }
                }
            }
            leftMostThisLine = getNextMostLeftNode(leftMostThisLine)
        }
        return root
    }

    fun getTwoUnNextNode(node: Node?): Triple<Node?,Node?, Node?> {
        var currentParent: Node? = node
        var firstNode: Node? = null
        var secondNode: Node? = null
        while (currentParent != null) {
            val left = currentParent.left
            val right = currentParent.right
            if (left != null && left.next == null) {
                if (firstNode == null) {
                    firstNode = left
                } else if (secondNode == null && secondNode != firstNode) {
                    secondNode = left
                }
            }
            if (firstNode != null && secondNode != null) {
                return Triple(firstNode, secondNode, currentParent)
            }
            if (right != null && right.next == null) {
                if (firstNode == null) {
                    firstNode = right
                } else if (secondNode == null && secondNode != firstNode) {
                    secondNode = right
                }
            }
            if (firstNode != null && secondNode != null) {
                return Triple(firstNode, secondNode, currentParent)
            }
            currentParent = currentParent.next
        }
        return Triple(firstNode, secondNode, currentParent)
    }

    fun getNodeMoreLeft(node: Node): Node? {
        return node.left ?: node.right
    }


    fun getNextMostLeftNode(node: Node): Node? {
        var temp = getNodeMoreLeft(node)
        while (temp != null) {
            if (getNodeMoreLeft(temp) != null) {
                return temp
            }
            temp = temp.next
        }
        return null
    }
}