package com.yann.leetcode

/**
 * 反转链表
 *
 * 反转一个单链表。
 */
class ReverseList {

    /**
     * 迭代方法
     */
    fun reverseList(head: ListNode?): ListNode? {
        var pre: ListNode? = null
        var current: ListNode? = head
        while (current != null) {
            val temp = current.next
            current.next = pre
            pre = current
            current = temp
        }
        return pre
    }

    /**
     * 递归方法
     */
    fun reverseList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        val last = reverseList(head.next)
        head?.next?.next = head
        head?.next = null
        return last
    }

}