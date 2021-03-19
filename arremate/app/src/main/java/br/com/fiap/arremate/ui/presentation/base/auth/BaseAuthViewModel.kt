package br.com.fiap.mobileproject.presentation.base.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.arremate.ui.domain.entity.Comprador
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.usecases.GetUserLoggedUseCase
import kotlinx.coroutines.launch

class BaseAuthViewModel (
        private val getUserLoggedUseCase: GetUserLoggedUseCase
) : ViewModel() {

    var userLoggedState = MutableLiveData<RequestState<Comprador>>()

    fun getUserLogged(){
        viewModelScope.launch {
            userLoggedState.value = getUserLoggedUseCase.getUserLogged()
        }
    }

}