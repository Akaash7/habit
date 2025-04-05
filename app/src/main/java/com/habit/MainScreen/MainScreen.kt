package com.habit.MainScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.data.local.model.lookingForMore
import com.data.local.model.triedTastedLoved
import com.habit.MainScreen.components.DishCardLarge
import com.habit.MainScreen.components.DishCardSmall
import com.habit.MainScreen.components.HabitTitle
import com.habit.ui.theme.HabitPurple

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { HabitTitle() }, actions = {
                IconButton(onClick = { navController.navigate("cart") }) {
                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "")
                }
            })
        },
    ) { innerPadding ->
        LazyColumn(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
        ) {
            item {
                Text(
                    modifier = Modifier.padding(12.dp),
                    text = "TRIED, TASTED & LOVED",
                    style = MaterialTheme.typography.titleMedium,
                    color = HabitPurple,
                )
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(triedTastedLoved) { dish ->
                        DishCardSmall(dish)
                    }
                }
            }
            item {
                Text(
                    modifier = Modifier.padding(12.dp),
                    text = "LOOKING FOR EVEN MORE?",
                    style = MaterialTheme.typography.titleMedium,
                    color = HabitPurple,
                )
            }
            items(lookingForMore) { dish ->
                DishCardLarge(dish)
            }
        }
    }
}
