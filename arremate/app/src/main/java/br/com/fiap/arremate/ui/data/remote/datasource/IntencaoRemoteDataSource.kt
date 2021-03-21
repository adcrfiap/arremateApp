package br.com.fiap.arremate.ui.data.remote.datasource

import br.com.fiap.arremate.ui.domain.entity.Intencao
import br.com.fiap.arremate.ui.domain.entity.NewIntencao
import br.com.fiap.arremate.ui.domain.entity.RequestState

interface IntencaoRemoteDataSource {
    suspend fun listIntencao(): RequestState<MutableList<Intencao>>
    suspend fun create(newIntencao: NewIntencao): RequestState<NewIntencao>
    suspend fun delete(id: String): RequestState<String>
}