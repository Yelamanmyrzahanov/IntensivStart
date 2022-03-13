package ru.androidschool.intensiv.ui.movie_details

import ru.androidschool.intensiv.data.Movie

data class MovieDetails(
    val movie: Movie,
    val description: String,
    val studio: String,
    val genre: String,
    val year: String
)