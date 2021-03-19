package br.com.fiap.arremate.ui.presentation.disputas

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.usecases.SignOutUseCase
import kotlinx.coroutines.launch

class DisputasViewModel(
    private  val signOutUseCase: SignOutUseCase
) : ViewModel() {

    val signOutState = MutableLiveData<RequestState<String>>()

    fun doSignOut(){
        viewModelScope.launch {
            signOutState.value = signOutUseCase.signout()
        }
    }

}