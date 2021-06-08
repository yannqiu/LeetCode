package com.yann.leetcode

/**
 *  爱吃香蕉的珂珂
 *  珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。

珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  

珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。

返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。

 */
class MinEatingSpeed {

    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var right = getMax(piles) + 1
        while (left < right) {
            val speed = (left + right) / 2
            if (eatFinish(speed, piles, h)) {
                right = speed
            } else {
                left = speed + 1
            }
        }
        return left
    }

    fun getMax(piles: IntArray): Int {
        var max = piles[0]
        piles.forEach {
            if (max < it) {
                max = it
            }
        }
        return max
    }

    fun eatFinish(speed: Int, piles: IntArray, h: Int): Boolean {
        var time = 0
        piles.forEach {
            time += (it / speed) + if (it % speed > 0) {
                1
            } else {
                0
            }
        }
        return time <= h
    }
}