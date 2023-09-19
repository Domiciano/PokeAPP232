package icesi.edu.co.pokeapp.model.repository

import icesi.edu.co.pokeapp.model.dto.User
import icesi.edu.co.pokeapp.model.entity.PokemonEntity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface FirebaseRepository {

    //PUT del Pokemon
    @PUT("users/IDW/pokemon/{id}.json")
    fun putPokemon(@Path("id") id:String, @Body pokemon: PokemonEntity):Call<Any>



    //GET de la lista de los pokemon
    @GET("users/{id}.json")
    fun getUser(@Path("id") id: String): Call<User>
}