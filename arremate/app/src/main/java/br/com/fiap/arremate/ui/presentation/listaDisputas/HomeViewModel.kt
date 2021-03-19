package br.com.fiap.arremate.ui.presentation.listaDisputas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.arremate.ui.domain.entity.Intencao
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.usecases.ListIntencaoUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
        private  val listIntencaoUseCase: ListIntencaoUseCase
) : ViewModel() {

    val ListIntencaoState = MutableLiveData<RequestState<MutableList<Intencao>>>()

    fun listIntencao(){
        viewModelScope.launch {
            ListIntencaoState.value = listIntencaoUseCase.listIntencao()
        }
    }
}