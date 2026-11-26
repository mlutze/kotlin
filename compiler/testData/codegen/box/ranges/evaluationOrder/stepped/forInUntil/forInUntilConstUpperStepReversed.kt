// WITH_STDLIB

import kotlin.test.*

val log = StringBuilder()

fun logged(message: String, value: Int) =
    value.also { log.append(message) }

fun box(): String {
    val result = mutableListOf<Int>()
    for (i in (logged("start;", 0) until 7 step logged("step;", 3)).reversed()) {
        result += i
    }

    assertEquals(listOf(6, 3, 0), result)
    assertEquals("start;step;", log.toString())

    return "OK"
}
