package com.habit.MainScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.habit.ui.theme.HabitPurple
import com.habit.ui.theme.HabitPurpleLight

@Composable
fun DiscountLabel(discount: Int) {
    Card(
        modifier = Modifier.wrapContentSize().padding(horizontal = 22.dp),
        colors = CardDefaults.cardColors(containerColor = HabitPurpleLight, contentColor = HabitPurple),
        shape =
            RoundedCornerShape(
                bottomStart = 12.dp,
                bottomEnd = 12.dp,
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Column(
            modifier = Modifier.padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "$discount%\nOFF",
                style =
                    MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Bold,
                    ),
            )
        }
    }
}
