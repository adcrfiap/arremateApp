package br.com.fiap.arremate.ui.presentation.adicionarDisputas

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.arremate.ui.domain.entity.NewIntencao
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.usecases.AdicionarIntencaoUseCase
import kotlinx.coroutines.launch


class AdicionarDisputasViewModel (
    private  val adicionarIntencaoUseCase: AdicionarIntencaoUseCase
): ViewModel() {

    val adicionarIntencaoState = MutableLiveData<RequestState<NewIntencao>>()

    fun create(newIntencao: NewIntencao ){
        viewModelScope.launch {
            adicionarIntencaoState.value = adicionarIntencaoUseCase
                .create(newIntencao)
        }
    }
}