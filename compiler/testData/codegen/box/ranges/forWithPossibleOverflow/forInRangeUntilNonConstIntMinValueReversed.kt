// WITH_STDLIB

import kotlin.test.assertEquals

const val M = Int.MIN_VALUE

fun nonConst(x: Int) = x

fun box(): String {
    val result = mutableListOf<Int>()
    for (i in (nonConst(M)..<M + 3).reversed()) {
        result += i
    }
    assertEquals(listOf(M + 2, M + 1, M), result)
    return "OK"
}
