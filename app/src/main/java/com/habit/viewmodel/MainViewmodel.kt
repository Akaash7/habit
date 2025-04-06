package com.habit.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.domain.models.CartItem
import com.domain.models.Dish
import com.domain.models.lookingForMore
import com.domain.models.triedTastedLoved
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainViewmodel
    @Inject
    constructor() : ViewModel() {
        private val _cartItems: MutableStateFlow<List<CartItem>> = MutableStateFlow(emptyList())
        val cartItems = _cartItems.asStateFlow()

        private val _triedDishes: MutableStateFlow<List<Dish>> = MutableStateFlow(triedTastedLoved)
        val triedDishes = _triedDishes.asStateFlow()

        private val _moreDishes: MutableStateFlow<List<Dish>> = MutableStateFlow(lookingForMore)
        val moreDishes = _moreDishes.asStateFlow()

        fun addToCart(dish: Dish) {
            _cartItems.update { currentItems ->
                val index = currentItems.indexOfFirst { it.dish.dishId == dish.dishId }
                if (index != -1) {
                    val updatedList = currentItems.toMutableList()
                    val existingItem = updatedList[index]
                    updatedList[index] = existingItem.copy(quantity = existingItem.quantity + 1)
                    updatedList
                } else {
                    currentItems + CartItem(dish, 1)
                }
            }
            Log.d("DishList", cartItems.value.size.toString())
        }

        fun removeFromCart(dish: Dish) {
            val existing = _cartItems.value.find { currentItem -> currentItem.dish.dishId == dish.dishId }
            _cartItems.value =
                if (existing != null && existing.quantity > 1) {
                    _cartItems.value.map { currentItem ->
                        if (currentItem.dish.dishId == dish.dishId) currentItem.copy(quantity = currentItem.quantity - 1) else currentItem
                    }
                } else {
                    _cartItems.value.filter { currentItem -> currentItem.dish.dishId != dish.dishId }
                }
        }

        fun getDishQuantity(dishId: Int): Int = _cartItems.value.find { currentItem -> currentItem.dish.dishId == dishId }?.quantity ?: 0
    }
