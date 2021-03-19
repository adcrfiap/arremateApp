package br.com.fiap.arremate.ui.presentation.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.fiap.arremate.ui.domain.usecases.CreateUserUseCase

class SignupViewModelFactory(
    private val createUserUseCase: CreateUserUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(CreateUserUseCase::class.java).newInstance(createUserUseCase)
    }
}