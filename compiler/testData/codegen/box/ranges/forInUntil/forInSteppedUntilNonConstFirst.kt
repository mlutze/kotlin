// WITH_STDLIB
import kotlin.test.*

const val INT_MIN: Int = Int.MIN_VALUE
const val INT_MAX: Int = Int.MAX_VALUE
const val LONG_MAX: Long = Long.MAX_VALUE

fun nonConstInt(x: Int) = x
fun nonConstLong(x: Long) = x
fun nonConstChar(x: Char) = x

fun box(): String {
    val ints = mutableListOf<Int>()
    for (i in nonConstInt(0) until 10 step nonConstInt(3)) ints += i
    assertEquals(listOf(0, 3, 6, 9), ints)

    ints.clear()
    for (i in nonConstInt(0)..<10 step nonConstInt(3)) ints += i
    assertEquals(listOf(0, 3, 6, 9), ints)

    ints.clear()
    for (i in nonConstInt(1) until 5 step 1) ints += i
    assertEquals(listOf(1, 2, 3, 4), ints)

    ints.clear()
    for (i in (nonConstInt(0) until 10).reversed() step nonConstInt(3)) ints += i
    assertEquals(listOf(9, 6, 3, 0), ints)

    ints.clear()
    for (i in (nonConstInt(0) until 10 step nonConstInt(3)).reversed()) ints += i
    assertEquals(listOf(9, 6, 3, 0), ints)

    ints.clear()
    for (i in nonConstInt(0) until 10 step 2 step 3) ints += i
    assertEquals(listOf(0, 3, 6), ints)

    ints.clear()
    for (i in (nonConstInt(0) until 10 step 2).reversed() step 3) ints += i
    assertEquals(listOf(8, 5, 2), ints)

    ints.clear()
    for (i in nonConstInt(INT_MAX - 3) until INT_MAX step 2) ints += i
    assertEquals(listOf(INT_MAX - 3, INT_MAX - 1), ints)

    ints.clear()
    for (i in nonConstInt(INT_MIN) until (INT_MIN + 1) step 2) ints += i
    assertEquals(listOf(INT_MIN), ints)

    val longs = mutableListOf<Long>()
    for (i in nonConstLong(0L) until 10L step nonConstLong(3L)) longs += i
    assertEquals(listOf(0L, 3L, 6L, 9L), longs)

    longs.clear()
    for (i in nonConstLong(0L)..<10L step 3L) longs += i
    assertEquals(listOf(0L, 3L, 6L, 9L), longs)

    longs.clear()
    for (i in nonConstLong(LONG_MAX - 3L) until LONG_MAX step 2L) longs += i
    assertEquals(listOf(LONG_MAX - 3L, LONG_MAX - 1L), longs)

    val chars = mutableListOf<Char>()
    for (i in nonConstChar('a') until 'g' step nonConstInt(2)) chars += i
    assertEquals(listOf('a', 'c', 'e'), chars)

    chars.clear()
    for (i in nonConstChar('a')..<'g' step 2) chars += i
    assertEquals(listOf('a', 'c', 'e'), chars)

    return "OK"
}
