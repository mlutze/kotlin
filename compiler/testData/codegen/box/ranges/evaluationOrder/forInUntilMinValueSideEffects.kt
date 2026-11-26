// WITH_STDLIB
import kotlin.test.*

const val INT_MIN: Int = Int.MIN_VALUE
const val LONG_MIN: Long = Long.MIN_VALUE
const val CHAR_MIN: Char = Char.MIN_VALUE
const val UBYTE_MIN: UByte = UByte.MIN_VALUE
const val USHORT_MIN: UShort = UShort.MIN_VALUE
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
    fun sideUByte(x: UByte): UByte {
        calls++
        return x
    }
    fun sideUShort(x: UShort): UShort {
        calls++
        return x
    }

    for (i in (sideInt(1) until INT_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(1, calls)
    for (i in (sideInt(1)..<INT_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(2, calls)
    for (i in sideInt(1) until INT_MIN step 2) fail("Should be empty: $i")
    assertEquals(3, calls)
    for (i in sideInt(1)..<INT_MIN step 2) fail("Should be empty: $i")
    assertEquals(4, calls)

    for (i in (sideLong(1L) until LONG_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(5, calls)
    for (i in (sideLong(1L)..<LONG_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(6, calls)
    for (i in sideLong(1L) until LONG_MIN step 2L) fail("Should be empty: $i")
    assertEquals(7, calls)
    for (i in sideLong(1L)..<LONG_MIN step 2L) fail("Should be empty: $i")
    assertEquals(8, calls)

    for (i in (sideChar('a') until CHAR_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(9, calls)
    for (i in (sideChar('a')..<CHAR_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(10, calls)
    for (i in sideChar('a') until CHAR_MIN step 2) fail("Should be empty: $i")
    assertEquals(11, calls)
    for (i in sideChar('a')..<CHAR_MIN step 2) fail("Should be empty: $i")
    assertEquals(12, calls)

    for (i in (sideUInt(1u) until UINT_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(13, calls)
    for (i in (sideUInt(1u)..<UINT_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(14, calls)
    for (i in sideUInt(1u) until UINT_MIN step 2) fail("Should be empty: $i")
    assertEquals(15, calls)
    for (i in sideUInt(1u)..<UINT_MIN step 2) fail("Should be empty: $i")
    assertEquals(16, calls)

    for (i in (sideULong(1uL) until ULONG_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(17, calls)
    for (i in (sideULong(1uL)..<ULONG_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(18, calls)
    for (i in sideULong(1uL) until ULONG_MIN step 2L) fail("Should be empty: $i")
    assertEquals(19, calls)
    for (i in sideULong(1uL)..<ULONG_MIN step 2L) fail("Should be empty: $i")
    assertEquals(20, calls)

    for (i in (sideUByte(1u) until UBYTE_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(21, calls)
    for (i in sideUByte(1u) until UBYTE_MIN step 2) fail("Should be empty: $i")
    assertEquals(22, calls)
    for (i in (sideUShort(1u) until USHORT_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(23, calls)
    for (i in sideUShort(1u) until USHORT_MIN step 2) fail("Should be empty: $i")
    assertEquals(24, calls)

    return "OK"
}
