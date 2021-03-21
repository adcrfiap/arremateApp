package br.com.fiap.arremate.ui.domain.usecases

import br.com.fiap.arremate.ui.domain.entity.Categoria
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.repository.MasterdataRepository

class ListCategoriasUseCase (
        private val masterdataRepository: MasterdataRepository
){
    suspend fun getCategorias(): RequestState<MutableList<Categoria>> = masterdataRepository.getCategorias()
}