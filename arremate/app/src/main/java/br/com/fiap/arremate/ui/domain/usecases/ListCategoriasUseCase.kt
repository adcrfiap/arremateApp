package br.com.fiap.arremate.ui.domain.usecases

import br.com.fiap.arremate.ui.domain.entity.ListCategorias
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.repository.MasterdataRepository

class ListCategorias (
        private val masterdataRepository: MasterdataRepository
){
    suspend fun getCategorias(): RequestState<MutableList<ListCategorias>> = masterdataRepository.getCategorias()
}