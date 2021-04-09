package com.yann.leetcode

/**
 * 最大二叉树
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 * 二叉树的根是数组 nums 中的最大元素。
左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
返回有给定数组 nums 构建的 最大二叉树 。
 */
class ConstructMaximumBinaryTree {
    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        return constructMaximumBinaryTree(nums, 0, nums.size - 1)
    }

    fun constructMaximumBinaryTree(nums: IntArray, left: Int, right: Int): TreeNode? {
        if (left == right) {
            return TreeNode(nums[left])
        } else if (left > right) {
            return null
        }
        var max = nums[left]
        var maxIndex = left
        for (i in left..right) {
            if (max < nums[i]) {
                max = nums[i]
                maxIndex = i
            }
        }
        val left = constructMaximumBinaryTree(nums, left, maxIndex - 1)
        val right = constructMaximumBinaryTree(nums, maxIndex + 1, right)
        return TreeNode(max).apply {
            this.left = left
            this.right = right
        }
    }
}