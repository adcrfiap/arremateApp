package br.com.fiap.arremate.ui.domain.entity

import com.google.gson.annotations.SerializedName

data class NewIntencao(

        @SerializedName("data")
        val data: String,

        @SerializedName("descricao")
        val descricao: String,

        @SerializedName("idComprador")
        val idComprador: Number,

        @SerializedName("idIntensao")
        val idIntensao: Number,

        @SerializedName("idProduto")
        val idProduto: Number,

        @SerializedName("valorEstimado")
        val valorEstimado: Number

)
{
    constructor(): this("","",0, 0, 0, 0)
}