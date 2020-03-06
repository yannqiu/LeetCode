package com.yann.leetcode

import java.util.*

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 输入:
11110
11010
11000
00000

输出: 1
 */
class NumIslandsBFS {
    private val locationQueue: Queue<Location> = ArrayDeque()
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) {
            return 0
        }
        var landsSize = 0
        grid.forEachIndexed { y, chars ->
            grid[y].forEachIndexed { x, c ->
                if (c == '1') {
                    locationQueue.add(Location(x, y))
                    landsSize++
                    while (locationQueue.isNotEmpty()) {
                        val top = locationQueue.poll()
                        if (grid[top.y][top.x] == '0') {
                            continue
                        }
                        grid[top.y][top.x] = '0'
                        if (validLand(grid, top.x - 1, top.y)) {
                            locationQueue.add(Location(top.x - 1, top.y))
                        }
                        if (validLand(grid, top.x + 1, top.y)) {
                            locationQueue.add(Location(top.x + 1, top.y))
                        }
                        if (validLand(grid, top.x, top.y - 1)) {
                            locationQueue.add(Location(top.x, top.y - 1))
                        }
                        if (validLand(grid, top.x, top.y + 1)) {
                            locationQueue.add(Location(top.x, top.y + 1))
                        }
                    }
                }
            }
        }
        return landsSize
    }

    private fun validLand(grid: Array<CharArray>, x: Int, y: Int): Boolean {
        return y >= 0 && y < grid.size && x >= 0 && x < grid[y].size && grid[y][x] == '1'
    }
}

class Location(val x: Int, val y: Int)