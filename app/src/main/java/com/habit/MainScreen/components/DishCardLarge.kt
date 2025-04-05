package com.habit.MainScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.data.local.model.Dish
import com.habit.R
import com.habit.ui.theme.HabitPurple

@Composable
fun DishCardLarge(dish: Dish) {
    Row(
        modifier = Modifier.height(intrinsicSize = IntrinsicSize.Min).padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(modifier = Modifier.weight(5.5f).padding(4.dp)) {
            Row(modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp)) {
                Image(
                    modifier = Modifier.size(12.dp),
                    imageVector = ImageVector.vectorResource(if (dish.isVeg) R.drawable.vegicon else R.drawable.nonvegicon),
                    contentDescription = if (dish.isVeg) "Veg" else "Non Veg",
                )
            }
            Text(
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp),
                text = dish.name,
                style =
                    MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                    ),
            )
            Text(
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp),
                text = dish.description,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style =
                    MaterialTheme.typography.bodySmall,
            )
            Text(
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp),
                text = "\u20B9${dish.price}",
                style =
                    MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                    ),
            )
        }
        Box(modifier = Modifier.fillMaxSize().weight(4.5f)) {
            Card(modifier = Modifier.wrapContentSize().align(Alignment.Center), shape = RoundedCornerShape(24.dp)) {
                Image(
                    modifier =
                    Modifier,
                    contentScale = ContentScale.Fit,
                    painter = painterResource(R.drawable.burger),
                    contentDescription = "BurgerImage",
                )
            }

            TextButton(
                modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth(0.6f),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = HabitPurple),
                onClick = { },
            ) {
                Text(
                    text = "ADD",
                    style =
                        MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold,
                        ),
                )
            }
        }
    }
}
