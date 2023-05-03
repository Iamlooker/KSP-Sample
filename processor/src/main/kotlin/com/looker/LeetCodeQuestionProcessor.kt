package com.looker

import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.google.devtools.ksp.validate
import java.io.OutputStream

operator fun OutputStream.plusAssign(str: String) {
    this.write(str.toByteArray())
}

class LeetCodeQuestionProcessor(
    private val logger: KSPLogger,
    private val codeGenerator: CodeGenerator,
) : SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val symbols = resolver
            .getSymbolsWithAnnotation("com.looker.LeetCodeQuestion")
            .filterIsInstance<KSFunctionDeclaration>()

        if (!symbols.iterator().hasNext()) return emptyList()

        val file = codeGenerator.createNewFile(
            dependencies = Dependencies(false, *resolver.getAllFiles().toList().toTypedArray()),
            packageName = "com.looker",
            fileName = "GeneratedSolutionTests"
        )
        file += "package com.looker\n"
        file += "\n"
        file += "import solutions.*\n"
        file += "import kotlin.test.assertEquals\n"
        file += "\n"

        symbols.forEach { it.accept(LeetCodeQuestionVisitor(file, logger), Unit) }

        file.close()
        return symbols.filterNot { it.validate() }.toList()
    }
}