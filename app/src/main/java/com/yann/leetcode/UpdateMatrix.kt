package com.yann.leetcode

import java.util.*
import kotlin.collections.HashSet

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

两个相邻元素间的距离为 1 。

示例 1:
输入:

0 0 0
0 1 0
0 0 0
输出:

0 0 0
0 1 0
0 0 0

示例 2:
输入:

0 0 0
0 1 0
1 1 1
输出:

0 0 0
0 1 0
1 2 1
 */
class UpdateMatrix {
    private val queue: ArrayDeque<Location> = ArrayDeque()
    private val set: HashSet<Location> = hashSetOf()

    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
        val result = Array(matrix.size) {
            IntArray(matrix[it].size)
        }
        for (y in matrix.indices) {
            for (x in matrix[y].indices) {
                set.clear()
                if (matrix[y][x] == 0) {
                    result[y][x] = 0
                    continue
                }
                queue.offer(Location(x, y))
                set.add(Location(x, y))
                var count = -1
                while (queue.isNotEmpty()) {
                    count++
                    val originSize = queue.size
                    for (i in 0 until originSize) {
                        val top = queue.poll()
                        if (matrix[top.y][top.x] == 0) {
                            result[y][x] = count
                            queue.clear()
                            break
                        }
                        var temp = Location(top.x + 1, top.y)
                        if (validLocation(temp, matrix) && set.add(temp)) {
                            queue.offer(temp)
                        }
                        temp = Location(top.x - 1, top.y)
                        if (validLocation(temp, matrix) && set.add(temp)) {
                            queue.offer(temp)
                        }
                        temp = Location(top.x, top.y + 1)
                        if (validLocation(temp, matrix) && set.add(temp)) {
                            queue.offer(temp)
                        }
                        temp = Location(top.x, top.y - 1)
                        if (validLocation(temp, matrix) && set.add(temp)) {
                            queue.offer(temp)
                        }

                    }
                }
            }
        }
        return result
    }

    private fun validLocation(location: Location, matrix: Array<IntArray>): Boolean {
        return location.y in matrix.indices && location.x in matrix[location.y].indices
    }

    private class Location(val x: Int, val y: Int) {
        override fun equals(other: Any?): Boolean {
            if (other !is Location) {
                return false
            }
            return x == other.x && y == other.y
        }
    }
}