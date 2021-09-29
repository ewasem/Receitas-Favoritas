package com.ewapps.receitasfavoritas.utils

import com.ewapps.receitasfavoritas.BuildConfig

object Constants {

    const val ALL_ITEMS: String = "Todas"
    const val FILTER_SELECTION: String = "FilterSelection"
    const val DISH_TYPE: String = "DishType"
    const val DISH_CATEGORY: String = "DishCategory"
    const val DISH_COOKING_TIME: String = "DishCookingTime"
    const val DISH_IMAGE_SOURCE_LOCAL: String = "Local"
    const val DISH_IMAGE_SOURCE_ONLINE: String = "Online"
    const val EXTRA_DISH_DETAILS: String = "DishDetails"
    const val API_ENDPOINT: String= "recipes/random"
    const val API_KEY: String = "apiKey"
    const val LIMIT_LICENSE: String = "limitLicense"
    const val TAGS: String = "tags"
    const val NUMBER: String = "number"
    const val BASE_URL = "https://api.spoonacular.com/"
    const val API_KEY_VALUE: String = BuildConfig.API_KEY
    const val LIMIT_LICENSE_VALUE: Boolean = true
    const val TAGS_VALUE: String = "dessert"
    const val NUMBER_VALUE: Int = 1
    const val NOTIFICATION_ID = "ReceitasFavoritas_notification_id"
    const val NOTIFICATION_NAME = "ReceitasFavoritas"
    const val NOTIFICATION_CHANNEL = "ReceitasFavoritas_channel_01"

    fun dishTypes(): ArrayList<String> {
        val list = ArrayList<String>()
        list.add("Café da manhã")
        list.add("Almoço")
        list.add("Lanche")
        list.add("Janta")
        list.add("Salada")
        list.add("Acompanhamento")
        list.add("Sobremesa")
        list.add("Outro")

        return list
    }

    fun dishCategories(): ArrayList<String> {
        val list = ArrayList<String>()
        list.add("Pizza")
        list.add("Churrasco")
        list.add("Pães")
        list.add("Hambúrguer")
        list.add("Café")
        list.add("Galinha")
        list.add("Sobremesa")
        list.add("Drinks")
        list.add("Cachorro-quente")
        list.add("Sucos")
        list.add("Sanduíche")
        list.add("Chá e café")
        list.add("Wraps")
        list.add("Outro")

        return list
    }

    fun dishCookTime(): ArrayList<String> {
        val list = ArrayList<String>()
        list.add("10")
        list.add("15")
        list.add("20")
        list.add("30")
        list.add("45")
        list.add("50")
        list.add("60")
        list.add("90")
        list.add("120")
        list.add("150")
        list.add("180")

        return list
    }
}