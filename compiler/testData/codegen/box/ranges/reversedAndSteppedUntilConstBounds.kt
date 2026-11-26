// WITH_STDLIB
import kotlin.test.*

const val BYTE_MIN: Byte = Byte.MIN_VALUE
const val SHORT_MIN: Short = Short.MIN_VALUE
const val INT_MIN: Int = Int.MIN_VALUE
const val INT_MIN_PLUS_3: Int = Int.MIN_VALUE + 3
const val INT_MAX: Int = Int.MAX_VALUE
const val LONG_MIN: Long = Long.MIN_VALUE
const val LONG_MIN_PLUS_3: Long = Long.MIN_VALUE + 3L
const val LONG_MAX: Long = Long.MAX_VALUE
const val CHAR_MIN: Char = Char.MIN_VALUE
const val CHAR_MAX: Char = Char.MAX_VALUE
const val UBYTE_MIN: UByte = UByte.MIN_VALUE
const val UBYTE_FIVE: UByte = 5u
const val UBYTE_MAX: UByte = UByte.MAX_VALUE
const val USHORT_MIN: UShort = UShort.MIN_VALUE
const val USHORT_FIVE: UShort = 5u
const val USHORT_MAX: UShort = UShort.MAX_VALUE
const val UINT_MIN: UInt = UInt.MIN_VALUE
const val UINT_MAX: UInt = UInt.MAX_VALUE
const val ULONG_MIN: ULong = ULong.MIN_VALUE
const val ULONG_MAX: ULong = ULong.MAX_VALUE
const val ULONG_SIGN_BIT: ULong = 0x8000_0000_0000_0000uL

fun nonConstInt(x: Int) = x
fun nonConstLong(x: Long) = x
fun nonConstChar(x: Char) = x
fun nonConstUInt(x: UInt) = x
fun nonConstULong(x: ULong) = x

fun testBasicReversedAndStepped() {
    val ints = mutableListOf<Int>()
    for (i in (1 until 5).reversed()) ints += i
    assertEquals(listOf(4, 3, 2, 1), ints)

    ints.clear()
    for (i in (1..<5).reversed()) ints += i
    assertEquals(listOf(4, 3, 2, 1), ints)

    ints.clear()
    for (i in (1 until 5).reversed().reversed()) ints += i
    assertEquals(listOf(1, 2, 3, 4), ints)

    ints.clear()
    for (i in (1..<5).reversed().reversed()) ints += i
    assertEquals(listOf(1, 2, 3, 4), ints)

    ints.clear()
    for (i in 0 until 9 step 2) ints += i
    assertEquals(listOf(0, 2, 4, 6, 8), ints)

    ints.clear()
    for (i in 0..<9 step 2) ints += i
    assertEquals(listOf(0, 2, 4, 6, 8), ints)

    ints.clear()
    for (i in (0 until 9 step 2).reversed()) ints += i
    assertEquals(listOf(8, 6, 4, 2, 0), ints)

    ints.clear()
    for (i in (0 until 9).reversed() step 2) ints += i
    assertEquals(listOf(8, 6, 4, 2, 0), ints)

    ints.clear()
    for (i in (0..<9 step 3).reversed()) ints += i
    assertEquals(listOf(6, 3, 0), ints)

    val longs = mutableListOf<Long>()
    for (i in (1L until 5L).reversed()) longs += i
    assertEquals(listOf(4L, 3L, 2L, 1L), longs)

    longs.clear()
    for (i in (1L..<5L).reversed()) longs += i
    assertEquals(listOf(4L, 3L, 2L, 1L), longs)

    val chars = mutableListOf<Char>()
    for (i in ('a' until 'e').reversed()) chars += i
    assertEquals(listOf('d', 'c', 'b', 'a'), chars)

    chars.clear()
    for (i in ('a'..<'e').reversed()) chars += i
    assertEquals(listOf('d', 'c', 'b', 'a'), chars)
}

fun testEmptyAndSideEffectsOnMinValue() {
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
    assertFalse(2 in (sideInt(1) until INT_MIN).reversed())
    assertEquals(5, calls)
    assertFalse(2 in (sideInt(1)..<INT_MIN).reversed())
    assertEquals(6, calls)

    for (i in (sideLong(1L) until LONG_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(7, calls)
    for (i in (sideLong(1L)..<LONG_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(8, calls)
    for (i in sideLong(1L) until LONG_MIN step 2L) fail("Should be empty: $i")
    assertEquals(9, calls)
    for (i in sideLong(1L)..<LONG_MIN step 2L) fail("Should be empty: $i")
    assertEquals(10, calls)
    assertFalse(2L in (sideLong(1L) until LONG_MIN).reversed())
    assertEquals(11, calls)

    for (i in (sideChar('a') until CHAR_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(12, calls)
    for (i in (sideChar('a')..<CHAR_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(13, calls)
    for (i in sideChar('a') until CHAR_MIN step 2) fail("Should be empty: $i")
    assertEquals(14, calls)
    for (i in sideChar('a')..<CHAR_MIN step 2) fail("Should be empty: $i")
    assertEquals(15, calls)
    assertFalse('b' in (sideChar('a') until CHAR_MIN).reversed())
    assertEquals(16, calls)

    for (i in (sideUInt(1u) until UINT_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(17, calls)
    for (i in (sideUInt(1u)..<UINT_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(18, calls)
    for (i in sideUInt(1u) until UINT_MIN step 2) fail("Should be empty: $i")
    assertEquals(19, calls)
    for (i in sideUInt(1u)..<UINT_MIN step 2) fail("Should be empty: $i")
    assertEquals(20, calls)
    assertFalse(2u in (sideUInt(1u) until UINT_MIN).reversed())
    assertEquals(21, calls)

    for (i in (sideULong(1uL) until ULONG_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(22, calls)
    for (i in (sideULong(1uL)..<ULONG_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(23, calls)
    for (i in sideULong(1uL) until ULONG_MIN step 2L) fail("Should be empty: $i")
    assertEquals(24, calls)
    for (i in sideULong(1uL)..<ULONG_MIN step 2L) fail("Should be empty: $i")
    assertEquals(25, calls)
    assertFalse(2uL in (sideULong(1uL) until ULONG_MIN).reversed())
    assertEquals(26, calls)

    for (i in (sideUByte(1u) until UBYTE_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(27, calls)
    for (i in sideUByte(1u) until UBYTE_MIN step 2) fail("Should be empty: $i")
    assertEquals(28, calls)
    for (i in (sideUShort(1u) until USHORT_MIN).reversed()) fail("Should be empty: $i")
    assertEquals(29, calls)
    for (i in sideUShort(1u) until USHORT_MIN step 2) fail("Should be empty: $i")
    assertEquals(30, calls)
}

fun testMixedWidthBoundsDoNotUnderflow() {
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

    assertTrue(-129 in (-130 until BYTE_MIN).reversed())
    assertFalse(-128 in (-130 until BYTE_MIN).reversed())
    assertFalse(0 in (0 until BYTE_MIN).reversed())
    assertTrue(-32769 in (-32770 until SHORT_MIN).reversed())
    assertFalse(-32768 in (-32770 until SHORT_MIN).reversed())
    assertTrue((INT_MIN.toLong() - 1L) in (startL until INT_MIN).reversed())
    assertFalse(INT_MIN.toLong() in (startL until INT_MIN).reversed())
}

fun testUnsignedAndHighBitBoundaries() {
    val uints = mutableListOf<UInt>()
    for (i in ((UINT_MAX - 2u) until UINT_MAX).reversed()) uints += i
    assertEquals(listOf(UINT_MAX - 1u, UINT_MAX - 2u), uints)

    uints.clear()
    for (i in ((UINT_MAX - 2u)..<UINT_MAX).reversed()) uints += i
    assertEquals(listOf(UINT_MAX - 1u, UINT_MAX - 2u), uints)

    uints.clear()
    for (i in (1u.toUByte() until UBYTE_FIVE).reversed()) uints += i
    assertEquals(listOf(4u, 3u, 2u, 1u), uints)

    uints.clear()
    for (i in (253u.toUByte() until UBYTE_MAX).reversed()) uints += i
    assertEquals(listOf(254u, 253u), uints)

    uints.clear()
    for (i in (1u.toUShort() until USHORT_FIVE).reversed()) uints += i
    assertEquals(listOf(4u, 3u, 2u, 1u), uints)

    uints.clear()
    for (i in (65533u.toUShort() until USHORT_MAX).reversed()) uints += i
    assertEquals(listOf(65534u, 65533u), uints)

    val ulongs = mutableListOf<ULong>()
    for (i in ((ULONG_MAX - 2uL) until ULONG_MAX).reversed()) ulongs += i
    assertEquals(listOf(ULONG_MAX - 1uL, ULONG_MAX - 2uL), ulongs)

    ulongs.clear()
    for (i in ((ULONG_MAX - 2uL)..<ULONG_MAX).reversed()) ulongs += i
    assertEquals(listOf(ULONG_MAX - 1uL, ULONG_MAX - 2uL), ulongs)

    // TODO Matt: explain crossing the signed Long.MIN_VALUE / Long.MAX_VALUE boundary (0x8000_0000_0000_0000uL - 1uL == 0x7FFF_FFFF_FFFF_FFFFuL)
    ulongs.clear()
    for (i in ((ULONG_SIGN_BIT - 2uL) until ULONG_SIGN_BIT).reversed()) ulongs += i
    assertEquals(listOf(ULONG_SIGN_BIT - 1uL, ULONG_SIGN_BIT - 2uL), ulongs)

    ulongs.clear()
    for (i in ((ULONG_SIGN_BIT - 2uL)..<ULONG_SIGN_BIT).reversed()) ulongs += i
    assertEquals(listOf(ULONG_SIGN_BIT - 1uL, ULONG_SIGN_BIT - 2uL), ulongs)

    // TODO Matt: explain unsigned contains checks (RangeContainsLowering with allowUnsignedBounds = true)
    assertTrue(3u in (1u.toUByte() until UBYTE_FIVE).reversed())
    assertFalse(5u in (1u.toUByte() until UBYTE_FIVE).reversed())
    assertFalse(0u in (1u.toUByte() until UBYTE_FIVE).reversed())
    assertTrue(3u in (1u.toUShort() until USHORT_FIVE).reversed())
    assertFalse(5u in (1u.toUShort() until USHORT_FIVE).reversed())
    assertTrue((UINT_MAX - 1u) in ((UINT_MAX - 2u) until UINT_MAX).reversed())
    assertFalse(UINT_MAX in ((UINT_MAX - 2u) until UINT_MAX).reversed())
    assertTrue((ULONG_MAX - 1uL) in ((ULONG_MAX - 2uL) until ULONG_MAX).reversed())
    assertFalse(ULONG_MAX in ((ULONG_MAX - 2uL) until ULONG_MAX).reversed())
    assertTrue((ULONG_SIGN_BIT - 1uL) in ((ULONG_SIGN_BIT - 2uL) until ULONG_SIGN_BIT).reversed())
    assertFalse(ULONG_SIGN_BIT in ((ULONG_SIGN_BIT - 2uL) until ULONG_SIGN_BIT).reversed())
}

fun testMaxAndNonConstMinFirstNoOverflow() {
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
}

fun testNonConstFirstAndStepAllTypes() {
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

    ints.clear()
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

    val uints = mutableListOf<UInt>()
    for (i in nonConstUInt(0u) until 10u step nonConstInt(3)) uints += i
    assertEquals(listOf(0u, 3u, 6u, 9u), uints)

    uints.clear()
    for (i in nonConstUInt(0u)..<10u step 3) uints += i
    assertEquals(listOf(0u, 3u, 6u, 9u), uints)

    uints.clear()
    for (i in nonConstUInt(UINT_MAX - 3u) until UINT_MAX step 2) uints += i
    assertEquals(listOf(UINT_MAX - 3u, UINT_MAX - 1u), uints)

    uints.clear()
    for (i in 1u.toUByte() until UBYTE_FIVE step 2) uints += i
    assertEquals(listOf(1u, 3u), uints)

    uints.clear()
    for (i in 1u.toUShort() until USHORT_FIVE step 2) uints += i
    assertEquals(listOf(1u, 3u), uints)

    val ulongs = mutableListOf<ULong>()
    for (i in nonConstULong(0uL) until 10uL step nonConstLong(3L)) ulongs += i
    assertEquals(listOf(0uL, 3uL, 6uL, 9uL), ulongs)

    ulongs.clear()
    for (i in nonConstULong(0uL)..<10uL step 3L) ulongs += i
    assertEquals(listOf(0uL, 3uL, 6uL, 9uL), ulongs)

    ulongs.clear()
    for (i in nonConstULong(ULONG_SIGN_BIT - 3uL) until ULONG_SIGN_BIT step 2L) ulongs += i
    assertEquals(listOf(ULONG_SIGN_BIT - 3uL, ULONG_SIGN_BIT - 1uL), ulongs)

    val indexed = mutableListOf<Pair<Int, Int>>()
    for ((idx, v) in (1 until 5).reversed().withIndex()) indexed += idx to v
    assertEquals(listOf(0 to 4, 1 to 3, 2 to 2, 3 to 1), indexed)

    indexed.clear()
    for ((idx, v) in (0 until 10 step 3).withIndex()) indexed += idx to v
    assertEquals(listOf(0 to 0, 1 to 3, 2 to 6, 3 to 9), indexed)
}

fun testSideEffectsAndIllegalSteps() {
    val log = StringBuilder()
    fun sideA(x: Int): Int {
        log.append("A")
        return x
    }
    fun sideK(k: Int): Int {
        log.append("K")
        return k
    }

    val ints = mutableListOf<Int>()
    for (i in (sideA(1) until 4).reversed()) ints += i
    assertEquals("A", log.toString())
    assertEquals(listOf(3, 2, 1), ints)

    log.clear()
    ints.clear()
    for (i in sideA(0) until 7 step sideK(3)) ints += i
    assertEquals("AK", log.toString())
    assertEquals(listOf(0, 3, 6), ints)

    log.clear()
    ints.clear()
    for (i in (sideA(0) until 7).reversed() step sideK(3)) ints += i
    assertEquals("AK", log.toString())
    assertEquals(listOf(6, 3, 0), ints)

    log.clear()
    ints.clear()
    for (i in (sideA(0) until 7 step sideK(3)).reversed()) ints += i
    assertEquals("AK", log.toString())
    assertEquals(listOf(6, 3, 0), ints)

    log.clear()
    assertFailsWith<IllegalArgumentException> {
        for (i in sideA(0) until 7 step 0) fail("Unreachable: $i")
    }
    assertEquals("A", log.toString())

    log.clear()
    assertFailsWith<IllegalArgumentException> {
        for (i in (sideA(0) until 7).reversed() step -2) fail("Unreachable: $i")
    }
    assertEquals("A", log.toString())

    log.clear()
    assertFailsWith<IllegalArgumentException> {
        for (i in sideA(0) until 7 step sideK(0)) fail("Unreachable: $i")
    }
    assertEquals("AK", log.toString())
}

fun box(): String {
    testBasicReversedAndStepped()
    testEmptyAndSideEffectsOnMinValue()
    testMixedWidthBoundsDoNotUnderflow()
    testUnsignedAndHighBitBoundaries()
    testMaxAndNonConstMinFirstNoOverflow()
    testNonConstFirstAndStepAllTypes()
    testSideEffectsAndIllegalSteps()
    return "OK"
}
