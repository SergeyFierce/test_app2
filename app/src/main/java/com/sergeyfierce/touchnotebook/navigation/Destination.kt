package com.sergeyfierce.touchnotebook.navigation

import com.sergeyfierce.touchnotebook.core.data.model.Category

sealed class Destination(val route: String) {
    data object Home : Destination("home")
    data class ContactsList(val category: Category) : Destination("contacts/${category.name}")
}
