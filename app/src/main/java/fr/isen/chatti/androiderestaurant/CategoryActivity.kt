package fr.isen.chatti.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call.Details
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.isen.chatti.androiderestaurant.databinding.ActivityCategoryBinding
import java.util.Locale.Category
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import org.json.JSONObject

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val category = binding.Titreliste
        val recyclerView = binding.RecyclerCategory
        category.text = intent.extras?.getString("category") ?: ""

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = CategoryAdapter(arrayListOf()) {
            val intent = Intent(this@CategoryActivity, DishDetailsActivity::class.java)
            intent.putExtra("item", it)
            startActivity(intent)
        }
        loadDishesFromAPI()
    }

        private fun loadDishesFromAPI() {
            Volley.newRequestQueue(this)

            val url = "http://test.api.catering.bluecodegames.com/menu"
            val jsonObject = JSONObject()
            jsonObject.put("id_shop", "1")
            val jsonRequest = JsonObjectRequest(Request.Method.POST, url, jsonObject, {
                Log.w("CategoryActivity", "response : $it")
                handleAPIData(it.toString())
            }, {
                Log.w("CategoryActivity", "erreur : $it")
                Toast.makeText(this@CategoryActivity, "Erreur API", Toast.LENGTH_SHORT).show()
            })
            Volley.newRequestQueue(this).add(jsonRequest)
        }

        private fun handleAPIData(data: String) {
            val dishesResult = Gson().fromJson(data,ListMenu::class.java)
            val dishes = dishesResult.data.firstOrNull {
                it.nameFr == (intent.extras?.getString("titleCategory") ?: "No title available")
            }

            val adapter = binding.RecyclerCategory.adapter as CategoryAdapter
            if (dishes != null) {
                adapter.refreshList(dishes.items)
            }
        }


}