package br.com.fiap.arremate.ui.domain.entity

import com.google.gson.annotations.SerializedName

data class Comprador(
        @SerializedName("id")
        val id: String,

        @SerializedName("nome")
        val nome: String,

        @SerializedName("sobrenome")
        val sobrenome: String,

        @SerializedName("cpf")
        val cpf: String,

        @SerializedName("contato")
        val contato: Contato,

        @SerializedName("usuario")
        val usuario: Usuario,

        @SerializedName("endereco")
        val endereco: Endereco
)