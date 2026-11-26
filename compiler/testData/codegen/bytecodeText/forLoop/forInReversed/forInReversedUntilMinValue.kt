// WITH_STDLIB

// IMPORTANT!
// Please, when your changes cause failures in bytecodeText tests for 'for' loops,
// examine the resulting bytecode shape carefully.
// Range and progression-based loops generated with Kotlin compiler should be
// as close as possible to Java counter loops ('for (int i = a; i < b; ++i) { ... }').
// Otherwise it may result in performance regression due to missing HotSpot optimizations.
// Run Kotlin compiler benchmarks (https://github.com/Kotlin/kotlin-benchmarks)
// with compiler built from your changes if you are not sure.

// TODO Matt: explain why reversing `a until MIN_VALUE` / `a..<MIN_VALUE` must not decrement MIN_VALUE to MAX_VALUE and must fall back to `reversed()` (KT-42533)

fun fInt(a: Int): Int {
    var sum = 0
    for (i in (a until Int.MIN_VALUE).reversed()) sum += i
    for (i in (a..<Int.MIN_VALUE).reversed()) sum += i
    return sum
}

fun fLong(a: Long): Long {
    var sum = 0L
    for (i in (a until Long.MIN_VALUE).reversed()) sum += i
    for (i in (a..<Long.MIN_VALUE).reversed()) sum += i
    return sum
}

fun fChar(a: Char): Int {
    var sum = 0
    for (i in (a until Char.MIN_VALUE).reversed()) sum += i.code
    for (i in (a..<Char.MIN_VALUE).reversed()) sum += i.code
    return sum
}

fun fUInt(a: UInt): UInt {
    var sum = 0u
    for (i in (a until UInt.MIN_VALUE).reversed()) sum += i
    for (i in (a..<UInt.MIN_VALUE).reversed()) sum += i
    return sum
}

fun fULong(a: ULong): ULong {
    var sum = 0uL
    for (i in (a until ULong.MIN_VALUE).reversed()) sum += i
    for (i in (a..<ULong.MIN_VALUE).reversed()) sum += i
    return sum
}

// 0 iterator
// 10 reversed
// 10 getFirst
// 10 getLast
// 10 getStep
