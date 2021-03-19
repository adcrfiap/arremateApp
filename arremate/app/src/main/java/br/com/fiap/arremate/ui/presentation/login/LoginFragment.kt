package br.com.fiap.arremate.ui.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.com.fiap.arremate.R
import br.com.fiap.arremate.ui.data.remote.datasource.UserRemoteDataSourceImpl
import br.com.fiap.arremate.ui.data.repository.UserRepositoryImpl
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.expcetions.UserNotLoggedException
import br.com.fiap.arremate.ui.domain.usecases.LoginUseCase
import br.com.fiap.arremate.ui.domain.usecases.ResetPasswordUseCase
import br.com.fiap.arremate.ui.presentation.base.BaseFragment
import br.com.fiap.mobileproject.presentation.base.auth.NAVIGATION_KEY

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : BaseFragment() {

    override val layout = R.layout.fragment_login
    private lateinit var btLogin: Button
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var tvSignup: TextView

    private val loginViewModel: LoginViewModel by lazy {
        ViewModelProvider(
            this,
            LoginViewModelFactory(
                LoginUseCase(
                    UserRepositoryImpl(
                        UserRemoteDataSourceImpl(

                        )
                    )
                ),
                ResetPasswordUseCase(
                    UserRepositoryImpl(
                        UserRemoteDataSourceImpl(
                        )
                    )
                )
            )
        ).get(LoginViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView(view)
        registerObserver()
        registerBackPressedAction()
    }

    private fun registerObserver() {
        loginViewModel.loginState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is RequestState.Success -> showSuccess()
                is RequestState.Error -> showError(it.throwable)
                is RequestState.Loading -> showLoading("Authenticating")
            }
        })
    }

    private fun setUpView(view: View) {
        btLogin = view.findViewById(R.id.btLogin)
        etEmail = view.findViewById(R.id.etEmail)
        etPassword = view.findViewById(R.id.etPassword)
        tvSignup   = view.findViewById(R.id.tvSignUP)

        btLogin.setOnClickListener {
            loginViewModel.doLogin(
                etEmail.text.toString(),
                etPassword.text.toString()
            )
        }

        tvSignup.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }

    }

    private fun showSuccess() {
        hideLoading()
//        val navIdForArguments = arguments?.getInt(NAVIGATION_KEY)
//        if (navIdForArguments == null) {
            findNavController().navigate(R.id.main_nav_graph)
//        } else {
//            findNavController().popBackStack(navIdForArguments, false)
//        }
    }

    private fun showError(throwable: Throwable) {
        hideLoading()

        if(throwable is UserNotLoggedException){

        }else {

            etEmail.error = null
            etPassword.error = null

            showMessage(throwable.message)
        }
    }

    private fun registerBackPressedAction() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }

}