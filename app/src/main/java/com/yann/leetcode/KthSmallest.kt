package com.yann.leetcode

/**
 *
 *  二叉搜索树中第K小的元素
 *  给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。

 */
class KthSmallest {
    private var currentMin = 0
    private var result: Int = 0
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        kthSmall(root, k)
        return result
    }

    fun kthSmall(root: TreeNode?, k: Int) {
        if (root == null) {
            return
        }
        kthSmall(root.left, k)
        if (++currentMin == k) {
            result = root.`val`
            return
        }
        kthSmall(root.right, k)
    }
}