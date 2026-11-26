// WITH_STDLIB

import kotlin.test.assertEquals

const val M = Char.MIN_VALUE

fun nonConst(x: Char) = x

fun box(): String {
    val result = mutableListOf<Char>()
    for (i in (nonConst(M) until '\u0003').reversed()) {
        result += i
    }
    assertEquals(listOf('\u0002', '\u0001', '\u0000'), result)
    return "OK"
}
