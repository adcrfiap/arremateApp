package br.com.fiap.arremate.ui.domain.usecases

import androidx.lifecycle.MutableLiveData
import br.com.fiap.arremate.ui.domain.entity.Intencao
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.repository.IntencaoRepository

class ListIntencaoUseCase(
        private  val intencaoRepository: IntencaoRepository
) {

    suspend fun listIntencao(): RequestState<MutableList<Intencao>> = intencaoRepository.listIntencao()
}