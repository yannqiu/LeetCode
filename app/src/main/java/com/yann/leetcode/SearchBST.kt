package com.yann.leetcode

/**
 * 二叉搜索树中的搜索
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 */
class SearchBST {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        if(root == null) {
            return null
        }
        if (root.`val` == `val`) {
            return root
        } else if (root.`val` > `val`) {
            return searchBST(root.left, `val`)
        } else {
            return searchBST(root.right, `val`)
        }
    }
}