package solutions

import Solution
import com.looker.LeetCodeQuestion

class Solution1491 : Solution<IntArray, Double> {
    override fun solution(input: IntArray): Double {
        val newSalary = input.toMutableList()
        newSalary.remove(newSalary.max())
        newSalary.remove(newSalary.min())
        return newSalary.average()
    }
}

@LeetCodeQuestion(1491)
fun averageSalary(input: IntArray): Double {
    val newSalary = input.toMutableList()
    newSalary.remove(newSalary.max())
    newSalary.remove(newSalary.min())
    return newSalary.average()
}