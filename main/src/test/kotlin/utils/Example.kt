package utils

import LeetCodeTest
import Solution
import java.util.stream.Stream
import kotlin.test.assertEquals

data class Example<T, R>(
    val input: T,
    val output: R
)

class ExampleTester<T, R>(private val solution: Solution<T, R>) {

    infix fun T.shouldOutput(output: R) {
        val example = Example(this, output)
        solution.assertSolution(example)
    }

}

@Suppress("UNCHECKED_CAST")
fun <I, O> LeetCodeTest.testSolution(block: ExampleTester<I, O>.() -> Unit) {
    val solution = findSolutionClass(findTestName()) as Solution<I, O>
    ExampleTester(solution).block()
}

private fun LeetCodeTest.findSolutionClass(methodName: String): Solution<*, *> {
    val method = javaClass.getDeclaredMethod(methodName)
    val annotation = method.getAnnotation(TestSolution::class.java)
    return annotation?.solution?.java?.getDeclaredConstructor()?.newInstance() as Solution<*, *>
}

private fun findTestName(): String = StackWalker.getInstance().walk { stream: Stream<StackWalker.StackFrame?> ->
    stream.skip(2).findFirst().get()
}.methodName

private fun <T, R> Solution<T, R>.assertSolution(example: Example<T, R>) {
    assertEquals(example.output, solution(example.input))
}