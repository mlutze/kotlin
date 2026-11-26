// WITH_STDLIB
import kotlin.test.*

fun box(): String {
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

    return "OK"
}
