// WITH_STDLIB
import kotlin.test.*

const val UBYTE_FIVE: UByte = 5u
const val UBYTE_MAX: UByte = UByte.MAX_VALUE
const val USHORT_FIVE: UShort = 5u
const val USHORT_MAX: UShort = UShort.MAX_VALUE
const val UINT_MAX: UInt = UInt.MAX_VALUE
const val ULONG_MAX: ULong = ULong.MAX_VALUE
const val ULONG_SIGN_BIT: ULong = 0x8000_0000_0000_0000uL

fun box(): String {
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

    return "OK"
}
