// WITH_STDLIB

import kotlin.test.*

val log = StringBuilder()

fun <T> logged(message: String, value: T): T =
    value.also { log.append(message) }

fun box(): String {
    for (i in logged("int;", 1) until Int.MIN_VALUE step 2) fail("Should be empty: $i")
    for (i in logged("long;", 1L) until Long.MIN_VALUE step 2L) fail("Should be empty: $i")
    for (i in logged("char;", 'a') until Char.MIN_VALUE step 2) fail("Should be empty: $i")
    for (i in logged("uint;", 1u) until UInt.MIN_VALUE step 2) fail("Should be empty: $i")
    for (i in logged("ulong;", 1uL) until ULong.MIN_VALUE step 2L) fail("Should be empty: $i")
    for (i in logged("ubyte;", 1u.toUByte()) until UByte.MIN_VALUE step 2) fail("Should be empty: $i")
    for (i in logged("ushort;", 1u.toUShort()) until UShort.MIN_VALUE step 2) fail("Should be empty: $i")

    assertEquals("int;long;char;uint;ulong;ubyte;ushort;", log.toString())

    return "OK"
}
