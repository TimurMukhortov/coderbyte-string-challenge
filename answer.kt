fun StringChallenge(str: String): String {
    return recurseSecond(str).toString()
}

fun recurseSecond(inputString: String): Int {
    var minimalLength = inputString.length
    for (index in 0..inputString.length - 2) {
        val firstChar = inputString[index]
        val secondChar = inputString[index + 1]
        if (firstChar != secondChar) {
            val currentPair = firstChar.concat(secondChar)
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
    if (firstChar != 'a' && secondChar != 'a') {
        return "a"
    }
    if (firstChar != 'b' && secondChar != 'b') {
        return "b"
    }
    if (firstChar != 'c' && secondChar != 'c') {
        return "c"
    }
    return firstChar.concat(secondChar)
}

infix fun Char.concat(secondChar: Char): String = this.toString() + secondChar.toString()

fun main() {
    println(StringChallenge(readLine()!!))
}
