package br.com.fiap.arremate.ui.data.helpers

import br.com.fiap.arremate.ui.data.service.IntencaoService
import br.com.fiap.arremate.ui.data.service.MasterdataService
import br.com.fiap.arremate.ui.data.service.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofitIntencao = Retrofit.Builder()
//        .baseUrl("https://services.odata.org/")
        .baseUrl("https://ms-intensao.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitUser = Retrofit.Builder()
            .baseUrl("https://ms-comprador.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val retrofitMasterdata = Retrofit.Builder()
            .baseUrl("https://ms--produto.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun intencaoService() = retrofitIntencao.create(IntencaoService::class.java)
    fun userService() = retrofitUser.create(UserService::class.java)
    fun masterDataService() = retrofitMasterdata.create(MasterdataService::class.java)

}