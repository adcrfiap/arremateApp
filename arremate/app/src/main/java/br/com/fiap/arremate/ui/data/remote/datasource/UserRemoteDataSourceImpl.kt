package br.com.fiap.arremate.ui.data.remote.datasource

import br.com.fiap.arremate.ui.data.helpers.RetrofitInitializer
import br.com.fiap.arremate.ui.domain.entity.*
import br.com.fiap.arremate.ui.domain.expcetions.LoginNotPossibleException
import br.com.fiap.arremate.ui.domain.expcetions.UserNotCreatedException
import br.com.fiap.arremate.ui.domain.expcetions.UserNotLoggedException
import retrofit2.awaitResponse

class UserRemoteDataSourceImpl(

) : UserRemoteDataSource {


    override suspend fun getUserLogged(): RequestState<Comprador> {


        if (LoginSession.userId == 0){
            return RequestState.Error( UserNotLoggedException())
        }

        val call = RetrofitInitializer().userService().getUser(LoginSession.userId.toString()).awaitResponse()



        if (call.code().toString() != "200"){
            return RequestState.Error( UserNotLoggedException())
        }else{
            var comprador = call.body()!!
            LoginSession.userId = comprador.id.toLong()
            return  RequestState.Success(comprador)
        }

    }


    override suspend fun doLogin(userLogin: UserLogin): RequestState<Comprador> {


        val call = RetrofitInitializer().userService().getUser("3").awaitResponse()



        if (call.code().toString() != "200"){
            return RequestState.Error( LoginNotPossibleException())
        }else{
            var comprador = call.body()!!
            LoginSession.userId = comprador.id.toLong()
            return  RequestState.Success(comprador)
        }

    }

    override suspend fun resetPassword(email: String): RequestState<String> {
        return RequestState.Success("Verifique seu email")
    }

    override suspend fun create(comprador: Comprador): RequestState<Comprador> {
        val call = RetrofitInitializer().userService().createUser(comprador).awaitResponse()

        if (call.code().toString() != "201"){
            return RequestState.Error( UserNotCreatedException())
        }else{
            val compradorResp = call.body()!!
            return  RequestState.Success(compradorResp)
        }


    }

    override suspend fun signout(): RequestState<String> {

        LoginSession.userId = 0
        return RequestState.Success("true")
    }

}