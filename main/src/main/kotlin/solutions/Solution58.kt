package solutions

import Solution
import com.looker.LeetCodeQuestion

class Solution58 : Solution<String, Int> {
    override fun solution(input: String): Int {
        val lastWord = input.trim().split(" ").last()
        return lastWord.length
    }
}

@LeetCodeQuestion(58)
fun lastWordSize(input: String): Int {
    val lastWord = input.trim().split(" ").last()
    return lastWord.length
}