package br.com.fiap.arremate.ui.data.service

import br.com.fiap.arremate.ui.domain.entity.Intencao
import br.com.fiap.arremate.ui.domain.entity.ListIntencao
import retrofit2.Call
import retrofit2.http.GET

interface IntencaoService {

    @GET("/V3/Northwind/Northwind.svc/Products?\$format=json")
    fun list(): Call<ListIntencao>
//    fun list(): Call<List<Intencao>>
}