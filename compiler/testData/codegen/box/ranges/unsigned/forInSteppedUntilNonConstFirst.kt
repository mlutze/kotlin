// WITH_STDLIB
import kotlin.test.*

const val UBYTE_FIVE: UByte = 5u
const val USHORT_FIVE: UShort = 5u
const val UINT_MAX: UInt = UInt.MAX_VALUE
const val ULONG_SIGN_BIT: ULong = 0x8000_0000_0000_0000uL

fun nonConstInt(x: Int) = x
fun nonConstLong(x: Long) = x
fun nonConstUInt(x: UInt) = x
fun nonConstULong(x: ULong) = x

fun box(): String {
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

    return "OK"
}
