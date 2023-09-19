package icesi.edu.co.pokeapp.model.dto

import icesi.edu.co.pokeapp.model.entity.PokemonEntity

data class User(
    val id:String,
    val name:String,
    val pokemon: HashMap<Int, PokemonEntity>
)