package ru.androidschool.intensiv.data

import ru.androidschool.intensiv.ui.movie_details.MovieDetails

object MockRepository {

    fun getMovies(): List<Movie> {

        val moviesList = mutableListOf<Movie>()
        for (x in 0..10) {
            val movie = Movie(
                title = "Spider-Man $x",
                voteAverage = 10.0 - x
            )
            moviesList.add(movie)
        }

        return moviesList
    }

    fun getMovieDetails() = MovieDetails(
        Movie(
            title = "Aquaman",
            voteAverage = 0.8
        ),
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non blandit neque. Cras sit amet risus tempus, interdum turpis non, ultrices sem. Phasellus tincidunt tellus in nisi volutpat, ac ultricies justo pretium. Morbi vulputate dui sit amet sagittis pellentesque. Sed id tellus felis. Curabitur turpis enim, dignissim imperdiet ante tempor, faucibus blandit ante. Vestibulum dapibus vestibulum dui. Aenean velit dolor, tristique nec sagittis non, dictum sed nibh. Cras facilisis mattis lacus vel mollis.",
        studio = "Warner Bros",
        genre = "Action, Adventure",
        year = "2018"
    )
}
