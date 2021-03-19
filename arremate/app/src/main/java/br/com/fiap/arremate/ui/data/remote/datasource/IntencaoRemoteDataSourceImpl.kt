package br.com.fiap.arremate.ui.data.remote.datasource

import br.com.fiap.arremate.ui.data.helpers.RetrofitInitializer
import br.com.fiap.arremate.ui.domain.entity.Intencao
import br.com.fiap.arremate.ui.domain.entity.NewIntencao
import br.com.fiap.arremate.ui.domain.entity.RequestState

import retrofit2.awaitResponse

class IntencaoRemoteDataSourceImpl (

): IntencaoRemoteDataSource{
    override suspend fun listIntencao(): RequestState<MutableList<Intencao>> {
        var queryResult: MutableList<Intencao> = mutableListOf<Intencao>()

        val call = RetrofitInitializer().intencaoService().list().awaitResponse()

        queryResult = call.body()?.intencoes?.toMutableList() ?: mutableListOf<Intencao>()

        return  RequestState.Success(queryResult)

    }

    override suspend fun create(newIntencao: NewIntencao): RequestState<NewIntencao> {
        return try {

            RequestState.Success(newIntencao)

        } catch (e: java.lang.Exception) {
            RequestState.Error(e)
        }
    }


}
