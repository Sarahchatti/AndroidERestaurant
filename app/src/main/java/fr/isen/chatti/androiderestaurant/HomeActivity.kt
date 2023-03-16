package fr.isen.chatti.androiderestaurant

import android.app.Notification.Action
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import fr.isen.chatti.androiderestaurant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Plats.setOnClickListener {
            //Log.d("MainActivity", "Vous avez cliqué sur le bouton plat")
            Toast.makeText(this, "vous avez cliqué sur le bouton plat !", Toast.LENGTH_LONG).show()
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("category", getString(R.string.btn_Plats))
            startActivity(intent)

        }


        }

    }




