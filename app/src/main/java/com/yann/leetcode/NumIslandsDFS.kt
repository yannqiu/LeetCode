package com.yann.leetcode

import java.util.*
import kotlin.collections.ArrayList

class NumIslandsDFS {
    private val stack = ArrayDeque<Location>()
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) {
            return 0
        }
        var landSize = 0
        grid.forEachIndexed { y, chars ->
            grid[y].forEachIndexed { x, char ->
                if (char == '1') {
                    landSize++
                    stack.push(Location(x, y))
                    while (stack.isNotEmpty()) {
                        val top = stack.pop()
                        if (grid[top.y][top.x] == '0') {
                            continue
                        }
                        grid[top.y][top.x] = '0'
                        getNeighborList(top)?.forEach {
                            if (validLand(grid, it.x, it.y)) {
                                stack.push(it)
                            }
                        }
                    }
                }
            }
        }
        return landSize
    }

    private fun validLand(grid: Array<CharArray>, x: Int, y: Int): Boolean {
        return y >= 0 && y < grid.size && x >= 0 && x < grid[y].size && grid[y][x] == '1'
    }

    private fun getNeighborList(current: Location): ArrayList<Location> {
        return arrayListOf(
            Location(current.x - 1, current.y),
            Location(current.x + 1, current.y),
            Location(current.x, current.y + 1),
            Location(current.x, current.y - 1)
        )
    }
}