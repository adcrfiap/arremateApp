package br.com.fiap.arremate.ui.presentation.listaDisputas

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.arremate.R
import br.com.fiap.arremate.ui.data.remote.datasource.IntencaoRemoteDataSourceImpl
import br.com.fiap.arremate.ui.data.repository.IntencaoRepositoryImpl
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.usecases.ListIntencaoUseCase
import br.com.fiap.arremate.ui.presentation.base.BaseFragment


class HomeFragment : BaseFragment() {

    override val layout = R.layout.fragment_home

    private val homeViewModel: HomeViewModel by lazy {
        ViewModelProvider(
                this,
                HomeViewModelFactory(
                        ListIntencaoUseCase(
                                IntencaoRepositoryImpl(
                                        IntencaoRemoteDataSourceImpl(

                                        )
                                )
                        )
                )
        ).get(HomeViewModel::class.java)
    }

    override fun onViewCreated( view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ListIntencaoAdapter(view.context)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvListDisputas)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(view.context)


        registerObserver(adapter)
        homeViewModel.listIntencao()

    }

    private fun registerObserver(adapter: ListIntencaoAdapter) {

        this.homeViewModel.ListIntencaoState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is RequestState.Success -> {

                    if ((it as RequestState.Success).data != null){
                        adapter.setIntencoes((it as RequestState.Success).data)
                    }

                    adapter.setModel(homeViewModel)

                }
            }
        })

    }

//    override fun onCreateView(
//            inflater: LayoutInflater,
//            container: ViewGroup?,
//            savedInstanceState: Bundle?
//    ): View? {
//        homeViewModel =
//                ViewModelProvider(this).get(HomeViewModel::class.java)
//        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
//        return root
//    }
}