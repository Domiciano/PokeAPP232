package icesi.edu.co.pokeapp.model.repository

import icesi.edu.co.pokeapp.model.dto.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexRepository {
    @GET("pokemon/{id}")
    fun getPokemon(@Path("id") id:String) : Call<Pokemon>
}