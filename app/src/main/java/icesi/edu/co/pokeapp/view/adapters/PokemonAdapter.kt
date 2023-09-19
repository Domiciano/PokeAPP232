package icesi.edu.co.pokeapp.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import icesi.edu.co.pokeapp.R
import icesi.edu.co.pokeapp.databinding.PokemonrowBinding
import icesi.edu.co.pokeapp.model.entity.PokemonEntity

class PokemonAdapter: Adapter<PokemonVH>() {

    private val caughtPokemon = ArrayList<PokemonEntity>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemonrow, parent, false)
        return PokemonVH(view)
    }

    override fun getItemCount(): Int = caughtPokemon.size


    override fun onBindViewHolder(holder: PokemonVH, position: Int) {
        holder.pokemonName.text = caughtPokemon[position].name
        Glide.with(holder.pokemonImage).load(caughtPokemon[position].url).into(holder.pokemonImage)
    }

    fun addPokemon(pokemon:PokemonEntity){
        caughtPokemon.add(pokemon)
        notifyDataSetChanged()
    }

    fun addPokemonList(pokemonList: ArrayList<PokemonEntity>) {
        caughtPokemon.clear()
        caughtPokemon.addAll(pokemonList)
        notifyDataSetChanged()
    }

}

class PokemonVH(item: View):ViewHolder(item){
    private val binding = PokemonrowBinding.bind(item)
    val pokemonName = binding.pokemonRowName
    val pokemonImage = binding.pokemonRowImage
}