// IMPORTANT!
// Please, when your changes cause failures in bytecodeText tests for 'for' loops,
// examine the resulting bytecode shape carefully.
// Range and progression-based loops generated with Kotlin compiler should be
// as close as possible to Java counter loops ('for (int i = a; i < b; ++i) { ... }').
// Otherwise it may result in performance regression due to missing HotSpot optimizations.
// Run Kotlin compiler benchmarks (https://github.com/Kotlin/kotlin-benchmarks)
// with compiler built from your changes if you are not sure.

const val INT_C = 10
const val LONG_C = 10L
const val CHAR_C = '9'

fun fInt(a: Int): Int {
    var sum = 0
    for (i in (a until INT_C).reversed()) sum += i
    for (i in (a..<INT_C).reversed()) sum += i
    return sum
}

fun fLong(a: Long): Long {
    var sum = 0L
    for (i in (a until LONG_C).reversed()) sum += i
    for (i in (a..<LONG_C).reversed()) sum += i
    return sum
}

fun fChar(a: Char): Int {
    var sum = 0
    for (i in (a until CHAR_C).reversed()) sum += i.code
    for (i in (a..<CHAR_C).reversed()) sum += i.code
    return sum
}

// 0 iterator
// 0 until
// 0 rangeUntil
// 0 reversed
// 0 getStart
// 0 getEnd
// 0 getFirst
// 0 getLast
// 0 getStep

// 12 IF
// 28 ILOAD
// 12 ISTORE
// 6 IADD
// 0 ISUB
// 2 IINC
