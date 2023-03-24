package fr.isen.chatti.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale.Category

class CategoryActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val category =
            intent.getStringExtra("CATEGORY_NAME")
        supportActionBar?.title = category

        recyclerView = findViewById(R.id.RecyclerCategory)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val menuItems = when (category) {
            "Entrees" -> resources.getStringArray(R.array.Entrees).toList()
            "Plats" -> resources.getStringArray(R.array.Plats).toList()
            "Desserts" -> resources.getStringArray(R.array.Desserts).toList()
            else -> emptyList<String>()
        }

        categoryAdapter = CategoryAdapter(menuItems)
        recyclerView.adapter = categoryAdapter
    }
}