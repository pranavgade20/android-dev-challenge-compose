/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                Base()
            }
        }
    }
}

// Start building your app here!
@Composable
fun Base() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "MyApp") {
        composable("MyApp") { MyApp(navController) }
        composable("details/{id}",) { navBackStackEntry -> openDetails(navController, navBackStackEntry.arguments?.getString("id", "0")) }
    }
}

@Composable
fun MyApp(navController: NavController) {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            doggos.forEach { d -> listDoggo(data = d, navController = navController) }
        }
    }
}

@Composable
fun listDoggo(navController: NavController, data: Doggo) {
    MaterialTheme {
        val typography = MaterialTheme.typography
        Column(
            modifier = Modifier.padding(16.dp)
                .clickable(onClick = { navController.navigate("details/" + doggos.indexOf(data)) {} })
        ) {
            Image(
                painter = painterResource(id = data.pic),
                contentDescription = null,
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.requiredHeight(10.dp))
            Text(text = data.name + ", " + data.age, style = typography.h6)
        }
    }
}

@Composable
fun openDetails(navController: NavController, id: String?) {
    var doggo = doggos[if (id != null) Integer.parseInt(id) else 0]

    MyTheme {
        MaterialTheme {
            val typography = MaterialTheme.typography
            Column(modifier = Modifier.padding(16.dp)) {
                Image(
                    painter = painterResource(id = doggo.pic),
                    contentDescription = null,
                    modifier = Modifier
                        .height(360.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.requiredHeight(8.dp))
                Text(text = doggo.name, style = typography.h4, color = Color.White)
                Text(text = "Age: " + doggo.age.toString(), style = typography.h6, color = Color.White)
                Text(text = "Gender: " + doggo.gender, style = typography.h6, color = Color.White)
                Text(text = "Breed: " + doggo.breed, style = typography.h6, color = Color.White)
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        Base()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Base()
    }
}
