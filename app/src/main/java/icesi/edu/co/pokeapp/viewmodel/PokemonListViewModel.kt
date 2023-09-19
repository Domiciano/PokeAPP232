package icesi.edu.co.pokeapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import icesi.edu.co.pokeapp.model.services.RetrofitServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonListViewModel:ViewModel() {

    fun downloadUser(){
        viewModelScope.launch(Dispatchers.IO){
            val response = RetrofitServices.firebaseRepository
                .getUser("IDW").execute()
            response.body()?.let {
                Log.e(">>", it.name)
                for((key, value) in it.pokemon){

                }
                it.pokemon.values.forEach {
                    Log.e(">>>", it.name)
                }
            }
        }
    }

}