// WITH_STDLIB

import kotlin.test.assertEquals

const val M = Long.MIN_VALUE

fun nonConst(x: Long) = x

fun box(): String {
    val result = mutableListOf<Long>()
    for (i in (nonConst(M) until M + 3L).reversed()) {
        result += i
    }
    assertEquals(listOf(M + 2L, M + 1L, M), result)
    return "OK"
}
