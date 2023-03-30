package fr.isen.chatti.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DishAdapter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dish_image)
    }
}