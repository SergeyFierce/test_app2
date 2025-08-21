package com.sergeyfierce.touchnotebook.feature.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
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
import com.sergeyfierce.touchnotebook.navigation.Destination

@Composable
fun HomeRoute(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.uiState.collectAsState()
    HomeScreen(state) { cat ->
        navController.navigate(Destination.ContactsList(cat.category).route)
    }
}

@Composable
fun HomeScreen(state: HomeUiState, onCategoryClick: (CategoryUi) -> Unit) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Touch NoteBook") }) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize()) {
            state.categories.forEach { category ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { onCategoryClick(category) }
                ) {
                    Text(
                        text = viewTitle(category),
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}

private fun viewTitle(category: CategoryUi): String =
    "${category.category.title} – ${category.count}"
