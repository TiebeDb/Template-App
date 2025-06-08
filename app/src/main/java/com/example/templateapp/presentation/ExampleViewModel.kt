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

// Hilt creates this ViewModel and supplies the repository instance.
@HiltViewModel
class ExampleViewModel @Inject constructor(
    private val repository: ExampleRepository
) : ViewModel() {
    // Backing state flow for the UI. It starts empty until loadItems() updates it.
    private val _items = MutableStateFlow<List<ExampleItem>>(emptyList())
    val items: StateFlow<List<ExampleItem>> = _items

    // Index of the currently selected item for the detail screen
    private val _currentIndex = MutableStateFlow(0)
    val currentIndex: StateFlow<Int> = _currentIndex

    // Fetch items asynchronously using the ViewModel's coroutine scope.
    fun loadItems() {
        viewModelScope.launch {
            _items.value = repository.getItems()
        }
    }

    // Retrieve the item at the current index if available
    fun currentItem(): ExampleItem? = _items.value.getOrNull(_currentIndex.value)

    // Update the current index to show the next item
    fun nextItem() {
        val next = (_currentIndex.value + 1).coerceAtMost(_items.value.lastIndex)
        _currentIndex.value = next
    }

    // Update the current index to show the previous item
    fun previousItem() {
        val prev = (_currentIndex.value - 1).coerceAtLeast(0)
        _currentIndex.value = prev
    }

    fun setIndex(index: Int) {
        _currentIndex.value = index.coerceIn(0, _items.value.lastIndex)
    }

    // Add an item to the list (in-memory for this example)
    fun addItem(item: ExampleItem) {
        _items.value = _items.value + item
    }
}
