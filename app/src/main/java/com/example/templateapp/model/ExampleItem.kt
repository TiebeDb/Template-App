package com.example.templateapp.model

data class ExampleItem(val name: String)

fun GetItems(): List<ExampleItem> {
    return listOf(
        ExampleItem("Leeuw"),
        ExampleItem("Olifant"),
        ExampleItem("Giraffe"),
        ExampleItem("Zebra"),
        ExampleItem("Nijlpaard")
    )
}