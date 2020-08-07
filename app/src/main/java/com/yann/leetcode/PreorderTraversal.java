package com.yann.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 *  示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.push(root);
        while (!treeNodes.isEmpty()) {
            TreeNode top = treeNodes.pop();
            result.add(top.val);
            if (top.right != null) {
                treeNodes.push(top.right);
            }
            if (top.left != null) {
                treeNodes.push(top.left);
            }
        }
        return result;
    }
}
