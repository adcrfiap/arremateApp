package br.com.fiap.arremate.ui.domain.repository

import br.com.fiap.arremate.ui.domain.entity.Categoria
import br.com.fiap.arremate.ui.domain.entity.Marca
import br.com.fiap.arremate.ui.domain.entity.Produto
import br.com.fiap.arremate.ui.domain.entity.RequestState

interface MasterdataRepository {
    suspend fun getCategorias(): RequestState<MutableList<Categoria>>
    suspend fun getMarcas(): RequestState<MutableList<Marca>>
    suspend fun getProdutos(): RequestState<MutableList<Produto>>
}