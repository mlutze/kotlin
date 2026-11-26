// WITH_STDLIB

import kotlin.test.assertEquals

const val M = Int.MAX_VALUE

fun box(): String {
    val result = mutableListOf<Int>()
    for (i in ((M - 2) until M).reversed()) {
        result += i
    }
    assertEquals(listOf(M - 1, M - 2), result)
    return "OK"
}
