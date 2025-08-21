package com.sergeyfierce.touchnotebook.core.data.model

import java.time.LocalDate

data class Contact(
    val id: Long,
    val name: String,
    val birthDate: LocalDate?,
    val city: String?,
    val phone: String,
    val email: String?,
    val category: Category,
    val status: Status,
    val labels: List<Label> = emptyList(),
    val notes: List<Note> = emptyList()
)
