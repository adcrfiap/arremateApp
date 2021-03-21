package br.com.fiap.arremate.ui.domain.entity

import com.google.gson.annotations.SerializedName

data class Intencao(
        @SerializedName("idIntensao")
        val idIntensao: Number,

        @SerializedName("idProduto")
        val idProduto: String,

        @SerializedName("descricao")
        val descricao: String,

        @SerializedName("valorEstimado")
        val valorMinimo: String,

        @SerializedName("idComprador")
        val idComprador: String,

        @SerializedName("data")
        val data: String
)
{
    constructor(): this(0,"","","","","")
}