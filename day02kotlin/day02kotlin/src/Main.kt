import java.io.File
import kotlin.math.abs

fun main() {
    var sum = 0

    File ("input.txt").reader().useLines{ lines ->lines.forEach {
        val levels = it.split(" ")
        var isLineOK = true

        for ((index, level) in levels.withIndex()) {
            if(index == levels.lastIndex) {
                break
            }

            if (level.toInt() >= levels[index+1].toInt()) {
                isLineOK = false
                break
            }

            if (abs(level.toInt() - levels[index+1].toInt()) > 3) {
                isLineOK = false
                break
            }
        }

        if (!isLineOK) {
            for ((remIndex, _) in levels.withIndex()) {
                var tempOk = true

                for ((index, level) in levels.withIndex()) {
                    if (index == levels.lastIndex) break
                    if (index == remIndex) continue

                    var laterIndex = index + 1
                    if (laterIndex == remIndex) laterIndex++
                    if (laterIndex > levels.lastIndex) break

                    if (level.toInt() >= levels[laterIndex].toInt()) {
                        tempOk = false
                        break
                    }

                    if (abs(level.toInt() - levels[laterIndex].toInt()) > 3) {
                        tempOk = false
                        break
                    }
                }

                if (tempOk) {
                    isLineOK = true
                    break
                }
            }
        }

        if (!isLineOK) {
            isLineOK = true

            for ((index, level) in levels.withIndex()) {
                if(index == levels.lastIndex) {
                    break
                }

                if (level.toInt() <= levels[index+1].toInt()) {
                    isLineOK = false
                    break
                }

                if (abs(level.toInt() - levels[index+1].toInt()) > 3) {
                    isLineOK = false
                    break
                }
            }
        }

        if (!isLineOK) {
            for ((remIndex, _) in levels.withIndex()) {
                var tempOk = true

                for ((index, level) in levels.withIndex()) {
                    if (index == levels.lastIndex) break
                    if (index == remIndex) continue

                    var laterIndex = index + 1
                    if (laterIndex == remIndex) laterIndex++
                    if (laterIndex > levels.lastIndex) break

                    if (level.toInt() <= levels[laterIndex].toInt()) {
                        tempOk = false
                        break
                    }

                    if (abs(level.toInt() - levels[laterIndex].toInt()) > 3) {
                        tempOk = false
                        break
                    }
                }

                if (tempOk) {
                    isLineOK = true
                    break
                }
            }
        }

        if (isLineOK) {
            sum++
            println(it)
        }
    }}

    println(sum)
}