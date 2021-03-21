package br.com.fiap.arremate.ui.data.service

import br.com.fiap.arremate.ui.domain.entity.Categoria
import br.com.fiap.arremate.ui.domain.entity.Marca
import br.com.fiap.arremate.ui.domain.entity.Produto
import retrofit2.Call
import retrofit2.http.GET

interface MasterdataService {

    @GET("/categorias")
    fun listCategorias(): Call<List<Categoria>>

    @GET("/marcas")
    fun listMarcas(): Call<List<Marca>>

    @GET("/produtos")
    fun listProdutos(): Call<List<Produto>>
}