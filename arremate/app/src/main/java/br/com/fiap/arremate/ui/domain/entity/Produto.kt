package br.com.fiap.arremate.ui.domain.entity

import com.google.gson.annotations.SerializedName

class Produto (
        @SerializedName("id")
        val id: Number,

        @SerializedName("nome")
        val nome: String
)