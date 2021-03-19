package br.com.fiap.arremate.ui.data.repository

import br.com.fiap.arremate.ui.data.remote.datasource.UserRemoteDataSource
import br.com.fiap.arremate.ui.domain.entity.Comprador
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.entity.UserLogin
import br.com.fiap.arremate.ui.domain.repository.UserRepository

class UserRepositoryImpl (
        val userRemoteDataSource: UserRemoteDataSource
) : UserRepository {


    override suspend fun getUserLogged(): RequestState<Comprador> {
        return userRemoteDataSource.getUserLogged()
    }

    override suspend fun doLogin(userLogin: UserLogin): RequestState<Comprador> {
        return  userRemoteDataSource.doLogin(userLogin)
    }

    override suspend fun resetPassword(email: String): RequestState<String> {
        return userRemoteDataSource.resetPassword(email)
    }

    override suspend fun create(comprador: Comprador): RequestState<Comprador> {
        return userRemoteDataSource.create(comprador)
    }

    override suspend fun signout(): RequestState<String> {
        return userRemoteDataSource.signout()
    }
}