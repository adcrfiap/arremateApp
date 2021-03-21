package br.com.fiap.arremate.ui.domain.usecases

import androidx.lifecycle.MutableLiveData
import br.com.fiap.arremate.ui.domain.entity.Intencao
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.repository.IntencaoRepository

class DeleteIntencaoUseCase(
        private  val intencaoRepository: IntencaoRepository
) {

    suspend fun deleteIntencao(id: String): RequestState<String> = intencaoRepository.delete(id)
}