// WITH_STDLIB

import kotlin.test.*

val log = StringBuilder()

fun logged(message: String, value: Int) =
    value.also { log.append(message) }

fun box(): String {
    assertFailsWith<IllegalArgumentException> {
        for (i in logged("start;", 0) until 7 step logged("step;", 0)) {
            fail("Unreachable: $i")
        }
    }

    assertEquals("start;step;", log.toString())

    return "OK"
}
