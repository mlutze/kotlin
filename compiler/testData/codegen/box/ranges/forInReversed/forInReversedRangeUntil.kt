// WITH_STDLIB
import kotlin.test.*

fun box(): String {
    val ints = mutableListOf<Int>()
    for (i in (1..<5).reversed()) ints += i
    assertEquals(listOf(4, 3, 2, 1), ints)

    val longs = mutableListOf<Long>()
    for (i in (1L..<5L).reversed()) longs += i
    assertEquals(listOf(4L, 3L, 2L, 1L), longs)

    val chars = mutableListOf<Char>()
    for (i in ('a'..<'e').reversed()) chars += i
    assertEquals(listOf('d', 'c', 'b', 'a'), chars)

    return "OK"
}
