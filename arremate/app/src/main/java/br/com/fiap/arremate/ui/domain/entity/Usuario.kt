package br.com.fiap.arremate.ui.domain.entity

import com.google.gson.annotations.SerializedName

data class Usuario (
        @SerializedName("id")
        val id: String,

        @SerializedName("email")
        val email: String,

        @SerializedName("senha")
        val senha: String,

        @SerializedName("usuario")
        val usuario: String
)