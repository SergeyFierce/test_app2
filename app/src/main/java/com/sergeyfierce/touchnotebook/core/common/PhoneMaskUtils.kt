package com.sergeyfierce.touchnotebook.core.common

object PhoneMaskUtils {
    /**
     * Formats raw digits into +7 (XXX) XXX-XX-XX. Non-digit characters are removed before formatting.
     */
    fun format(input: String): String {
        val digits = input.filter { it.isDigit() }.trimStart('7').take(10)
        val builder = StringBuilder("+7 ")
        for (i in digits.indices) {
            val c = digits[i]
            when (i) {
                0 -> builder.append('(').append(c)
                2 -> builder.append(c).append(") ")
                3 -> builder.append(c)
                5 -> builder.append(c).append('-')
                7 -> builder.append(c).append('-')
                else -> builder.append(c)
            }
        }
        return builder.toString()
    }
}
