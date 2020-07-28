package com.yann.leetcode

/**
 * 猜数字大小
猜数字游戏的规则如下：

每轮游戏，系统都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
如果你猜错了，系统会告诉你这个数字比系统选出的数字是大了还是小了。
你可以通过调用一个预先定义好的接口 guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：

-1 : 系统选出的数字比你猜测的数字小
1 : 系统选出的数字比你猜测的数字大
0 : 恭喜！你猜对了！

示例 :

输入: n = 10, pick = 6
输出: 6
 */

/**
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return         -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */
class GuessNumber {
    override fun guessNumber(n: Int): Int {
        var begin = 1
        var end = n
        while (begin <= end) {
            val middle = begin + (end - begin) / 2
            val result = guess(middle)
            if (result == 0) {
                return middle
            } else if (result == -1) {
                end = middle - 1
            } else if (result == 1) {
                begin = middle + 1
            }
        }
        return 0
    }
}