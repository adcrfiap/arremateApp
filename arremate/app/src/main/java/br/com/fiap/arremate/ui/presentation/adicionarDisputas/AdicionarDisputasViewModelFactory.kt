package br.com.fiap.arremate.ui.presentation.adicionarDisputas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.fiap.arremate.ui.domain.usecases.AdicionarIntencaoUseCase
import br.com.fiap.arremate.ui.domain.usecases.ListCategoriasUseCase
import br.com.fiap.arremate.ui.domain.usecases.ListMarcasUseCase
import br.com.fiap.arremate.ui.domain.usecases.ListProdutosUseCase

class AdicionarDisputasViewModelFactory(
    private  val  adicionarIntencaoUseCase : AdicionarIntencaoUseCase,
    private  val  listCategoriasUseCase: ListCategoriasUseCase,
    private  val  listMarcasUseCase: ListMarcasUseCase,
    private  val  listProdutosUseCase: ListProdutosUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            AdicionarIntencaoUseCase::class.java,
            ListCategoriasUseCase::class.java,
                ListMarcasUseCase::class.java,
                ListProdutosUseCase::class.java
        ).newInstance(adicionarIntencaoUseCase, listCategoriasUseCase, listMarcasUseCase, listProdutosUseCase)
    }
}