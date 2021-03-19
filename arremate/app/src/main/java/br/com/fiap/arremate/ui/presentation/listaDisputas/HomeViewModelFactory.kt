package br.com.fiap.arremate.ui.presentation.listaDisputas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.fiap.arremate.ui.domain.usecases.ListIntencaoUseCase

class HomeViewModelFactory(
        private val listIntencaoUseCase: ListIntencaoUseCase
):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
                ListIntencaoUseCase::class.java
        ).newInstance(listIntencaoUseCase)
    }

}