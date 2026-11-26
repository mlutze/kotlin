// WITH_STDLIB
import kotlin.test.*

fun box(): String {
    val indexed = mutableListOf<Pair<Int, Int>>()
    for ((idx, v) in (1 until 5).reversed().withIndex()) indexed += idx to v
    assertEquals(listOf(0 to 4, 1 to 3, 2 to 2, 3 to 1), indexed)

    indexed.clear()
    for ((idx, v) in (0 until 10 step 3).withIndex()) indexed += idx to v
    assertEquals(listOf(0 to 0, 1 to 3, 2 to 6, 3 to 9), indexed)

    return "OK"
}
