package com.example.templateapp.presentation

import com.example.templateapp.R
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class ExampleScreen(@StringRes val title: Int) {
    List(title = R.string.app_name),
}

@Composable
fun ExampleApp() {
    val navController = rememberNavController()
    ExampleNavHost(navController)
}

@Composable
fun ExampleNavHost(navController: NavHostController, viewModel: ExampleViewModel = hiltViewModel()) {
    NavHost(navController = navController, startDestination = ExampleScreen.List.name) {
        composable(ExampleScreen.List.name) {
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
