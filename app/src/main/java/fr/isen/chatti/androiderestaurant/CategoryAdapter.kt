package fr.isen.chatti.androiderestaurant

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CategoryAdapter(private var itemsList :List<Items>, val onItemClickListener: (TitleDishes: Items)-> Unit ) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> () {
    class CategoryViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val dishName: TextView = itemView.findViewById(R.id.DishNameList)
        val price: TextView = itemView.findViewById(R.id.DishPriceList)
        val images: ImageView = itemView.findViewById(R.id.Imagelist)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val dish = itemsList[position]
        holder.dishName.text = dish.nameFr

        holder.itemView.setOnClickListener {
            onItemClickListener(dish)
        }

        holder.price.text = dish.prices[0].price + "€"

        val foodImage = dish.images[0]
        if (foodImage.isNotEmpty()) {
            Picasso.get().load(foodImage).resize(150, 150).into(holder.images)
        }
    }

    override fun getItemCount(): Int {
        Log.w("category", itemsList.size.toString())
        return itemsList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun refreshList(dishesFromAPI: ArrayList<Items>) {
        itemsList = dishesFromAPI
        notifyDataSetChanged()
    }
}