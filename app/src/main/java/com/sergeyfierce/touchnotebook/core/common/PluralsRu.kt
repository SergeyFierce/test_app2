package com.sergeyfierce.touchnotebook.core.common

object PluralsRu {
    /**
     * Returns correct form of "контакт" for the provided number.
     */
    fun contact(count: Int): String {
        val mod10 = count % 10
        val mod100 = count % 100
        return when {
            mod10 == 1 && mod100 != 11 -> "контакт"
            mod10 in 2..4 && mod100 !in 12..14 -> "контакта"
            else -> "контактов"
        }
    }
}
