// WITH_STDLIB

import kotlin.test.assertEquals

const val UINT_MIN = UInt.MIN_VALUE
const val ULONG_MIN = ULong.MIN_VALUE

fun nonConstUInt(x: UInt) = x
fun nonConstULong(x: ULong) = x

fun box(): String {
    val uints = mutableListOf<UInt>()
    for (i in (nonConstUInt(UINT_MIN) until 3u).reversed()) {
        uints += i
    }
    assertEquals(listOf(2u, 1u, 0u), uints)

    val ulongs = mutableListOf<ULong>()
    for (i in (nonConstULong(ULONG_MIN) until 3uL).reversed()) {
        ulongs += i
    }
    assertEquals(listOf(2uL, 1uL, 0uL), ulongs)

    return "OK"
}
