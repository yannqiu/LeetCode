package com.yann.leetcode

/**
 *  相交链表
 *  给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class GetIntersectionNode {
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        var currentA = headA
        var currentB = headB
        if (currentA == null || currentB == null) {
            return null
        }
        while (currentA != currentB) {
            currentA = if (currentA == null) {
                headB
            } else {
                currentA.next
            }
            currentB = if (currentB == null) {
                headA
            } else {
                currentB.next
            }
        }
        return currentA
    }
}