package com.tech.instafun.ui.theme


import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tech.instafun.R

val Montserat = FontFamily(
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_semibold, FontWeight.SemiBold),
    Font(R.font.montserrat_bold, FontWeight.Bold),
)


/*val Typography1 = Typography(
    h1 = TextStyle(
        fontFamily = Montserat,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp
    ),

    h2 = TextStyle(
        fontFamily = Montserat,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp
    ),

    h3 = TextStyle(
        fontFamily = Montserat,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp,
        fontSize = 18.sp
    ),

    h4 = TextStyle(
        fontFamily = Montserat,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp,
        fontSize = 14.sp
    ),

    h5 = TextStyle(
        fontFamily = Montserat,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp
    ),

    )*/

/*
h1 → displayLarge
h2 → headlineMedium
h3 → bodyLarge
h4 → bodyMedium
h5 → labelSmall
*/

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Montserat,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Montserat,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Montserat,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 20.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Montserat,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Montserat,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp
    )
    // Add more slots if you need them
)