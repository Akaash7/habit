package com.habit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.habit.CartScreen.CartScreen
import com.habit.MainScreen.MainScreen
import com.habit.ui.theme.HabitTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            HabitTheme {
                NavHost(navController = navController, startDestination = "cart") {
                    composable("home") { MainScreen(navController) }
                    composable("cart") { CartScreen(navController) }
                }
            }
        }
    }
}
