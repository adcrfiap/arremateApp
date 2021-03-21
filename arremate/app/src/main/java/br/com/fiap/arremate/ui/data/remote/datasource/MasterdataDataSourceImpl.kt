package br.com.fiap.arremate.ui.data.remote.datasource

import br.com.fiap.arremate.ui.data.helpers.RetrofitInitializer
import br.com.fiap.arremate.ui.domain.entity.Categoria
import br.com.fiap.arremate.ui.domain.entity.Marca
import br.com.fiap.arremate.ui.domain.entity.Produto
import br.com.fiap.arremate.ui.domain.entity.RequestState
import retrofit2.awaitResponse

class MasterdataDataSourceImpl (

): MasterdataDataSource{
    override suspend fun getCategorias(): RequestState<MutableList<Categoria>> {
        var queryResult: MutableList<Categoria> = mutableListOf<Categoria>()

        val call = RetrofitInitializer().masterDataService().listCategorias().awaitResponse()

        queryResult = call.body()?.toMutableList() ?: mutableListOf<Categoria>()

        return  RequestState.Success(queryResult)
    }

    override suspend fun getMarcas(): RequestState<MutableList<Marca>> {
        var queryResult: MutableList<Marca> = mutableListOf<Marca>()

        val call = RetrofitInitializer().masterDataService().listMarcas().awaitResponse()

        queryResult = call.body()?.toMutableList() ?: mutableListOf<Marca>()

        return  RequestState.Success(queryResult)
    }

    override suspend fun getProdutos(): RequestState<MutableList<Produto>> {
        var queryResult: MutableList<Produto> = mutableListOf<Produto>()

        val call = RetrofitInitializer().masterDataService().listProdutos().awaitResponse()

        queryResult = call.body()?.toMutableList() ?: mutableListOf<Produto>()

        return  RequestState.Success(queryResult)
    }

}