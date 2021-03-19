package br.com.fiap.arremate.ui.presentation.adicionarDisputas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.fiap.arremate.ui.domain.usecases.AdicionarIntencaoUseCase

class AdicionarDisputasViewModelFactory(
    private  val  adicionarIntencaoUseCase : AdicionarIntencaoUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            AdicionarIntencaoUseCase::class.java
        ).newInstance(adicionarIntencaoUseCase)
    }
}