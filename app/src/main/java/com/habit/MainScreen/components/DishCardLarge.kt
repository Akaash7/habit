package com.habit.MainScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.domain.models.Dish
import com.habit.R
import com.habit.ui.theme.HabitPurple
import com.habit.ui.theme.HabitPurpleLight

@Composable
fun DishCardLarge(
    dish: Dish,
    quantity: Int,
    addToCart: () -> Unit,
    onCountIncrease: () -> Unit,
    onCountDecrease: () -> Unit,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier =
                Modifier
                    .height(intrinsicSize = IntrinsicSize.Min)
                    .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier =
                    Modifier
                        .weight(5.5f)
                        .padding(4.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp, horizontal = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        modifier = Modifier.size(12.dp),
                        imageVector = ImageVector.vectorResource(if (dish.isVeg) R.drawable.vegicon else R.drawable.nonvegicon),
                        contentDescription = if (dish.isVeg) "Veg" else "Non Veg",
                    )
                    if (dish.discount > 0) {
                        Card(
                            modifier = Modifier.wrapContentSize().padding(horizontal = 4.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = CardDefaults.cardColors(containerColor = HabitPurpleLight, contentColor = HabitPurple),
                        ) {
                            Text(
                                modifier = Modifier.padding(2.dp),
                                text = "${dish.discount}% OFF",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
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
            Box(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .weight(4.5f),
            ) {
                Card(
                    modifier =
                        Modifier
                            .wrapContentSize()
                            .align(Alignment.Center),
                    shape = RoundedCornerShape(24.dp),
                ) {
                    Image(
                        modifier =
                        Modifier,
                        contentScale = ContentScale.Fit,
                        painter = painterResource(R.drawable.burger),
                        contentDescription = "BurgerImage",
                    )
                }
                TextButton(
                    modifier =
                        Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth(0.6f)
                            .clickable(enabled = false) {},
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = HabitPurple),
                    onClick = { addToCart() },
                ) {
                    if (quantity > 0) {
                        ItemCounterPurple(count = quantity, onDecrease = onCountDecrease, onIncrease = onCountIncrease)
                    } else {
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
        HorizontalDivider(
            modifier =
                Modifier
                    .fillMaxWidth(0.9f),
            color = Color.LightGray.copy(alpha = 0.4f),
            thickness = 1.dp,
        )
    }
}
