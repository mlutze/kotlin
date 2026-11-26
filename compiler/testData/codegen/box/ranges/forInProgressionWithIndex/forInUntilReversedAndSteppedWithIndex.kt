// LANGUAGE: +NameBasedDestructuring +DeprecateNameMismatchInShortDestructuringWithParentheses +EnableNameBasedDestructuringShortForm
// WITH_STDLIB

import kotlin.test.assertEquals

fun box(): String {
    val indexList = mutableListOf<Int>()
    val valueList = mutableListOf<Int>()
    for ([i, v] in (1 until 5).reversed().withIndex()) {
        indexList += i
        valueList += v
    }
    assertEquals(listOf(0, 1, 2, 3), indexList)
    assertEquals(listOf(4, 3, 2, 1), valueList)

    indexList.clear()
    valueList.clear()
    for ([i, v] in (0 until 10 step 3).withIndex()) {
        indexList += i
        valueList += v
    }
    assertEquals(listOf(0, 1, 2, 3), indexList)
    assertEquals(listOf(0, 3, 6, 9), valueList)

    return "OK"
}
