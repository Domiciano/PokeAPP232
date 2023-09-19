package icesi.edu.co.pokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import icesi.edu.co.pokeapp.databinding.ActivityMainBinding
import icesi.edu.co.pokeapp.model.dto.Pokemon
import icesi.edu.co.pokeapp.model.services.RetrofitServices
import icesi.edu.co.pokeapp.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewmodel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        viewmodel.pokemon.observe(this){
            binding.pokemonName.text = it.name
            Glide.with(this@MainActivity)
                .load(it.sprites.front_default)
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
    }
}