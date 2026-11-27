// IMPORTANT!
// Please, when your changes cause failures in bytecodeText tests for 'for' loops,
// examine the resulting bytecode shape carefully.
// Range and progression-based loops generated with Kotlin compiler should be
// as close as possible to Java counter loops ('for (int i = a; i < b; ++i) { ... }').
// Otherwise it may result in performance regression due to missing HotSpot optimizations.
// Run Kotlin compiler benchmarks (https://github.com/Kotlin/kotlin-benchmarks)
// with compiler built from your changes if you are not sure.

const val UBYTE_C: UByte = 10u
const val USHORT_C: UShort = 10u

fun testUInt(a: UInt): Int {
    var sum = 0
    for (i in (a until 10u).reversed()) sum += i.toInt()
    for (i in (a..<10u).reversed()) sum += i.toInt()
    for (i in a until 10u step 3) sum += i.toInt()
    for (i in a..<10u step 3) sum += i.toInt()
    for (i in (a until 10u).reversed() step 3) sum += i.toInt()
    for (i in (a until 10u step 3).reversed()) sum += i.toInt()
    return sum
}

fun testULong(a: ULong): Long {
    var sum = 0L
    for (i in (a until 10uL).reversed()) sum += i.toLong()
    for (i in (a..<10uL).reversed()) sum += i.toLong()
    for (i in a until 10uL step 3L) sum += i.toLong()
    for (i in a..<10uL step 3L) sum += i.toLong()
    return sum
}

fun testUByteAndUShort(a: UByte, b: UShort): Int {
    var sum = 0
    for (i in (a until UBYTE_C).reversed()) sum += i.toInt()
    for (i in a until UBYTE_C step 3) sum += i.toInt()
    for (i in (b until USHORT_C).reversed()) sum += i.toInt()
    for (i in b until USHORT_C step 3) sum += i.toInt()
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
// 8 INVOKESTATIC kotlin/internal/UProgressionUtilKt.getProgressionLastElement
// 0 NEW java/lang/IllegalArgumentException
// 0 ATHROW
// 0 INVOKESTATIC kotlin/U(Int|Long).constructor-impl
// 0 INVOKE\w+ kotlin/U(Int|Long).(un)?box-impl

// 28 IF
// 87 ILOAD
// 42 ISTORE
// 10 IADD
// 0 ISUB
// 10 IINC
