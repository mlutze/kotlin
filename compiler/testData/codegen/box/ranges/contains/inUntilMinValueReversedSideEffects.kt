// WITH_STDLIB
import kotlin.test.*

const val INT_MIN: Int = Int.MIN_VALUE
const val LONG_MIN: Long = Long.MIN_VALUE
const val CHAR_MIN: Char = Char.MIN_VALUE
const val UINT_MIN: UInt = UInt.MIN_VALUE
const val ULONG_MIN: ULong = ULong.MIN_VALUE

fun box(): String {
    var calls = 0
    fun sideInt(x: Int): Int {
        calls++
        return x
    }
    fun sideLong(x: Long): Long {
        calls++
        return x
    }
    fun sideChar(x: Char): Char {
        calls++
        return x
    }
    fun sideUInt(x: UInt): UInt {
        calls++
        return x
    }
    fun sideULong(x: ULong): ULong {
        calls++
        return x
    }

    assertFalse(2 in (sideInt(1)..<INT_MIN).reversed())
    assertEquals(1, calls)
    assertFalse(2L in (sideLong(1L) until LONG_MIN).reversed())
    assertEquals(2, calls)
    assertFalse('b' in (sideChar('a') until CHAR_MIN).reversed())
    assertEquals(3, calls)
    assertFalse(2u in (sideUInt(1u) until UINT_MIN).reversed())
    assertEquals(4, calls)
    assertFalse(2uL in (sideULong(1uL) until ULONG_MIN).reversed())
    assertEquals(5, calls)

    return "OK"
}
