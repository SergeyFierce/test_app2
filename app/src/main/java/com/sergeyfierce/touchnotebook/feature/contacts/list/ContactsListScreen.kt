package com.sergeyfierce.touchnotebook.feature.contacts.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun ContactsListRoute(navController: NavController, viewModel: ContactsListViewModel = hiltViewModel()) {
    val state by viewModel.uiState.collectAsState()
    ContactsListScreen(state)
}

@Composable
fun ContactsListScreen(state: ContactsListUiState) {
    Scaffold(topBar = { TopAppBar(title = { Text("Контакты") }) }) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize()) {
            state.contacts.forEach { contact ->
                ListItem(headlineContent = { Text(contact.name) })
            }
        }
    }
}
