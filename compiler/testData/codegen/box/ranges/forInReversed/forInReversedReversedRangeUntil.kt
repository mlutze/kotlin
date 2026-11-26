// WITH_STDLIB
import kotlin.test.*

fun box(): String {
    val ints = mutableListOf<Int>()
    for (i in (1..<5).reversed().reversed()) ints += i
    assertEquals(listOf(1, 2, 3, 4), ints)

    val longs = mutableListOf<Long>()
    for (i in (1L..<5L).reversed().reversed()) longs += i
    assertEquals(listOf(1L, 2L, 3L, 4L), longs)

    val chars = mutableListOf<Char>()
    for (i in ('a'..<'e').reversed().reversed()) chars += i
    assertEquals(listOf('a', 'b', 'c', 'd'), chars)

    return "OK"
}
