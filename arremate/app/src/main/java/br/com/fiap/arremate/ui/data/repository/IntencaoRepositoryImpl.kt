package br.com.fiap.arremate.ui.data.repository

import br.com.fiap.arremate.ui.data.remote.datasource.IntencaoRemoteDataSource
import br.com.fiap.arremate.ui.domain.entity.Intencao
import br.com.fiap.arremate.ui.domain.entity.NewIntencao
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.repository.IntencaoRepository

class IntencaoRepositoryImpl(
        val intencaoRemoteDataSource: IntencaoRemoteDataSource
): IntencaoRepository {
    override suspend fun listIntencao(): RequestState<MutableList<Intencao>> {
        return intencaoRemoteDataSource.listIntencao()
    }

    override suspend fun create(newIntencao: NewIntencao): RequestState<NewIntencao> {
        return intencaoRemoteDataSource.create(newIntencao)
    }
}