// IMPORTANT!
// Please, when your changes cause failures in bytecodeText tests for 'for' loops,
// examine the resulting bytecode shape carefully.
// Range and progression-based loops generated with Kotlin compiler should be
// as close as possible to Java counter loops ('for (int i = a; i < b; ++i) { ... }').
// Otherwise it may result in performance regression due to missing HotSpot optimizations.
// Run Kotlin compiler benchmarks (https://github.com/Kotlin/kotlin-benchmarks)
// with compiler built from your changes if you are not sure.

fun box(): String {
    var sum = 0
    for (i in (1..<5).reversed()) {
        sum = sum * 10 + i
    }

    var sumL = 0L
    for (i in (1L..<5L).reversed()) {
        sumL = sumL * 10 + i
    }

    var sumC = 0
    for (i in ('1'..<'5').reversed()) {
        sumC = sumC * 10 + i.code - '0'.code
    }

    return "OK"
}

// 0 iterator
// 0 getStart
// 0 getEnd

// 0 reversed
// 0 getFirst
// 0 getLast
// 0 getStep

// 9 ILOAD
// 9 ISTORE
// 3 IADD
// 1 ISUB
// 1 IINC
