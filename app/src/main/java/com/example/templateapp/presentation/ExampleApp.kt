package com.example.templateapp.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ExampleApp() {
    val navController = rememberNavController()
    ExampleNavHost(navController)
}

@Composable
fun ExampleNavHost(navController: NavHostController, viewModel: ExampleViewModel = hiltViewModel()) {
    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            ExampleListScreen(Modifier, viewModel) { index ->
                viewModel.setIndex(index)
                navController.navigate("detail")
            }
        }
        composable("detail") {
            ExampleDetailScreen(Modifier)
        }
        composable("add") {
            ExampleAddScreen(Modifier, onAdded = { navController.navigateUp() })
        }
        composable("settings") {
            ExampleSettingsScreen(Modifier)
        }
        composable("about") {
            ExampleAboutScreen(Modifier)
        }
    }
}
