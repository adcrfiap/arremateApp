package br.com.fiap.arremate.ui.presentation.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.arremate.ui.domain.entity.Comprador
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.usecases.CreateUserUseCase
import kotlinx.coroutines.launch

class SignupViewModel (
    private val createUserUseCase : CreateUserUseCase
) : ViewModel() {
    val newUserState = MutableLiveData<RequestState<Comprador>>()
    fun create(comprador: Comprador) {
        viewModelScope.launch {
            newUserState .value = createUserUseCase .create(comprador)
        }
    }
}