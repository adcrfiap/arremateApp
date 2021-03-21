package br.com.fiap.arremate.ui.domain.usecases

import br.com.fiap.arremate.ui.domain.entity.Marca
import br.com.fiap.arremate.ui.domain.entity.Produto
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.repository.MasterdataRepository

class ListProdutosUseCase (
        private val masterdataRepository: MasterdataRepository
){
    suspend fun getProdutos(): RequestState<MutableList<Produto>> = masterdataRepository.getProdutos()
}