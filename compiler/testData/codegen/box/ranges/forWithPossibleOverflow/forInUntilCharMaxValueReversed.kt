// WITH_STDLIB

import kotlin.test.assertEquals

const val M = Char.MAX_VALUE

fun box(): String {
    val result = mutableListOf<Char>()
    for (i in ('\uFFFD' until M).reversed()) {
        result += i
    }
    assertEquals(listOf('\uFFFE', '\uFFFD'), result)
    return "OK"
}
