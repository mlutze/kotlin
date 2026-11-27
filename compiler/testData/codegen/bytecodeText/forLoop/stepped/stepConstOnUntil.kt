// IMPORTANT!
// Please, when your changes cause failures in bytecodeText tests for 'for' loops,
// examine the resulting bytecode shape carefully.
// Range and progression-based loops generated with Kotlin compiler should be
// as close as possible to Java counter loops ('for (int i = a; i < b; ++i) { ... }').
// Otherwise it may result in performance regression due to missing HotSpot optimizations.
// Run Kotlin compiler benchmarks (https://github.com/Kotlin/kotlin-benchmarks)
// with compiler built from your changes if you are not sure.

fun box(): String {
    for (i in 1 until 8 step 2) {
    }
    for (i in 1..<8 step 2) {
    }
    for (i in 1 until 8 step 1) {
    }
    for (i in 1..<8 step 1) {
    }

    return "OK"
}

fun withNonConstFirst(a: Int, aL: Long, aC: Char): Long {
    var sum = 0L
    for (i in a until 10 step 3) sum += i
    for (i in a..<10 step 3) sum += i
    for (i in (a until 10).reversed() step 3) sum += i
    for (i in (a until 10 step 3).reversed()) sum += i
    for (i in aL until 10L step 3L) sum += i
    for (i in aL..<10L step 3L) sum += i
    for (i in aC until 'z' step 3) sum += i.code
    for (i in aC..<'z' step 3) sum += i.code
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
// 10 INVOKESTATIC kotlin/internal/ProgressionUtilKt.getProgressionLastElement
// 0 NEW java/lang/IllegalArgumentException
// 0 ATHROW

// 22 IF
// 54 ILOAD
// 21 ISTORE
// 2 IADD
// 0 ISUB
// 8 IINC
