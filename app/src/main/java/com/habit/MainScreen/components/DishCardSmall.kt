package com.habit.MainScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.unit.dp
import com.data.local.model.Dish
import com.habit.R
import com.habit.ui.theme.HabitPurple
import com.habit.ui.theme.HabitPurpleLight

@Composable
fun DishCardSmall(dish: Dish) {
    Card(
        modifier =
            Modifier
                .size(width = 200.dp, height = 300.dp)
                .padding(horizontal = 12.dp, vertical = 6.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors().copy(containerColor = HabitPurpleLight),
    ) {
        Box(modifier = Modifier.fillMaxSize().weight(6f)) {
            Image(
                modifier =
                    Modifier
                        .fillMaxHeight(),
                contentScale = ContentScale.Crop,
                painter = painterResource(R.drawable.burger),
                contentDescription = "BurgerImage",
            )
            if (dish.discount != 0) {
                DiscountLabel(dish.discount)
            }
            Column(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Bottom,
            ) {
                if (dish.isVeg) {
                    Image(
                        modifier = Modifier.size(12.dp),
                        imageVector = ImageVector.vectorResource(R.drawable.vegicon),
                        contentDescription = "Veg",
                    )
                } else {
                    Image(
                        modifier = Modifier.size(12.dp),
                        imageVector = ImageVector.vectorResource(R.drawable.nonvegicon),
                        contentDescription = "Non Veg",
                    )
                }
            }
        }
        Column(modifier = Modifier.weight(4f).padding(8.dp), verticalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = dish.name,
                style =
                    MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                    ),
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.weight(4f),
                    text = "\u20B9${dish.price}",
                    style =
                        MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold,
                        ),
                )
                TextButton(
                    modifier = Modifier.weight(6f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = HabitPurple),
                    onClick = { },
                ) {
                    Text(
                        text = "ADD",
                        style =
                            MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Bold,
                            ),
                    )
                }
            }
        }
    }
}
