package com.yann.leetcode

/**
 * 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
一般来说，删除节点可分为两个步骤：

首先找到需要删除的节点；
如果找到了，删除它。
说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 */
class DeleteNode {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) {
            return null
        }
        if (root.`val` == key) {
            if (root.left == null) {
                return root.right
            } else if (root.right == null) {
                return root.left
            } else {
                val leftMax: TreeNode = getLeftMaxNode(root.left)
                root.`val` = leftMax.`val`
                leftMax.`val` = key
                root.left = deleteNode(root.left, key)
                return root
            }
        } else if (root.`val` < key) {
            root.right = deleteNode(root.right, key)
        } else {
            root.left = deleteNode(root.left, key)
        }
        return root
    }

    fun getLeftMaxNode(root: TreeNode): TreeNode {
        if (root.right == null) {
            return root
        }
        return getLeftMaxNode(root.right)
    }
}