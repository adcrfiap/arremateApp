package br.com.fiap.arremate.ui.presentation.disputas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.fiap.arremate.ui.domain.usecases.SignOutUseCase

class DisputasViewModelFactory(
    private  val signOutUseCase: SignOutUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            SignOutUseCase::class.java
        ).newInstance(signOutUseCase)
    }
}