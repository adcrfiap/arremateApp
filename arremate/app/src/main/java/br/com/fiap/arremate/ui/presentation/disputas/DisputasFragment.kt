package br.com.fiap.arremate.ui.presentation.disputas

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import br.com.fiap.arremate.R
import br.com.fiap.arremate.ui.data.remote.datasource.UserRemoteDataSourceImpl
import br.com.fiap.arremate.ui.data.repository.UserRepositoryImpl
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.usecases.SignOutUseCase
import br.com.fiap.mobileproject.presentation.base.auth.BaseAuthFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class DisputasFragment : BaseAuthFragment() {

    override val layout = R.layout.fragment_disputas

    private val disputasViewModel: DisputasViewModel by lazy {
        ViewModelProvider(
            this,
            DisputasViewModelFactory(
                SignOutUseCase(
                    UserRepositoryImpl(
                        UserRemoteDataSourceImpl(

                        )
                    )
                )
            )
        ).get(DisputasViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onCreate(savedInstanceState)
        val activity = activity as AppCompatActivity
        setUpToolbar(view, activity)
        setUpActionButton(view)
        registerObserver()
        registerBackPressedAction()

    }

    private fun setUpActionButton(view: View) {
        val fab: FloatingActionButton = view.findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            findNavController().navigate(R.id.action_disputasFragment_to_adicionarDisputasFragment)
        }
    }

    private fun setUpToolbar(
        view: View,
        activity: AppCompatActivity
    ) {

        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        toolbar.title = "LISTA DISPUTAS"
        activity.setSupportActionBar(toolbar)

        toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.action_userdata){
                Snackbar.make(view, "Você clicou no settings", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }

            if (it.itemId == R.id.action_logout){
                disputasViewModel.doSignOut()
            }

            true
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main, menu)

    }

    private fun registerObserver() {
        disputasViewModel.signOutState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is RequestState.Success -> showSuccess()
                is RequestState.Error -> showError(it.throwable)
            }
        })


    }

    private fun showSuccess() {
        hideLoading()
        findNavController().navigate(R.id.main_nav_graph)
    }


    private fun showError(throwable: Throwable) {
        hideLoading()
        showMessage(throwable.message)
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