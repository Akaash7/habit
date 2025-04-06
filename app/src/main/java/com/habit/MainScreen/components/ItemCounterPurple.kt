package com.habit.MainScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.habit.ui.theme.HabitPurple

@Composable
fun ItemCounterPurple(
    count: Int = 0,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth().background(color = HabitPurple),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            modifier = Modifier.clickable { onDecrease() },
            text = "-",
            color = Color.White,
            style =
                MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                ),
        )
        Text(
            modifier = Modifier.padding(horizontal = 12.dp),
            text = count.toString(),
            color = Color.White,
            style =
                MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                ),
        )
        Text(
            modifier = Modifier.clickable { onIncrease() },
            text = "+",
            color = Color.White,
            style =
                MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                ),
        )
    }
}
