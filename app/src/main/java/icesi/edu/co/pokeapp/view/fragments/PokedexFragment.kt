package icesi.edu.co.pokeapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import icesi.edu.co.pokeapp.databinding.FragmentPokedexBinding
import icesi.edu.co.pokeapp.viewmodel.PodedexViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [PokedexFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PokedexFragment : Fragment() {

    val viewmodel: PodedexViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPokedexBinding.inflate(inflater, container, false)

        viewmodel.pokemon.observe(this){
            binding.pokemonName.text = it.name
            Glide.with(this)
                .load(it.sprites.other.officialArtwork.front_default)
                .into(binding.PokemonImage)
        }

        binding.searchButton.setOnClickListener {
            viewmodel.searchPokemon(
                binding.pokemonInput.editText?.text.toString()
            )
        }
        binding.catchBtn.setOnClickListener {
            viewmodel.catchPokemon()
        }

        return binding.root

    }

    companion object {
        @JvmStatic
        fun newInstance() = PokedexFragment()
    }
}