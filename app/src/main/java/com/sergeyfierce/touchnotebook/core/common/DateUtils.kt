package com.sergeyfierce.touchnotebook.core.common

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object DateUtils {
    private val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")

    fun format(date: LocalDate): String = date.format(formatter)

    fun forbidFuture(date: LocalDate): Boolean = !date.isAfter(LocalDate.now())
}
