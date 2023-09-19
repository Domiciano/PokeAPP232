package icesi.edu.co.pokeapp.model.dto

import com.google.gson.annotations.SerializedName

data class Pokemon(
    var id:Int,
    var name:String,
    var sprites:Sprites,
    var stats:ArrayList<StatWrapper>
)

data class Sprites(
    var front_default:String,
    var other:SpriteContainer
)
data class SpriteContainer(
    @SerializedName("official-artwork")
    var officialArtwork: Sprite
)

data class Sprite(
    var front_default: String
)

data class StatWrapper(
    var base_stat:Int,
    var effort:Int,
    var stat:Stat
)

data class Stat(
    var name:String,
    var url:String
)