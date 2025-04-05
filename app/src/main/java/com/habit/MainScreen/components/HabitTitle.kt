package com.habit.MainScreen.components

import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.habit.ui.theme.HabitPurple

@Composable
fun HabitTitle(
    fontSize: TextUnit = 24.sp,
    smallLetterSize: TextUnit = 32.sp,
) {
    val text =
        buildAnnotatedString {
            append("H")
            withStyle(style = SpanStyle(fontSize = smallLetterSize, fontWeight = FontWeight.Medium)) {
                append("a")
            }
            append("BIT")
        }

    BasicText(
        text = text,
        style =
            MaterialTheme.typography.bodyLarge.copy(
                fontSize = fontSize,
                fontWeight = FontWeight.Bold,
                color = HabitPurple,
            ),
    )
}
