package br.com.fiap.arremate.ui.domain.entity

import com.google.gson.annotations.SerializedName

data class Contato(
        @SerializedName("id")
        val id: String,

        @SerializedName("celular")
        val celular: String,

        @SerializedName("email")
        val email: String,

        @SerializedName("telefone")
        val telefone: String
)
