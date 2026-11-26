// WITH_STDLIB
import kotlin.test.*

fun box(): String {
    val ints = mutableListOf<Int>()
    for (i in (1..<5).reversed().reversed()) ints += i
    assertEquals(listOf(1, 2, 3, 4), ints)

    return "OK"
}
