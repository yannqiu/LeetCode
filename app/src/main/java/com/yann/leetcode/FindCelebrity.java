package com.yann.leetcode;
/**
 * 搜寻名人
 *
 * 名人不认识任何其他人，其他人都认识名人，提供boolean knows(int i, int j)方法判断i是否认识j
 *
 */
public class FindCelebrity {

    /**
     * 只告诉总人数，返回名人的编号，没有的话返回-1
     * @param n
     * @return
     */
    int findCelebrity(int n) {
        int cand = 0;
        for (int other = 1; other < n; other++) {
            if (knows(cand, other) || !knows(other, cand)) {
                cand = other;
            }
        }
        for (int other = 0; other < n; other++) {
            if (other == cand) {
                continue;
            }
            if (knows(cand, other) || !knows(other, cand)) {
                return -1;
            }
        }
        return cand;
    }
}
