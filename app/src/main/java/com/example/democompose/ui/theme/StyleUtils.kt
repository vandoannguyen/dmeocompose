package com.example.democompose.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class StyleUtils {
    companion object {
        val style23: TextStyle = TextStyle(fontSize = 23.sp)
        val style14: TextStyle = TextStyle(fontSize = 14.sp)
        val style23W700: TextStyle = style23.copy(
            fontWeight = FontWeight.W700
        )
        val style23W400: TextStyle = style23.copy(
            fontWeight = FontWeight.W400
        )
        val style14W400: TextStyle = style14.copy(fontWeight = FontWeight.W400)
    }
}