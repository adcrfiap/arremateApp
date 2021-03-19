package br.com.fiap.arremate.ui.domain.usecases

import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.repository.UserRepository

class ResetPasswordUseCase(
        private val userRepository: UserRepository
) {
    suspend fun resetPassword(email: String): RequestState<String> =
            userRepository.resetPassword(email)
}