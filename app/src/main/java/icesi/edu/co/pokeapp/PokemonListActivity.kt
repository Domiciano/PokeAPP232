package icesi.edu.co.pokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import icesi.edu.co.pokeapp.databinding.ActivityPokemonListBinding
import icesi.edu.co.pokeapp.viewmodel.PokemonListViewModel

class PokemonListActivity : AppCompatActivity() {

    val viewmodel:PokemonListViewModel by viewModels()
    val binding by lazy {
        ActivityPokemonListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewmodel.downloadUser()
    }
}