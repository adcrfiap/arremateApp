package br.com.fiap.arremate.ui.domain.usecases

import br.com.fiap.arremate.ui.domain.entity.Comprador
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.entity.UserLogin
import br.com.fiap.arremate.ui.domain.repository.UserRepository

class LoginUseCase(
        private val userRepository: UserRepository
) {

    suspend fun doLogin(userLogin: UserLogin): RequestState<Comprador> =
            userRepository.doLogin(userLogin)

}