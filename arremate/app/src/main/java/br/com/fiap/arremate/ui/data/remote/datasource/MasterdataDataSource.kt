package br.com.fiap.arremate.ui.data.remote.datasource

import br.com.fiap.arremate.ui.domain.entity.Categoria
import br.com.fiap.arremate.ui.domain.entity.Marca
import br.com.fiap.arremate.ui.domain.entity.Produto
import br.com.fiap.arremate.ui.domain.entity.RequestState

interface MasterdataDataSource {

    suspend fun getCategorias(): RequestState<MutableList<Categoria>>
    suspend fun getMarcas(): RequestState<MutableList<Marca>>
    suspend fun getProdutos(): RequestState<MutableList<Produto>>
}