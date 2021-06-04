package com.yann.leetcode

/**
 * 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 */
class Codec {
    private val treeNodeNull = "null"
    private val treeNodeDivider = "#"
    private val stringBuilder = StringBuilder()

    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        if (root == null) {
            stringBuilder.append(treeNodeNull).append(treeNodeDivider)
            return stringBuilder.toString()
        }
        stringBuilder.append(root!!.`val`).append(treeNodeDivider)
        serialize(root!!.left)
        serialize(root!!.right)
        return stringBuilder.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) {
            return null
        }
        val resultList = ArrayList<String>()
        data.split(treeNodeDivider).forEach {
            resultList.add(it)
        }
        return deserialize(resultList)
    }

    fun deserialize(nodeList: ArrayList<String>): TreeNode? {
        if (nodeList.isEmpty()) {
            return null
        }
        val firstNode = nodeList.removeAt(0)
        if (firstNode.isNullOrEmpty() || firstNode.equals(treeNodeNull)) {
            return null
        }
        val node = TreeNode(firstNode.toInt())
        node.left = deserialize(nodeList)
        node.right = deserialize(nodeList)
        return node
    }
}