package com.habit.CartScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.data.local.model.Dish
import com.habit.R

@Composable
fun CartItem(dish: Dish) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier.size(12.dp),
            imageVector = ImageVector.vectorResource(if (dish.isVeg) R.drawable.vegicon else R.drawable.nonvegicon),
            contentDescription = if (dish.isVeg) "Veg" else "Non Veg",
        )
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = dish.name, style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium))
            Text(
                text = "Customise selection",
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium, color = Color.LightGray),
            )
        }

        ItemCounterGreen(
            onIncrease = {},
            onDecrease = {},
        )
        Text(
            text = "\u20B9${dish.price}",
        )
    }
}
