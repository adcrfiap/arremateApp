package br.com.fiap.arremate.ui.domain.entity

import com.google.gson.annotations.SerializedName

data class ListIntencao (

    @SerializedName("value")
    val intencoes: List<Intencao>

)
