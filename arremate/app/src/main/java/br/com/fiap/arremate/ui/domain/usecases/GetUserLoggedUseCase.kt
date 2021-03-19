package br.com.fiap.arremate.ui.domain.usecases

import br.com.fiap.arremate.ui.domain.entity.Comprador
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.repository.UserRepository

class GetUserLoggedUseCase(
        private val userRepository: UserRepository
){

    suspend fun getUserLogged() : RequestState<Comprador> = userRepository.getUserLogged()

}