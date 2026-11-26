// WITH_STDLIB

import kotlin.test.*

val log = StringBuilder()

fun logged(message: String, value: Int) =
    value.also { log.append(message) }

fun box(): String {
    assertFailsWith<IllegalArgumentException> {
        for (i in (logged("start;", 0) until 7).reversed() step -2) {
            fail("Unreachable: $i")
        }
    }

    assertEquals("start;", log.toString())

    return "OK"
}
