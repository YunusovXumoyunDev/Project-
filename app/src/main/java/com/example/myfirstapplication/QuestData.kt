package com.example.myfirstapplication

import androidx.annotation.DrawableRes

/**
 *  This file is created by Saidmurod Turdiyev SMT for Android First app
 *  2/3/2024  7:25 PM  Asus Rog
 */
data class QuestData(
    @DrawableRes
    var imageOne: Int,
    @DrawableRes
    var imageTwo: Int,
    @DrawableRes
    val imageThree: Int,
    @DrawableRes
    val imageFour: Int,
    val word: String
)

fun loadQuest(): List<QuestData> {
    val ls = ArrayList<QuestData>()
    ls.add(
        QuestData(
            imageOne = R.drawable.dog,
            imageTwo = R.drawable.dog_image,
            imageThree = R.drawable.dog_1,
            imageFour = R.drawable.dog_2,
            word = "Dog"
        )
    )
    ls.add(
        QuestData(
            imageOne = R.drawable.animal_1,
            imageTwo = R.drawable.animal_2,
            imageThree = R.drawable.animal_3,
            imageFour = R.drawable.animal_4,
            word = "Animal"
        )
    )
    ls.add(
        QuestData(
            imageOne = R.drawable.fruit_1,
            imageTwo = R.drawable.fruit_2,
            imageThree = R.drawable.fruit_3,
            imageFour = R.drawable.fruit_4,
            word = "Fruit"
        )
    )
    ls.add(
        QuestData(
            imageOne = R.drawable.flag_1,
            imageTwo = R.color.white,
            imageThree = R.color.red,
            imageFour = R.color.dark_blue,
            word = "America"
        )
    )
    ls.add(
        QuestData(
            imageOne = R.drawable.city_1,
            imageTwo = R.drawable.city_2,
            imageThree = R.drawable.city_3,
            imageFour = R.drawable.city_4,
            word = "City"
        )
    )
    return ls
}
