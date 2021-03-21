package br.com.fiap.arremate.ui.data.remote.datasource

import br.com.fiap.arremate.ui.domain.entity.Comprador
import br.com.fiap.arremate.ui.domain.entity.ListCategorias
import br.com.fiap.arremate.ui.domain.entity.RequestState

interface MasterdataDataSourcer {

    suspend fun getCategorias(): RequestState<ListCategorias>
}