package com.yann.leetcode

/**
 *  回文链表
 */
class IsPalindrome {

    private var left: ListNode? = null
    fun isPalindrome(head: ListNode?): Boolean {
        left = head
        return comPare(head)
    }

    fun comPare(rightNode: ListNode?): Boolean {
        if (rightNode == null) {
            return true
        }
        val result = comPare(rightNode.next) && left.`val` == rightNode.`val`
        left = left.next
        return result
    }

}