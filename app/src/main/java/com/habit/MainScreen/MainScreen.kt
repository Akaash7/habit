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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.domain.models.lookingForMore
import com.domain.models.triedTastedLoved
import com.habit.MainScreen.components.DishCardLarge
import com.habit.MainScreen.components.DishCardSmall
import com.habit.MainScreen.components.HabitTitle
import com.habit.ui.theme.HabitPurple
import com.habit.viewmodel.MainViewmodel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavHostController,
    viewmodel: MainViewmodel = hiltViewModel(),
) {
    val cartItems by viewmodel.cartItems.collectAsStateWithLifecycle()
    val dishQuantityMap =
        remember(cartItems) {
            cartItems.associate { it.dish.dishId to it.quantity }
        }

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
                    items(triedTastedLoved, key = { dish -> dish.dishId }) { dish ->
                        val quantity = dishQuantityMap[dish.dishId] ?: 0

                        DishCardSmall(
                            dish,
                            addToCart = { viewmodel.addToCart(dish) },
                            quantity = quantity,
                            onCountIncrease = { viewmodel.addToCart(dish) },
                            onCountDecrease = { viewmodel.removeFromCart(dish) },
                        )
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
                val quantity = dishQuantityMap[dish.dishId] ?: 0

                DishCardLarge(
                    dish,
                    addToCart = { viewmodel.addToCart(dish) },
                    quantity = quantity,
                    onCountIncrease = { viewmodel.addToCart(dish) },
                    onCountDecrease = { viewmodel.removeFromCart(dish = dish) },
                )
            }
        }
    }
}
