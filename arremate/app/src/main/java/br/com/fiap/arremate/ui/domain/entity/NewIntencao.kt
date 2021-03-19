package br.com.fiap.arremate.ui.domain.entity

import com.google.gson.annotations.SerializedName

data class NewIntencao(

    val idProduto: Number,

    val idCliente: Number,

    val valorMinimo: Number,

    val valorMaximo: Number,

    val descricao: String

)
{
    constructor(): this(0,0,0, 0, "")
}