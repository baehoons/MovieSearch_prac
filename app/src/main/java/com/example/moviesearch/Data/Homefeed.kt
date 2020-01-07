package com.example.moviesearch.Data

class Homefeed (val items : List<Item>)
data class Item(
    val title : String,
    val link : String,
    val image : String,
    val subtitle : String,
    val pubDate : String,
    val director : String,
    val actor : String,
    val usrRating : String
)