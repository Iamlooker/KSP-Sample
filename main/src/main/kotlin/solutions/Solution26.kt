package solutions

import Solution
import com.looker.LeetCodeQuestion

class Solution26 : Solution<IntArray, Int> {
    override fun solution(input: IntArray): Int {
        var size = 0
        var currentValue: Int = -101
        for (value in input) {
            if (value == currentValue) continue
            if (value > currentValue) {
                currentValue = value
                size++
            }
        }
        return size
    }
}

@LeetCodeQuestion(26)
fun duplicateSize(input: IntArray): Int {
    var size = 0
    var currentValue: Int = -101
    for (value in input) {
        if (value == currentValue) continue
        if (value > currentValue) {
            currentValue = value
            size++
        }
    }
    return size
}