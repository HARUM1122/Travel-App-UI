package com.example.travelappui.models

data class PlaceModel(
    val name: String,
    val image: String,
    val city: String,
    val country: String,
    val ratings: String,
)

val mostViewedPlaces: List<PlaceModel> = listOf(
    PlaceModel(
        name = "Andes Mountain",
        image = "https://media.istockphoto.com/id/871808378/photo/aconcagua.jpg?s=612x612&w=0&k=20&c=846rN4ib0iWVukP7EZfTeUqtd-01noGecRDSjjVOEow=",
        city = "South",
        country = "America",
        ratings = "4.8",
    ),
    PlaceModel(
        name = "Mount Fuji",
        image = "https://t4.ftcdn.net/jpg/12/79/62/43/360_F_1279624332_Qggv2KHggJV6C9t9h7CNCRPmCklBVfIK.jpg",
        city = "Tokyo",
        country = "Japan",
        ratings = "4.5",
    )
)