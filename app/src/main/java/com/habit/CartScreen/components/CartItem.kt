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
import com.domain.models.CartItem
import com.habit.R

@Composable
fun CartItem(
    cartItem: CartItem,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier.weight(1f).size(12.dp),
            imageVector = ImageVector.vectorResource(if (cartItem.dish.isVeg) R.drawable.vegicon else R.drawable.nonvegicon),
            contentDescription = if (cartItem.dish.isVeg) "Veg" else "Non Veg",
        )
        Column(modifier = Modifier.weight(4f).padding(8.dp)) {
            Text(text = cartItem.dish.name, style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium))
            Text(
                text = "Customise selection",
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium, color = Color.LightGray),
            )
        }

        ItemCounterGreen(
            count = cartItem.quantity,
            onIncrease = onIncrease,
            onDecrease = onDecrease,
        )
        Text(
            modifier = Modifier.weight(1f),
            text = "\u20B9${cartItem.dish.price}",
        )
    }
}
