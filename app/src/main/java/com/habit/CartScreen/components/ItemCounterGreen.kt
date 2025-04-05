package com.habit.CartScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.habit.ui.theme.HabitDarkGreen
import com.habit.ui.theme.HabitLightGreen

@Composable
fun ItemCounterGreen(
    count: Int = 0,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit,
) {
    Card(
        modifier = Modifier.padding(vertical = 6.dp, horizontal = 12.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.outlinedCardColors(containerColor = HabitLightGreen),
        border = BorderStroke(width = 1.dp, color = HabitDarkGreen),
    ) {
        Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                modifier = Modifier.clickable { onDecrease() }.padding(horizontal = 6.dp),
                text = "-",
                fontSize = 14.sp,
            )
            Text(
                modifier = Modifier.clickable { onDecrease() },
                text = count.toString(),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
            )
            Text(
                modifier = Modifier.clickable { onDecrease() }.padding(horizontal = 6.dp),
                text = "+",
                fontSize = 14.sp,
            )
        }
    }
}
