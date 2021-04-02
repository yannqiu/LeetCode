package com.yann.leetcode

/**
 * 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
class SwapPairs {

    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null || head.next == null) {
            return head
        }
        val temp = head.next
        head.next = swapPairs(head.next.next)
        temp.next = head
        return temp
    }
}