package br.com.fiap.arremate.ui.domain.usecases

import br.com.fiap.arremate.ui.domain.entity.Intencao
import br.com.fiap.arremate.ui.domain.entity.NewIntencao
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.repository.IntencaoRepository


class AdicionarIntencaoUseCase(
    private  val intencaoRepository: IntencaoRepository
){

    suspend fun create(newIntencao: NewIntencao): RequestState<NewIntencao> = intencaoRepository.create(newIntencao)

}