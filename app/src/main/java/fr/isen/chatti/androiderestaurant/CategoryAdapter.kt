package fr.isen.chatti.androiderestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter (private val itemsList : List<String>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder> (){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewItem : TextView = itemView.findViewById(R.id.Titreliste)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemsList[position])
        //holder.textViewItem.text = itemsList[position]
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}