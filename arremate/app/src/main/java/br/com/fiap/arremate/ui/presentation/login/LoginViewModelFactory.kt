package br.com.fiap.arremate.ui.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.fiap.arremate.ui.domain.usecases.LoginUseCase
import br.com.fiap.arremate.ui.domain.usecases.ResetPasswordUseCase

class LoginViewModelFactory(
        private val loginUseCase: LoginUseCase,
        private val resetPasswordUseCase: ResetPasswordUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            LoginUseCase::class.java,
            ResetPasswordUseCase::class.java
        ).newInstance(loginUseCase, resetPasswordUseCase)
    }
}