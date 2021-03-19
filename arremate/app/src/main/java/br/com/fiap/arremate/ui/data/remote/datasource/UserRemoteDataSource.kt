package br.com.fiap.arremate.ui.data.remote.datasource

import br.com.fiap.arremate.ui.domain.entity.Comprador
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.entity.UserLogin

interface UserRemoteDataSource {
    suspend fun getUserLogged(): RequestState<Comprador>

    suspend fun doLogin(userLogin: UserLogin): RequestState<Comprador>

    suspend fun resetPassword(email: String): RequestState<String>

    suspend fun create(comprador: Comprador): RequestState<Comprador>

    suspend fun signout(): RequestState<String>

}