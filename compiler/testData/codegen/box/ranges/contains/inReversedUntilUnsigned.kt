// WITH_STDLIB
import kotlin.test.*

const val UBYTE_FIVE: UByte = 5u
const val USHORT_FIVE: UShort = 5u
const val UINT_MAX: UInt = UInt.MAX_VALUE
const val ULONG_MAX: ULong = ULong.MAX_VALUE
const val ULONG_SIGN_BIT: ULong = 0x8000_0000_0000_0000uL

fun box(): String {
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

    return "OK"
}
