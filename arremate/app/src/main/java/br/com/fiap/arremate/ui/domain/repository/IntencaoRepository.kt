package br.com.fiap.arremate.ui.domain.repository

import br.com.fiap.arremate.ui.domain.entity.Intencao
import br.com.fiap.arremate.ui.domain.entity.NewIntencao
import br.com.fiap.arremate.ui.domain.entity.RequestState

interface IntencaoRepository {
    suspend fun listIntencao(): RequestState<MutableList<Intencao>>
    suspend fun create(newIntencao: NewIntencao): RequestState<NewIntencao>
    suspend fun delete(id: String): RequestState<String>
}