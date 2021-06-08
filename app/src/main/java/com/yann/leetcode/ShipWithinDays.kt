package com.yann.leetcode

import kotlin.math.min

/**
 * 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。

传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。

返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 */
class ShipWithinDays {

    fun shipWithinDays(weights: IntArray, days: Int): Int {
        var left = getMaxWeight(weights)
        var right = sumWeight(weights) + 1
        while (left < right) {
            val mid = (left + right) / 2
            if (canShipFinish(weights, mid, days)) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    fun canShipFinish(weights: IntArray, speed: Int, days: Int): Boolean {
        var day = 1
        var currentIndex = 0
        while (day <= days) {
            var currentSpeed = speed
            while ((currentSpeed - weights[currentIndex]) >= 0) {
                currentSpeed -= weights[currentIndex]
                currentIndex++
                if (currentIndex == weights.size - 1) {
                    return true
                }

            }
            day++
        }
        return false
    }

    fun getMaxWeight(weights: IntArray): Int {
        var max = weights[0]
        weights.forEach {
            if (max < it) {
                max = it
            }
        }
        return max
    }

    fun sumWeight(weights: IntArray): Int {
        var sum = 0
        weights.forEach {
            sum += it
        }
        return sum
    }

}