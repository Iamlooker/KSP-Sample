package com.looker

import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.*
import java.io.OutputStream

class LeetCodeQuestionVisitor(
    private val file: OutputStream,
    private val logger: KSPLogger
) : KSVisitorVoid() {
    override fun visitFunctionDeclaration(function: KSFunctionDeclaration, data: Unit) {
        if (function.functionKind != FunctionKind.TOP_LEVEL) {
            logger.error("Only top-level functions can be annotated with @LeetCodeQuestion", function)
            return
        }
        if (function.parameters.size != 1) {
            logger.error("Only one parameter allowed", function)
            return
        }

        val annotation: KSAnnotation = function.annotations.first {
            it.shortName.asString() == "LeetCodeQuestion"
        }

        val questionNumber: KSValueArgument = annotation.arguments
            .first { arg -> arg.name?.asString() == "number" }

        val testFunctionName = "testSolution${questionNumber.value}"
        val params = function.parameters.first()
        val returnType = function.returnType

        val testParams  = "${params}: ${params.type.resolve()}, expected: $returnType"

        file += "fun $testFunctionName($testParams) {\n"
        file += "    val output = $function($params)\n"
        file += "    assertEquals(expected, output)\n"
        file += "}\n"
        file += "\n"
    }
}