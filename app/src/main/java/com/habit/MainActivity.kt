package com.habit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.habit.CartScreen.CartScreen
import com.habit.MainScreen.MainScreen
import com.habit.ui.theme.HabitTheme
import com.habit.viewmodel.MainViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            HabitTheme {
                val sharedViewModel = hiltViewModel<MainViewmodel>()

                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { MainScreen(viewmodel = sharedViewModel, navController = navController) }
                    composable("cart") { CartScreen(viewmodel = sharedViewModel, navController = navController) }
                }
            }
        }
    }
}
