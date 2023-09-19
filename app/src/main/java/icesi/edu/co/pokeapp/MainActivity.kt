package icesi.edu.co.pokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import icesi.edu.co.pokeapp.databinding.ActivityMainBinding
import icesi.edu.co.pokeapp.view.fragments.PokedexFragment
import icesi.edu.co.pokeapp.view.fragments.ProfileFragment
import icesi.edu.co.pokeapp.viewmodel.PodedexViewModel

class MainActivity : AppCompatActivity() {


    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val pokedexFragment = PokedexFragment()
    val profileFragment = ProfileFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadFragment(pokedexFragment)
        binding.bottomNavigationView.setOnItemSelectedListener {item ->
            when(item.itemId){
                R.id.pokedex->{
                    loadFragment(pokedexFragment)
                }
                R.id.profile->{
                    loadFragment(profileFragment)
                }
            }
            true
        }

    }

    private fun loadFragment(profileFragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, profileFragment).commit()
    }
}