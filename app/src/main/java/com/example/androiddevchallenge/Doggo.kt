package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

// Just a wrapper around data
data class Doggo(
    val name: String,
    val age: Int,
    val pic: Int,
    val breed: String
)

val doggos = arrayOf(
    Doggo("Bernie", 2, R.drawable.beagle, "Beagle"),
    Doggo("Charles", 5, R.drawable.chihuahua, "Chihuahua"),
    Doggo("Sam", 6, R.drawable.japanse_spaniel, "Japanese Spaniel"),
    Doggo("Jack", 2, R.drawable.silky_terrier, "Silky Terrier")
)
