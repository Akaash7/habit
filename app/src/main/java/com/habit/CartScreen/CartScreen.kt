package com.habit.CartScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.twotone.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.data.local.model.lookingForMore
import com.habit.CartScreen.components.CartItem
import com.habit.ui.theme.HabitDarkGreen
import com.habit.ui.theme.HabitPurple

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(navController: NavHostController) {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(
            title = { Text("Your Cart", style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)) },
            navigationIcon = {
                IconButton(onClick = { navController.navigate("home") }) {
                    Icon(Icons.AutoMirrored.TwoTone.ArrowBack, contentDescription = "Arrow Back")
                }
            },
        )
    }) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Card(
                modifier = Modifier.wrapContentSize().padding(8.dp),
                colors = CardDefaults.cardColors().copy(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
                shape = RoundedCornerShape(12.dp),
            ) {
                LazyColumn(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
                    items(lookingForMore.take(3)) {
                        CartItem(it)
                    }
                    item {
                        Text(
                            modifier =
                                Modifier
                                    .clickable {
                                        navController.navigate("home")
                                    }.padding(8.dp),
                            text = "+ Add Items",
                            style = TextStyle.Default.copy(color = HabitDarkGreen, fontWeight = FontWeight.Medium),
                        )
                    }
                }
            }
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors().copy(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(0.9f).padding(12.dp).align(alignment = Alignment.CenterHorizontally),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors().copy(containerColor = HabitPurple),
                ) {
                    Text("PAY")
                }
            }
        }
    }
}
