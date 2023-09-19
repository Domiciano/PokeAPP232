package icesi.edu.co.pokeapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import icesi.edu.co.pokeapp.R
import icesi.edu.co.pokeapp.databinding.FragmentProfileBinding
import icesi.edu.co.pokeapp.view.adapters.PokemonAdapter
import icesi.edu.co.pokeapp.viewmodel.PodedexViewModel
import icesi.edu.co.pokeapp.viewmodel.PokemonListViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {

    val viewmodel: PokemonListViewModel by activityViewModels()
    val adapter = PokemonAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.pokemonList.adapter = adapter
        binding.pokemonList.layoutManager = LinearLayoutManager(requireContext())
        binding.pokemonList.setHasFixedSize(true)

        viewmodel.downloadUser()

        viewmodel.pokemonListLiveData.observe(this) { pokemonList ->
            adapter.addPokemonList(pokemonList)
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}