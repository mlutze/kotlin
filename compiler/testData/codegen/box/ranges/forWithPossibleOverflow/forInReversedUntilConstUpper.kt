// WITH_STDLIB
import kotlin.test.*

const val INT_MIN: Int = Int.MIN_VALUE
const val INT_MIN_PLUS_3: Int = Int.MIN_VALUE + 3
const val INT_MAX: Int = Int.MAX_VALUE
const val LONG_MIN: Long = Long.MIN_VALUE
const val LONG_MIN_PLUS_3: Long = Long.MIN_VALUE + 3L
const val LONG_MAX: Long = Long.MAX_VALUE
const val CHAR_MIN: Char = Char.MIN_VALUE
const val CHAR_MAX: Char = Char.MAX_VALUE
const val UINT_MIN: UInt = UInt.MIN_VALUE
const val ULONG_MIN: ULong = ULong.MIN_VALUE

fun nonConstInt(x: Int) = x
fun nonConstLong(x: Long) = x
fun nonConstChar(x: Char) = x
fun nonConstUInt(x: UInt) = x
fun nonConstULong(x: ULong) = x

fun box(): String {
    val ints = mutableListOf<Int>()
    for (i in ((INT_MAX - 2) until INT_MAX).reversed()) ints += i
    assertEquals(listOf(INT_MAX - 1, INT_MAX - 2), ints)

    // TODO Matt: explain why non-const first == MIN_VALUE reversed countdown must not underflow/wrap
    ints.clear()
    for (i in (nonConstInt(INT_MIN) until INT_MIN_PLUS_3).reversed()) ints += i
    assertEquals(listOf(INT_MIN + 2, INT_MIN + 1, INT_MIN), ints)

    ints.clear()
    for (i in (nonConstInt(INT_MIN)..<INT_MIN_PLUS_3).reversed()) ints += i
    assertEquals(listOf(INT_MIN + 2, INT_MIN + 1, INT_MIN), ints)

    val longs = mutableListOf<Long>()
    for (i in ((LONG_MAX - 2L) until LONG_MAX).reversed()) longs += i
    assertEquals(listOf(LONG_MAX - 1L, LONG_MAX - 2L), longs)

    longs.clear()
    for (i in (nonConstLong(LONG_MIN) until LONG_MIN_PLUS_3).reversed()) longs += i
    assertEquals(listOf(LONG_MIN + 2L, LONG_MIN + 1L, LONG_MIN), longs)

    val chars = mutableListOf<Char>()
    for (i in ('\uFFFD' until CHAR_MAX).reversed()) chars += i
    assertEquals(listOf('\uFFFE', '\uFFFD'), chars)

    chars.clear()
    for (i in (nonConstChar(CHAR_MIN) until '\u0003').reversed()) chars += i
    assertEquals(listOf('\u0002', '\u0001', '\u0000'), chars)

    val uints = mutableListOf<UInt>()
    for (i in (nonConstUInt(UINT_MIN) until 3u).reversed()) uints += i
    assertEquals(listOf(2u, 1u, 0u), uints)

    val ulongs = mutableListOf<ULong>()
    for (i in (nonConstULong(ULONG_MIN) until 3uL).reversed()) ulongs += i
    assertEquals(listOf(2uL, 1uL, 0uL), ulongs)

    return "OK"
}
