package ru.androidschool.intensiv.ui.tvshows

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import ru.androidschool.intensiv.R
import ru.androidschool.intensiv.data.Movie
import ru.androidschool.intensiv.databinding.ItemTvShowBinding
import ru.androidschool.intensiv.ui.extensions.loadImage

class TvShowItem(
    private val entity: Movie,
    private val onClick: (movie: Movie) -> Unit
) : BindableItem<ItemTvShowBinding>() {
    override fun getLayout() = R.layout.item_tv_show

    override fun bind(view: ItemTvShowBinding, position: Int) = with(view){
        view.tvShowName.text = entity.title
        view.ivShowRating.rating = entity.rating
        view.content.setOnClickListener {
            onClick.invoke(entity)
        }
        // TODO Получать из модели
        view.ivShow.loadImage("https://m.media-amazon.com/images/M/MV5BYTk3MDljOWQtNGI2My00OTEzLTlhYjQtOTQ4ODM2MzUwY2IwXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_.jpg")
    }

    override fun initializeViewBinding(v: View) = ItemTvShowBinding.bind(v)
}