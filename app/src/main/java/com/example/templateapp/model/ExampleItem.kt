package com.example.templateapp.model

// Simple model used in the example screens.
data class ExampleItem(
    val name: String,
    // Extra info to display on the screens
    val description: String
)

// Returns some hard coded items so the app works without a backend.
fun GetItems(): List<ExampleItem> {
    // Normally this would come from a backend or database
    return listOf(
        ExampleItem("Leeuw", "De koning van de savanne"),
        ExampleItem("Olifant", "Het grootste landdier"),
        ExampleItem("Giraffe", "Heeft een hele lange nek"),
        ExampleItem("Zebra", "Paard met streepjes"),
        ExampleItem("Nijlpaard", "Woont graag in het water")
    )
}