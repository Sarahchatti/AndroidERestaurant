package fr.isen.chatti.androiderestaurant

import com.google.gson.annotations.SerializedName

data class Data(

    @SerializedName("id_category") var idCategory: String? = null,
    @SerializedName("name_fr") var nameFr: String? = null,
    @SerializedName("name_en") var nameEn: String? = null,
    @SerializedName("items") var items: ArrayList<Items> = arrayListOf()

):java.io.Serializable

data class Ingredients(

    @SerializedName("id") var id: String? = null,
    @SerializedName("id_shop") var idShop: String? = null,
    @SerializedName("name_fr") var nameFr: String? = null,
    @SerializedName("name_en") var nameEn: String? = null,
    @SerializedName("create_date") var createDate: String? = null,
    @SerializedName("update_date") var updateDate: String? = null,
    @SerializedName("id_pizza") var idPizza: String? = null

):java.io.Serializable

data class Items(

    @SerializedName("id") var id: String? = null,
    @SerializedName("name_fr") var nameFr: String? = null,
    @SerializedName("name_en") var nameEn: String? = null,
    @SerializedName("id_category") var idCategory: String? = null,
    @SerializedName("categ_name_fr") var categNameFr: String? = null,
    @SerializedName("categ_name_en") var categNameEn: String? = null,
    @SerializedName("images") var images: ArrayList<String> = arrayListOf(),
    @SerializedName("ingredients") var ingredients: ArrayList<Ingredients> = arrayListOf(),
    @SerializedName("prices") var prices: ArrayList<Prices> = arrayListOf()

):java.io.Serializable

data class ListMenu(

    @SerializedName("data") var data: ArrayList<Data> = arrayListOf()

):java.io.Serializable

data class Prices(

    @SerializedName("id") var id: String? = null,
    @SerializedName("id_pizza") var idPizza: String? = null,
    @SerializedName("id_size") var idSize: String? = null,
    @SerializedName("price") var price: String? = null,
    @SerializedName("create_date") var createDate: String? = null,
    @SerializedName("update_date") var updateDate: String? = null,
    @SerializedName("size") var size: String? = null

):java.io.Serializable