package br.com.fiap.arremate.ui.domain.entity

data class ListHelp (

    val id: Number,
    val texto: String

){
    override fun toString(): String {
        return this.texto
    }
}