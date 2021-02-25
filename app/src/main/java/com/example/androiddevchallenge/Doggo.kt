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

// Just a wrapper around data
data class Doggo(
    val name: String,
    val age: Int,
    val pic: Int,
    val breed: String,
    val gender: String
)

val doggos = arrayOf(
    Doggo("Bernie", 2, R.drawable.beagle, "Beagle", "Male"),
    Doggo("Prof. Woof", 6, R.drawable.old_english_sheepdog, "Old English Sheepdog", "Male"),
    Doggo("Sandy", 2, R.drawable.silky_terrier, "Silky Terrier", "Female"),
    Doggo("Mia", 5, R.drawable.golden_retriever, "Golden Retriver", "Female"),
    Doggo("Charles", 5, R.drawable.chihuahua, "Chihuahua", "Male"),
    Doggo("Sam", 6, R.drawable.japanse_spaniel, "Japanese Spaniel", "Male"),
    Doggo("Alex", 2, R.drawable.affenpinscher, "Affenpinscher", "Female"),
    Doggo("Jack", 3, R.drawable.pomeranian, "Pomeranian", "Male")
)
