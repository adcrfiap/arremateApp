package br.com.fiap.arremate.ui.presentation.adicionarDisputas

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.arremate.R
import br.com.fiap.arremate.ui.data.remote.datasource.IntencaoRemoteDataSourceImpl
import br.com.fiap.arremate.ui.data.repository.IntencaoRepositoryImpl
import br.com.fiap.arremate.ui.domain.entity.ListHelp
import br.com.fiap.arremate.ui.domain.entity.LoginSession
import br.com.fiap.arremate.ui.domain.entity.NewIntencao
import br.com.fiap.arremate.ui.domain.entity.RequestState
import br.com.fiap.arremate.ui.domain.usecases.AdicionarIntencaoUseCase
import br.com.fiap.arremate.ui.presentation.base.BaseFragment
import com.google.android.material.slider.LabelFormatter
import com.google.android.material.slider.RangeSlider
import com.google.android.material.snackbar.Snackbar
import java.util.*


class AdicionarDisputasFragment : BaseFragment() {

    override val layout = R.layout.fragment_adicionar_disputas
    private lateinit var btBackAdicionarDisputas: Button
    private lateinit var btnCriarDisputa: Button
    private lateinit var etNomeAdicionarDisputas: EditText
    private lateinit var etMarcaNew: AutoCompleteTextView
    private lateinit var etProdutoNew: AutoCompleteTextView
    private lateinit var etCategoriaNew: AutoCompleteTextView
    private lateinit var etModeloNew: AutoCompleteTextView
    private lateinit var etDescricaoNew: EditText
    private lateinit var rsValores: RangeSlider
    private lateinit var etLow: EditText
    private lateinit var etHigh: EditText
    private var stringArray: ArrayList<ListHelp> = arrayListOf()
    private var stringArrayP: ArrayList<ListHelp> = arrayListOf()
    private var stringArrayM: ArrayList<ListHelp> = arrayListOf()
    private var stringArrayMo: ArrayList<ListHelp> = arrayListOf()

    private val adicionarDisputasViewModel: AdicionarDisputasViewModel by lazy {
        ViewModelProvider(
            this,
            AdicionarDisputasViewModelFactory(
                AdicionarIntencaoUseCase(
                    IntencaoRepositoryImpl(
                        IntencaoRemoteDataSourceImpl(

                        )
                    )
                )
            )
        ).get(AdicionarDisputasViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView(view)
        setUpListener(view)
        registerBackPressedAction()
        registerObserver(view)

    }

    private fun registerObserver(view: View) {
        this.adicionarDisputasViewModel.adicionarIntencaoState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is RequestState.Success -> {
                    Snackbar.make(view, "Nova disputa criada!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
                    NavHostFragment.findNavController(this)
                        .navigate(R.id.main_nav_graph)
                }
                is RequestState.Error -> {

                    showMessage(it.throwable.message)
                }
            }
        })
    }

    private fun setUpListener(view: View) {
        btBackAdicionarDisputas.setOnClickListener {
            findNavController().navigate(R.id.main_nav_graph)
        }

        btnCriarDisputa.setOnClickListener{
            var newIntencao: NewIntencao = NewIntencao(1,LoginSession.userId,
                                                            etLow.text.toString().toLong(),
                                                            etHigh.text.toString().toLong(),
                                                            etDescricaoNew.text.toString())

            adicionarDisputasViewModel.create(newIntencao)
        }

        rsValores.addOnChangeListener(object : RangeSlider.OnChangeListener{

            override fun onValueChange(slider: RangeSlider, value: Float, fromUser: Boolean) {
                setSliderValues(slider)

            }
        })

        etMarcaNew.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus){
                fillListMarca(view)
                etMarcaNew.showDropDown()

//           Verifica se é uma valor valido da lista, se não for limpa o campo
            }else{

                val str: String = etMarcaNew.getText().toString()
                var invalido: Boolean = true

                val listAdapter: ListAdapter = etMarcaNew.getAdapter()
                for (i in 0 until listAdapter.count) {
                    val temp = listAdapter.getItem(i).toString()
                    if (str.compareTo(temp) == 0) {
                        invalido = false
                        break
                    }
                }

                if (invalido){
                    etMarcaNew.setText("")
                }

            }
        }

        etProdutoNew.setOnFocusChangeListener { v, hasFocus ->
            var listHelp: ListHelp
            if(hasFocus){
                fillListProduto(view)
                etProdutoNew.showDropDown()

//           Verifica se é uma valor valido da lista, se não for limpa o campo
            }else{

                val str: String = etProdutoNew.getText().toString()
                var invalido: Boolean = true

                val listAdapter: ListAdapter = etProdutoNew.getAdapter()
                for (i in 0 until listAdapter.count) {
                    listHelp = listAdapter.getItem(i) as ListHelp
                    val temp = listAdapter.getItem(i).toString()
                    if (str.compareTo(temp) == 0) {
                        invalido = false
                        break
                    }
                }

                if (invalido){
                    etProdutoNew.setText("")
                }

            }
        }

        etModeloNew.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus){
                fillListModelo(view)
                etModeloNew.showDropDown()

//           Verifica se é uma valor valido da lista, se não for limpa o campo
            }else{
                var listHelp: ListHelp
                val str: String = etModeloNew.getText().toString()
                var invalido: Boolean = true

                val listAdapter: ListAdapter = etModeloNew.getAdapter()
                for (i in 0 until listAdapter.count) {
                    listHelp = listAdapter.getItem(i) as ListHelp
                    val temp = listAdapter.getItem(i).toString()
                    if (str.compareTo(temp) == 0) {
                        invalido = false
                        break
                    }
                }

                if (invalido){
                    etModeloNew.setText("")
                }

            }
        }

        etCategoriaNew.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus){
                fillListCategoria(view)
                etCategoriaNew.showDropDown()

//           Verifica se é uma valor valido da lista, se não for limpa o campo
            }else{
                val str: String = etCategoriaNew.getText().toString()
                var invalido: Boolean = true

                val listAdapter: ListAdapter = etCategoriaNew.getAdapter()
                for (i in 0 until listAdapter.count) {
                    val temp = listAdapter.getItem(i).toString()
                    if (str.compareTo(temp) == 0) {
                        invalido = false
                        break
                    }
                }

                if (invalido){
                    etCategoriaNew.setText("")
                }

            }
        }

    }

    private fun fillListModelo(view: View) {
        val adapterModelo: ArrayAdapter<ListHelp>

//        Configrua Marca
        stringArrayMo.clear()
        stringArrayMo.add(ListHelp(1,"Modelo 1"))
        stringArrayMo.add(ListHelp(2,"Modelo 2"))
        stringArrayMo.add(ListHelp(3,"Modelo 3"))



        adapterModelo = ArrayAdapter<ListHelp>(view.context, android.R.layout.simple_spinner_dropdown_item, stringArrayMo)

        etModeloNew.threshold = 0 //will start working from first character

        etModeloNew.setAdapter(adapterModelo) //setting the adapter data into the AutoCompleteTextView
    }

    private fun fillListMarca(view: View) {
        val adapterMarca: ArrayAdapter<ListHelp>

//        Configrua Marca
        stringArrayM.clear()
        stringArrayM.add(ListHelp(1,"Marca 1"))
        stringArrayM.add(ListHelp(2,"Marca 2"))
        stringArrayM.add(ListHelp(3,"Marca 3"))

        adapterMarca = ArrayAdapter<ListHelp>(view.context, android.R.layout.simple_spinner_dropdown_item, stringArrayM)

        etMarcaNew.threshold = 0 //will start working from first character

        etMarcaNew.setAdapter(adapterMarca) //setting the adapter data into the AutoCompleteTextView
    }

    private fun fillListProduto(view: View) {
        val adapterProduto: ArrayAdapter<ListHelp>

//        Configrua Produto
        stringArrayP.clear()
        stringArrayP.add(ListHelp(1,"Produto 1"))
        stringArrayP.add(ListHelp(2,"Produto 2"))
        stringArrayP.add(ListHelp(3,"Produto 3"))



        adapterProduto = ArrayAdapter<ListHelp>(view.context, android.R.layout.simple_spinner_dropdown_item, stringArrayP)

        etProdutoNew.threshold = 0 //will start working from first character

        etProdutoNew.setAdapter(adapterProduto) //setting the adapter data into the AutoCompleteTextView
    }

    private fun fillListCategoria(view: View) {
        val adapterCategoria: ArrayAdapter<ListHelp>

        //    Configura Categoria
        stringArray.clear()
        stringArray.add(ListHelp(1,"Categoria 1"))
        stringArray.add(ListHelp(2,"Categoria 2"))
        stringArray.add(ListHelp(3,"Categoria 3"))
        stringArray.add(ListHelp(4,"Categoria 4"))
        stringArray.add(ListHelp(5,"Categoria 5"))



        adapterCategoria = ArrayAdapter<ListHelp>(view.context, android.R.layout.simple_spinner_dropdown_item, stringArray)

        etCategoriaNew.threshold = 0 //will start working from first character

        etCategoriaNew.setAdapter(adapterCategoria) //setting the adapter data into the AutoCompleteTextView
    }

    private fun registerBackPressedAction() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }

    private fun setUpView(view: View) {

        btBackAdicionarDisputas      = view.findViewById(R.id.btBackAdicionarDisputas)
        btnCriarDisputa              = view.findViewById(R.id.btnCriarDisputa)
        etNomeAdicionarDisputas      = view.findViewById(R.id.etProdutoNew)
        etMarcaNew                   = view.findViewById(R.id.etMarcaNew)
        etProdutoNew                 = view.findViewById(R.id.etProdutoNew)
        etCategoriaNew               = view.findViewById(R.id.etCategoriaNew)
        etModeloNew                  = view.findViewById(R.id.etModeloNew)
        etDescricaoNew               = view.findViewById(R.id.etDescricao)
        rsValores                    = view.findViewById(R.id.rsValores)
        etLow                        = view.findViewById(R.id.etLow)
        etHigh                       = view.findViewById(R.id.etHigh)



        //Configura Slider
        setSliderValues(rsValores)

        rsValores.labelBehavior = LabelFormatter.LABEL_GONE



    }

    private fun setSliderValues(slider: RangeSlider) {
        val values = slider.values
        etLow.setText(values[0].toInt().toString())
        etHigh.setText(values[1].toInt().toString())
    }

}