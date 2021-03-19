package br.com.fiap.arremate.ui.domain.usecases

import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.repository.UserRepository

class SignOutUseCase(
    private val userRepository: UserRepository
) {

    suspend fun signout(): RequestState<String> =
        userRepository.signout()

}