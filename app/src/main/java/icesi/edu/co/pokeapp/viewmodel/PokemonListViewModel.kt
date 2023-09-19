package icesi.edu.co.pokeapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import icesi.edu.co.pokeapp.model.entity.PokemonEntity
import icesi.edu.co.pokeapp.model.services.RetrofitServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonListViewModel:ViewModel() {

    val pokemonList = ArrayList<PokemonEntity>()
    val pokemonListLiveData = MutableLiveData<ArrayList<PokemonEntity>>()

    fun downloadUser(){
        pokemonList.clear()
        viewModelScope.launch(Dispatchers.IO){
            val response = RetrofitServices.firebaseRepository
                .getUser("IDW").execute()
            response.body()?.let {
                it.pokemon.values.forEach {
                    pokemonList.add(it)
                }
                withContext(Dispatchers.Main){
                    pokemonListLiveData.value = pokemonList
                }
            }
        }
    }

}