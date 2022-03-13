package ru.androidschool.intensiv.ui.movie_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import ru.androidschool.intensiv.R
import ru.androidschool.intensiv.data.MockRepository
import ru.androidschool.intensiv.databinding.MovieDetailsFragmentBinding
import ru.androidschool.intensiv.ui.extensions.loadImage

class MovieDetailsFragment : Fragment(R.layout.movie_details_fragment) {
    private val adapter by lazy {
        GroupAdapter<GroupieViewHolder>()
    }

    private var _binding: MovieDetailsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MovieDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val actorsList = MockRepository.getMovies().map {
            MovieActorsItem(it)
        }

        val details = MockRepository.getMovieDetails()

        with(binding) {
            btnBack.setOnClickListener {
                findNavController().navigateUp()
            }

            with(details) {
                tvMovieTitle.text = movie.title
                tvMovieDescription.text = description
                tvGenre.text = genre
                tvYear.text = year
                tvStudio.text = studio
                ivMovieRating.rating = movie.rating
            }

            movieImage.loadImage("https://m.media-amazon.com/images/M/MV5BYTk3MDljOWQtNGI2My00OTEzLTlhYjQtOTQ4ODM2MzUwY2IwXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_.jpg")
            rvActors.adapter = adapter
            adapter.apply { addAll(actorsList) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
