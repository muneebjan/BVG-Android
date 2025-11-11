package com.example.bvgnativ.screens

//import StopSearchScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bvgnativ.viewmodel.MainViewModel
import androidx.navigation.NavType
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.navArgument

sealed class Screen(val route: String) {
    object StopSearch : Screen("stop_search")
    object Departures : Screen("departures/{stopId}") {
        fun createRoute(stopId: String) = "departures/$stopId"
    }
}

@Composable
fun AppNavGraph(mainViewModel: MainViewModel = viewModel()) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.StopSearch.route) {

        composable(Screen.StopSearch.route) {
            StopSearchScreen(
                mainViewModel = mainViewModel,
                onStopClick = { stop ->
                    mainViewModel.getDepartures(stop.id ?: "")
                    navController.navigate(Screen.Departures.createRoute(stop.id ?: ""))
                }
            )
        }

        composable(
            route = Screen.Departures.route,
            arguments = listOf(navArgument("stopId") { type = NavType.StringType })
        ) { backStackEntry ->

            val stopId = backStackEntry.arguments?.getString("stopId") ?: return@composable

            // Fetch departures when screen opens
            LaunchedEffect(stopId) {
                mainViewModel.getDepartures(stopId)
            }

            val departures by mainViewModel.departures.collectAsState()
            DeparturesScreen(
                departures = departures,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
