package com.pesta.homedecor.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.pesta.homedecor.R

// Set of Material typography styles to start with

val LeagueSpartan = FontFamily(
    Font(R.font.league_spartan, FontWeight.Normal),
    Font(R.font.league_spartan_light, FontWeight.Light)
)

val Poppins = FontFamily(
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
)

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = Poppins,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold
    ),
    titleMedium = TextStyle(
        fontFamily = Poppins,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium
    ),
    bodyMedium = TextStyle(
        fontFamily = LeagueSpartan,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    )
)