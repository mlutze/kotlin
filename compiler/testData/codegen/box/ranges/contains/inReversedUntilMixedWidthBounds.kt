// WITH_STDLIB
import kotlin.test.*

const val BYTE_MIN: Byte = Byte.MIN_VALUE
const val SHORT_MIN: Short = Short.MIN_VALUE
const val INT_MIN: Int = Int.MIN_VALUE

fun box(): String {
    val startL = INT_MIN.toLong() - 2L

    assertTrue(-129 in (-130 until BYTE_MIN).reversed())
    assertFalse(-128 in (-130 until BYTE_MIN).reversed())
    assertFalse(0 in (0 until BYTE_MIN).reversed())
    assertTrue(-32769 in (-32770 until SHORT_MIN).reversed())
    assertFalse(-32768 in (-32770 until SHORT_MIN).reversed())
    assertTrue((INT_MIN.toLong() - 1L) in (startL until INT_MIN).reversed())
    assertFalse(INT_MIN.toLong() in (startL until INT_MIN).reversed())

    return "OK"
}
