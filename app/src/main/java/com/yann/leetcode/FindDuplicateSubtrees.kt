package com.yann.leetcode

/**
 * 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。

两棵树重复是指它们具有相同的结构以及相同的结点值。
 */
class FindDuplicateSubtrees {
    private val result = ArrayList<TreeNode>()
    private val allStringHashMap = HashMap<String, Int>()
    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        getTree(root)
        return result
    }

    fun getTree(root: TreeNode?): String {
        if (root == null) {
            return "#"
        }
        val left = getTree(root.left)
        val right = getTree(root.right)
        val finalString = left + ',' + right + ',' + root.`val`
        val count = allStringHashMap.getOrDefault(finalString, 0)
        if (count == 1) {
            result.add(root)
            allStringHashMap[finalString] = count + 1
        } else {
            allStringHashMap[finalString] = count + 1
        }
        return finalString
    }
}