package fr.isen.chatti.androiderestaurant

import android.app.Notification.Action
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Toast
import fr.isen.chatti.androiderestaurant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.entrees.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("category", binding.entrees.text)
            startActivity(intent)
        }

        binding.Plats.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("category", "plats")
            startActivity(intent)
        }

        binding.Dessert.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("category", "desserts")
            startActivity(intent)
        }
    }
}



