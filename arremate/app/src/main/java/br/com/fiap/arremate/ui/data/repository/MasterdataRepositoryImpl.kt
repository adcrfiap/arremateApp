package br.com.fiap.arremate.ui.data.repository

import br.com.fiap.arremate.ui.data.remote.datasource.MasterdataDataSource
import br.com.fiap.arremate.ui.domain.entity.Categoria
import br.com.fiap.arremate.ui.domain.entity.Marca
import br.com.fiap.arremate.ui.domain.entity.Produto
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.repository.MasterdataRepository

class MasterdataRepositoryImpl (
        val masterdataDataSource: MasterdataDataSource
): MasterdataRepository{
    override suspend fun getCategorias(): RequestState<MutableList<Categoria>> {
        return  masterdataDataSource.getCategorias()
    }

    override suspend fun getMarcas(): RequestState<MutableList<Marca>> {
        return  masterdataDataSource.getMarcas()
    }

    override suspend fun getProdutos(): RequestState<MutableList<Produto>> {
        return  masterdataDataSource.getProdutos()
    }
}