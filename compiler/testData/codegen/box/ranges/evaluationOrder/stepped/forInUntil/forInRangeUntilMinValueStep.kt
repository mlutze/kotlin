// WITH_STDLIB

import kotlin.test.*

val log = StringBuilder()

fun <T> logged(message: String, value: T): T =
    value.also { log.append(message) }

fun box(): String {
    for (i in logged("int;", 1)..<Int.MIN_VALUE step 2) fail("Should be empty: $i")
    for (i in logged("long;", 1L)..<Long.MIN_VALUE step 2L) fail("Should be empty: $i")
    for (i in logged("char;", 'a')..<Char.MIN_VALUE step 2) fail("Should be empty: $i")
    for (i in logged("uint;", 1u)..<UInt.MIN_VALUE step 2) fail("Should be empty: $i")
    for (i in logged("ulong;", 1uL)..<ULong.MIN_VALUE step 2L) fail("Should be empty: $i")

    assertEquals("int;long;char;uint;ulong;", log.toString())

    return "OK"
}
