package fr.isen.chatti.androiderestaurant

import android.app.Notification.Action
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import fr.isen.chatti.androiderestaurant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home)

        val entreesButton = findViewById<Button>(R.id.entrees)
        entreesButton.setOnClickListener{
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("CATEGORY_NAME","Entrees")
            startActivity(intent)
        }

        val platsButton = findViewById<Button>(R.id.Plats)
        platsButton.setOnClickListener{
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("CATEGORY_NAME","Plats")
            startActivity(intent)
        }

        val dessertButton = findViewById<Button>(R.id.Dessert)
        dessertButton.setOnClickListener{
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("CATEGORY_NAME","Dessert")
            startActivity(intent)
        }

       fun openCategoryActivity(category:String) {
           val intent = Intent(this, CategoryActivity::class.java)
           intent.putExtra("category", category)
           startActivity(intent)
       }

        fun onDestroy(){
            super.onDestroy()
            Log.d("MyActivity", "Home Activity destroyed")
        }
       /* binding.Plats.setOnClickListener {
            //Log.d("MainActivity", "Vous avez cliqué sur le bouton plat")
            Toast.makeText(this, "vous avez cliqué sur le bouton plat !", Toast.LENGTH_LONG).show()
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("category", getString(R.string.btn_Plats))
            startActivity(intent)

        }
*/


        }

    }




