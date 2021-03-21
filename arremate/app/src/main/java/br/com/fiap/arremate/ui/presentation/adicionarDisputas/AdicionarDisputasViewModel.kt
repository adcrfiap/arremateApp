package br.com.fiap.arremate.ui.presentation.adicionarDisputas

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.arremate.ui.domain.entity.*
import br.com.fiap.arremate.ui.domain.usecases.AdicionarIntencaoUseCase
import br.com.fiap.arremate.ui.domain.usecases.ListCategoriasUseCase
import br.com.fiap.arremate.ui.domain.usecases.ListMarcasUseCase
import br.com.fiap.arremate.ui.domain.usecases.ListProdutosUseCase
import kotlinx.coroutines.launch


class AdicionarDisputasViewModel (
    private  val adicionarIntencaoUseCase: AdicionarIntencaoUseCase,
    private  val listCategoriasUseCase: ListCategoriasUseCase,
    private  val listMarcasUseCase: ListMarcasUseCase,
    private  val listProdutosUseCase: ListProdutosUseCase
): ViewModel() {

    val adicionarIntencaoState = MutableLiveData<RequestState<NewIntencao>>()
    val listCategoriasState    = MutableLiveData<RequestState<MutableList<Categoria>>>()
    val listMarcasState    = MutableLiveData<RequestState<MutableList<Marca>>>()
    val listProdutosState    = MutableLiveData<RequestState<MutableList<Produto>>>()

    fun create(newIntencao: NewIntencao ){
        viewModelScope.launch {
            adicionarIntencaoState.value = adicionarIntencaoUseCase
                .create(newIntencao)
        }
    }

    fun listCategorias(){
        viewModelScope.launch {
            listCategoriasState.value = listCategoriasUseCase.getCategorias()
        }
    }

    fun listMarcas(){
        viewModelScope.launch {
            listMarcasState.value = listMarcasUseCase.getMarcas()
        }
    }

    fun listProdutos(){
        viewModelScope.launch {
            listProdutosState.value = listProdutosUseCase.getProdutos()
        }
    }
}