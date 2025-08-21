package com.sergeyfierce.touchnotebook.core.data.model

import java.time.LocalDate

data class Note(
    val id: Long,
    val contactId: Long,
    val text: String,
    val date: LocalDate
)
