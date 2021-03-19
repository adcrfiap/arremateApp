package br.com.fiap.arremate.ui.presentation.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.arremate.ui.domain.entity.Comprador
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.entity.UserLogin
import br.com.fiap.arremate.ui.domain.usecases.LoginUseCase
import br.com.fiap.arremate.ui.domain.usecases.ResetPasswordUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
        private  val loginUseCase: LoginUseCase,
        private  val resetPasswordUseCase: ResetPasswordUseCase
) : ViewModel() {

    val loginState = MutableLiveData<RequestState<Comprador>>()
    val resetPasswordState = MutableLiveData<RequestState<String>>()

    fun doLogin(email: String, senha: String){
        viewModelScope.launch {
            loginState.value = loginUseCase.doLogin(UserLogin(email, senha))
        }
    }

    fun resetPassword(email: String) {
        viewModelScope.launch {
            resetPasswordState.value =
                resetPasswordUseCase.resetPassword(email)
        }
    }

}