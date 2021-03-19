package br.com.fiap.arremate.ui.data.service

import br.com.fiap.arremate.ui.domain.entity.Comprador
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserService {

    @GET("/comprador/{id}")
    fun getUser(@Path("id") id: String): Call<Comprador>

    @POST("/comprador")
    fun createUser(@Body comprador: Comprador): Call<Comprador>

}