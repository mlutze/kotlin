// WITH_STDLIB
import kotlin.test.*

fun nonConstInt(x: Int) = x

fun box(): String {
    val ints = mutableListOf<Int>()
    for (i in (nonConstInt(1) until 5).reversed()) ints += i
    assertEquals(listOf(4, 3, 2, 1), ints)

    ints.clear()
    for (i in (nonConstInt(5) until 5).reversed()) ints += i
    assertTrue(ints.isEmpty())

    ints.clear()
    for (i in (nonConstInt(4) until 5).reversed()) ints += i
    assertEquals(listOf(4), ints)

    ints.clear()
    for (i in (nonConstInt(-10) until -5).reversed()) ints += i
    assertEquals(listOf(-6, -7, -8, -9, -10), ints)

    return "OK"
}
