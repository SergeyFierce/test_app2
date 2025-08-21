package com.sergeyfierce.touchnotebook.feature.contacts.list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergeyfierce.touchnotebook.core.data.model.Category
import com.sergeyfierce.touchnotebook.core.data.model.Contact
import com.sergeyfierce.touchnotebook.core.data.repository.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ContactsListUiState(val contacts: List<Contact> = emptyList())

@HiltViewModel
class ContactsListViewModel @Inject constructor(
    private val repository: ContactRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val category: Category = savedStateHandle.get<String>("category")?.let { Category.valueOf(it) } ?: Category.CLIENT
    private val _uiState = MutableStateFlow(ContactsListUiState())
    val uiState: StateFlow<ContactsListUiState> = _uiState

    init {
        viewModelScope.launch {
            repository.getContacts(category).collectLatest { list ->
                _uiState.value = ContactsListUiState(list)
            }
        }
    }
}
