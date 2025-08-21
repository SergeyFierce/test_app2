package com.sergeyfierce.touchnotebook.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergeyfierce.touchnotebook.core.common.PluralsRu
import com.sergeyfierce.touchnotebook.core.data.model.Category
import com.sergeyfierce.touchnotebook.core.data.repository.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CategoryUi(val category: Category, val count: Int)

data class HomeUiState(val categories: List<CategoryUi> = emptyList())

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ContactRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        loadCounts()
    }

    private fun loadCounts() {
        viewModelScope.launch {
            val items = Category.values().map { cat ->
                // repository counts not implemented; using 0
                CategoryUi(cat, 0)
            }
            _uiState.value = HomeUiState(items)
        }
    }

    fun title(category: CategoryUi): String =
        "${category.category.title} (${category.count} ${PluralsRu.contact(category.count)})"
}
