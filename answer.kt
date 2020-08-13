fun StringChallenge(str: String): String {
    return recurseSecond(str).toString()
}

fun recurseSecond(inputString: String): Int {
    var minimalLength = inputString.length
    for (index in 0..inputString.length - 2) {
        val firstChar = inputString[index]
        val secondChar = inputString[index + 1]
        if (firstChar != secondChar) {
            val currentPair = firstChar.toString() + secondChar.toString()
            val newString = inputString.replaceFirst(
                currentPair,
                thirdChar(firstChar, secondChar)
            )
            val newLength = recurseSecond(newString)
            if (newLength == 1) {
                minimalLength = 1
                break
            }
            if (newLength < minimalLength) {
                minimalLength = newLength
            }
        }
    }
    return minimalLength
}

fun thirdChar(firstChar: Char, secondChar: Char): String {
    val twoChar: String = firstChar.toString() + secondChar.toString()
    if (!twoChar.contains("a")) {
        return "a"
    }
    if (!twoChar.contains("b")) {
        return "b"
    }
    if (!twoChar.contains("c")) {
        return "c"
    }
    return twoChar
}


fun main() {
    println(StringChallenge(readLine()!!))
}
