// WITH_STDLIB

import kotlin.test.assertEquals

const val M = Long.MAX_VALUE

fun box(): String {
    val result = mutableListOf<Long>()
    for (i in ((M - 2L) until M).reversed()) {
        result += i
    }
    assertEquals(listOf(M - 1L, M - 2L), result)
    return "OK"
}
