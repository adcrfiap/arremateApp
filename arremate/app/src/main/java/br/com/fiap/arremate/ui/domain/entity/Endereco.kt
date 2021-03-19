package br.com.fiap.arremate.ui.domain.entity

import com.google.gson.annotations.SerializedName

data class Endereco (
        @SerializedName("id")
        val id: String,

        @SerializedName("bairro")
        val bairro: String,

        @SerializedName("cep")
        val cep: String,

        @SerializedName("cidade")
        val cidade: String,

        @SerializedName("complemento")
        val complemento: String,

        @SerializedName("estado")
        val estado: String,

        @SerializedName("logradouro")
        val logradouro: String,

        @SerializedName("numero")
        val numero: String
)