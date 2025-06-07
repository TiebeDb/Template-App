package com.example.templateapp.model

// Simple model used in the example screens.
data class ExampleItem(val name: String)

// Returns some hard coded items so the app works without a backend.
fun GetItems(): List<ExampleItem> {
    return listOf(
        ExampleItem("Leeuw"),
        ExampleItem("Olifant"),
        ExampleItem("Giraffe"),
        ExampleItem("Zebra"),
        ExampleItem("Nijlpaard")
    )
}