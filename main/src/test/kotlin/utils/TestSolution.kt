package utils

import org.junit.jupiter.api.Test
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Test
annotation class TestSolution(val solution: KClass<*>)