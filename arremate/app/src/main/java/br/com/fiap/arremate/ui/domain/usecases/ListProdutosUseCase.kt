package br.com.fiap.arremate.ui.domain.usecases

import br.com.fiap.arremate.ui.domain.entity.Marca
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.repository.MasterdataRepository

class ListMarcasUseCase (
        private val masterdataRepository: MasterdataRepository
){
    suspend fun getMarcas(): RequestState<MutableList<Marca>> = masterdataRepository.getMarcas()
}