package br.com.fiap.mobileproject.presentation.base.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.com.fiap.arremate.R
import br.com.fiap.arremate.ui.data.remote.datasource.UserRemoteDataSourceImpl
import br.com.fiap.arremate.ui.data.repository.UserRepositoryImpl
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.usecases.GetUserLoggedUseCase
import br.com.fiap.arremate.ui.presentation.base.BaseFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi

const val NAVIGATION_KEY = "NAV_KEY"

@ExperimentalCoroutinesApi
abstract class BaseAuthFragment : BaseFragment() {

    private val baseAuthViewModel: BaseAuthViewModel by lazy {
        ViewModelProvider(
                this,
                BaseViewModelFactory(
                        GetUserLoggedUseCase(
                                UserRepositoryImpl(
                                        UserRemoteDataSourceImpl(
                                        )
                                )
                        )
                )
        ).get(BaseAuthViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        registerObserver()

        baseAuthViewModel.getUserLogged()

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun registerObserver() {

        baseAuthViewModel.userLoggedState.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is RequestState.Loading -> {
                    showLoading()
                }

                is RequestState.Success -> {
                    hideLoading()
                }

                is RequestState.Error -> {
                    hideLoading()
                    findNavController().navigate(
                            R.id.login_nav_graph, bundleOf(
                            NAVIGATION_KEY to findNavController().currentDestination?.id
                    )
                    )
                }
            }
        })
    }
}