// WITH_STDLIB
import kotlin.test.*

const val BYTE_MIN: Byte = Byte.MIN_VALUE
const val SHORT_MIN: Short = Short.MIN_VALUE
const val INT_MIN: Int = Int.MIN_VALUE

fun box(): String {
    val ints = mutableListOf<Int>()
    for (i in (-130 until BYTE_MIN).reversed()) ints += i
    assertEquals(listOf(-129, -130), ints)

    ints.clear()
    for (i in (-130..<BYTE_MIN).reversed()) ints += i
    assertEquals(listOf(-129, -130), ints)

    ints.clear()
    for (i in (0 until BYTE_MIN).reversed()) ints += i
    assertTrue(ints.isEmpty())

    ints.clear()
    for (i in (-32770 until SHORT_MIN).reversed()) ints += i
    assertEquals(listOf(-32769, -32770), ints)

    ints.clear()
    for (i in (-32770..<SHORT_MIN).reversed()) ints += i
    assertEquals(listOf(-32769, -32770), ints)

    val longs = mutableListOf<Long>()
    val startL = INT_MIN.toLong() - 2L
    for (i in (startL until INT_MIN).reversed()) longs += i
    assertEquals(listOf(INT_MIN.toLong() - 1L, startL), longs)

    longs.clear()
    for (i in (startL..<INT_MIN).reversed()) longs += i
    assertEquals(listOf(INT_MIN.toLong() - 1L, startL), longs)

    return "OK"
}
