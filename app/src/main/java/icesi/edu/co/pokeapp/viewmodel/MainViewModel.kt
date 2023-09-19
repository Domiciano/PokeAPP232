package icesi.edu.co.pokeapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import icesi.edu.co.pokeapp.model.dto.Pokemon
import icesi.edu.co.pokeapp.model.entity.PokemonEntity
import icesi.edu.co.pokeapp.model.services.RetrofitServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel :ViewModel() {

    //State: las variables que se muestran al USER
    private val _pokemon = MutableLiveData<Pokemon>()
    val pokemon:LiveData<Pokemon> get() = _pokemon
    //Esta variable es observable
    //Observer: Vista
    //Observable: _pokemon


    //Eventos: recibe los eventos de la vista
    fun searchPokemon(searchTerm:String){
        viewModelScope.launch(Dispatchers.IO){
            var call = RetrofitServices.pokedexRepository.getPokemon(
                searchTerm
            )
            var response = call.execute()
            var pokemon = response.body()
            //Actualizar el estado
            pokemon?.let {
                withContext(Dispatchers.Main){
                   _pokemon.value = it
                }
            }

        }
    }

    fun catchPokemon(){
        viewModelScope.launch(Dispatchers.IO){
            _pokemon.value?.let {
                var pokemonEntity = PokemonEntity(
                    "${it.id}",
                    it.name,
                    it.sprites.front_default,
                    it.stats[2].base_stat,
                    it.stats[1].base_stat
                )
                val response = RetrofitServices.firebaseRepository.putPokemon(
                    "${_pokemon.value?.id}",
                    pokemonEntity
                ).execute()
            }

        }
    }



}