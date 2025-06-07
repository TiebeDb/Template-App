package com.example.templateapp.domain.repository

import com.example.templateapp.model.ExampleItem

interface ExampleRepository {
    suspend fun getItems(): List<ExampleItem>
}
