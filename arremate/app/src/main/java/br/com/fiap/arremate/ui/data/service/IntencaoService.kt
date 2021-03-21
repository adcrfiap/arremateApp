package br.com.fiap.arremate.ui.data.service

import br.com.fiap.arremate.ui.domain.entity.Intencao
import br.com.fiap.arremate.ui.domain.entity.NewIntencao
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IntencaoService {

//    @GET("/V3/Northwind/Northwind.svc/Products?\$format=json")
    @GET("/intensao")
    fun list(): Call<List<Intencao>>
//    fun list(): Call<List<Intencao>>

    @POST("/intensao")
    fun createIntencao(@Body newIntencao: NewIntencao): Call<Intencao>
}