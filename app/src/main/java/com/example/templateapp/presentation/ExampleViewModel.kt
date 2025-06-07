package com.example.templateapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.templateapp.data.repository.ExampleRepository
import com.example.templateapp.model.ExampleItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class ExampleViewModel @Inject constructor(
    private val repository: ExampleRepository
) : ViewModel() {
    private val _items = MutableStateFlow<List<ExampleItem>>(emptyList())
    val items: StateFlow<List<ExampleItem>> = _items

    fun loadItems() {
        viewModelScope.launch {
            _items.value = repository.getItems()
        }
    }
}
