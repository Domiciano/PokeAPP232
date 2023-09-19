package icesi.edu.co.pokeapp.model.services

import icesi.edu.co.pokeapp.model.repository.FirebaseRepository
import icesi.edu.co.pokeapp.model.repository.PokedexRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServices {

    var pokedexService = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var firebaseService = Retrofit.Builder()
        .baseUrl("https://facelogprueba.firebaseio.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var pokedexRepository = pokedexService
        .create(PokedexRepository::class.java)

    var firebaseRepository = firebaseService
        .create(FirebaseRepository::class.java)


}