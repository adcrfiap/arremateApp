package br.com.fiap.arremate.ui.presentation.signup

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import android.widget.Button
import android.widget.EditText
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.concrete.canarinho.validator.Validador
import br.com.concrete.canarinho.watcher.MascaraNumericaTextWatcher
import br.com.fiap.arremate.R
import br.com.fiap.arremate.ui.data.remote.datasource.UserRemoteDataSourceImpl
import br.com.fiap.arremate.ui.data.repository.UserRepositoryImpl
import br.com.fiap.arremate.ui.domain.entity.*
import br.com.fiap.arremate.ui.domain.usecases.CreateUserUseCase
import br.com.fiap.arremate.ui.presentation.base.BaseFragment


class SignupFragment :  BaseFragment() {

    override val layout = R.layout.fragment_signup
    private lateinit var etEmailSignup: EditText
    private lateinit var etPasswordSignup: EditText
    private lateinit var etPasswordConfirmSignup: EditText
    private lateinit var etNameSignup: EditText
    private lateinit var etSobrenomeSIgnup: EditText
    private lateinit var etCpfSignup: EditText
    private lateinit var etCelularSignup: EditText
    private lateinit var etUsuarioSIgnup: EditText
    private lateinit var btBack: Button
    private lateinit var btCreateUser: Button
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"


    private val signupViewModel: SignupViewModel by lazy {
        ViewModelProvider(
            this,
            SignupViewModelFactory(
                CreateUserUseCase(
                    UserRepositoryImpl(
                        UserRemoteDataSourceImpl(

                        )
                    )
                )
            )
        ).get(SignupViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView(view)
        setUpListener(view)
        registerBackPressedAction()
        registerObserver()
    }

    private fun registerObserver() {
        val dialogBuilder = AlertDialog.Builder(getActivity())
        dialogBuilder.setMessage("")
                // if the dialog is cancelable
                .setCancelable(false)
                .setPositiveButton("Ok", DialogInterface.OnClickListener {
                    dialog, id ->
                    dialog.dismiss()

                })
        val alert = dialogBuilder.create()

        signupViewModel.newUserState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is RequestState.Success -> {
                    alert.setTitle("Sucesso")
                    alert.setMessage("Usuario criado!")
                    alert.show()
                    findNavController().navigate(R.id.login_nav_graph)
                }
                is RequestState.Error -> {
                    alert.setTitle("Error")
                    alert.setMessage("Não foi possivel criar o usuario!")
                    alert.show()
                    findNavController().navigate(R.id.login_nav_graph)
                }

            }
        })
    }

    private fun setUpView(view: View) {

        etEmailSignup = view.findViewById(R.id.etEmailSignup)
        etPasswordSignup = view.findViewById(R.id.etPasswordSignup)
        etPasswordConfirmSignup = view.findViewById(R.id.etPasswordConfirmSignup)
        etNameSignup = view.findViewById(R.id.etNameSignup)
        etSobrenomeSIgnup = view.findViewById(R.id.etSobrenomeSIgnup)
        etCpfSignup = view.findViewById(R.id.etCpfSignup)
        etCelularSignup = view.findViewById(R.id.etCelularSignup)
        etUsuarioSIgnup = view.findViewById(R.id.etUsuarioSIgnup)
        btBack = view.findViewById(R.id.btBackAdicionarDisputas)
        btCreateUser = view.findViewById(R.id.btnSignup)

    }

    private fun setUpListener(view: View) {
        val dialogBuilder = AlertDialog.Builder(getActivity())
        dialogBuilder.setMessage("")
                // if the dialog is cancelable
                .setCancelable(false)
                .setPositiveButton("Ok", DialogInterface.OnClickListener {
                    dialog, id ->
                    dialog.dismiss()

                })

        val alert = dialogBuilder.create()


        btBack.setOnClickListener {
            findNavController().navigate(R.id.login_nav_graph)
        }

        btCreateUser.setOnClickListener {
            var password = etPasswordSignup.text.toString()
            var passwordConfirm = etPasswordConfirmSignup.text.toString()
            var name      = etNameSignup.text.toString()
            var sobrenome = etSobrenomeSIgnup.text.toString()
            var email     = etEmailSignup.text.toString()
            var cpf       = etCpfSignup.text.toString()
            var celular   = etCelularSignup.text.toString()
            var usuario   = etUsuarioSIgnup.text.toString()

//           Todos os campos devem ser informados
            if(password.trim().length == 0 || passwordConfirm.trim().length == 0 || name.trim().length == 0 ||  email.trim().length == 0    || cpf.trim().length == 0
                    || usuario.trim().length == 0 || celular.trim().length == 0 || sobrenome.trim().length == 0){
                alert.setTitle("Erro")
                alert.setMessage("Informar todos os campos!")
                alert.show()

            }else{

                if(!email.matches(emailPattern.toRegex())){
                    alert.setTitle("Erro")
                    alert.setMessage("Email inválido!")
                    alert.show()
                    return@setOnClickListener
                }


                if (password != passwordConfirm){
                    alert.setTitle("Erro")
                    alert.setMessage("As senhas devem ser iguais!")
                    alert.show()


                }else{
                    val comprador = Comprador("",name,sobrenome,cpf,
                                              Contato("",celular,email,celular),
                                              Usuario("",email,password,usuario ),
                                              Endereco("","","","","","","", ""))

                    signupViewModel.create(comprador)


                }
            }


        }

        etCpfSignup.addTextChangedListener(
            MascaraNumericaTextWatcher.Builder()
                .paraMascara("###.###.###-##")
                .comValidador(Validador.CPF)
                .build()
        )

        etCelularSignup.addTextChangedListener(
            MascaraNumericaTextWatcher.Builder()
                .paraMascara("(##)#####-####")
                .comValidador(Validador.TELEFONE)
                .build()
        )

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