package ru.androidschool.intensiv.ui.movie_details

import android.view.View
import com.squareup.picasso.Picasso
import com.xwray.groupie.viewbinding.BindableItem
import ru.androidschool.intensiv.R
import ru.androidschool.intensiv.data.Movie
import ru.androidschool.intensiv.databinding.ItemMovieActorsBinding
import ru.androidschool.intensiv.ui.extensions.loadImage

class MovieActorsItem(
    private val content: Movie
) : BindableItem<ItemMovieActorsBinding>() {
    override fun bind(view: ItemMovieActorsBinding, position: Int) = with(view){
        tvActorName.text = content.title
        ivActor.loadImage("https://m.media-amazon.com/images/M/MV5BYTk3MDljOWQtNGI2My00OTEzLTlhYjQtOTQ4ODM2MzUwY2IwXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_.jpg")
    }

    override fun getLayout(): Int = R.layout.item_movie_actors

    override fun initializeViewBinding(view: View) = ItemMovieActorsBinding.bind(view)
}