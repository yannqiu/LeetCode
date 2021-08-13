package com.yann.leetcode

/**
 *  反转链表 II
 *  给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class ReverseBetween {

    private var lastNode: ListNode? = null

    /**
     * 递归解决
     */
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (left == 1) {
            return reverseN(head, right)
        }
        head?.next = reverseBetween(head.next, left - 1, right - 1)
        return head
    }

    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (left == 1) {
            return reverseN(head, right)
        }
        var reverseHead = head
        for (i in 0 .. left - 2) {
            reverseHead = reverseHead.next
        }
        reverseHead.next = reverseN(reverseHead.next, right - left + 1)
        return head
    }

    /**
     * 反转前N个元素
     */
    fun reverseN(head: ListNode?, n: Int): ListNode {
        if (n == 1) {
            lastNode = head.next
            return head
        }
        val last = reverseN(head.next, n - 1)
        head.next.next = head
        head.next = lastNode
        return last
    }

    /**
     * 迭代实现
     */
    fun reverseBetween(head: ListNode?, lefft: Int, right: Int): ListNode? {
        var preNode: ListNode? = null
        var currentNode: ListNode? = head
        for (i in 1 until lefft) {
            preNode = currentNode
            currentNode = currentNode?.next
        }
        val originPre = preNode
        val originCurrent = currentNode
        if (preNode != null) {
            preNode.next = null
        }
        for (i in 0..right - lefft) {
            val temp = currentNode?.next
            currentNode?.next = preNode
            preNode = currentNode
            currentNode = temp
        }
        originCurrent?.next = currentNode
        return  if (originPre != null) {
            originPre.next = preNode
            head
        } else {
            preNode
        }
    }

}