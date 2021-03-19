package br.com.fiap.arremate.ui.domain.entity

import com.google.gson.annotations.SerializedName

data class Intencao(
        @SerializedName("ProductID")
        val id: Number,

        @SerializedName("ProductName")
        val produto: String,

        @SerializedName("CategoryID")
        val categoria: String,

        @SerializedName("QuantityPerUnit")
        val marca: String,

        @SerializedName("UnitPrice")
        val modelo: String
)
{
    constructor(): this(0,"","","","")
}