package br.com.fiap.arremate.ui.presentation.listaDisputas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.arremate.R
import br.com.fiap.arremate.ui.domain.entity.Intencao
import com.google.android.material.snackbar.Snackbar

class ListIntencaoAdapter internal constructor(
        context: Context
): RecyclerView.Adapter<ListIntencaoAdapter.IntencaoViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var intencoes: MutableList<Intencao> = mutableListOf<Intencao>()
    private var homeViewModel: HomeViewModel? = null

    inner class IntencaoViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {

        val intencaoNomeView: TextView = itemView.findViewById(R.id.tvNomeProduto)
        val intencaoCategoriaView: TextView = itemView.findViewById(R.id.tvCategoria)
        val intencaoModeloView: TextView = itemView.findViewById(R.id.tvModelo)
        val intencaoIdView: TextView = itemView.findViewById(R.id.tvid)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntencaoViewHolder {
        val itemView = inflater.inflate(R.layout.intencao_item, parent, false)

        return IntencaoViewHolder(itemView)
    }

    override fun getItemCount() = intencoes.size

    override fun onBindViewHolder(holder: IntencaoViewHolder, position: Int) {
        val current = intencoes[position]

        holder.intencaoNomeView.text = current.descricao
        holder.intencaoCategoriaView.text = current.valorMinimo
        holder.intencaoModeloView.text = current.data
        holder.intencaoIdView.text = current.idIntensao.toString()

        holder.itemView?.setOnClickListener { view ->
            Snackbar.make(view, "Você cliclou no item $position", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

    }

    internal fun setIntencoes(intencoes: MutableList<Intencao>? = mutableListOf<Intencao>()) {
        if (intencoes != null) {
            this.intencoes = intencoes
        }
        notifyDataSetChanged()
    }

    internal fun setModel(homeViewModel: HomeViewModel) {
        this.homeViewModel = homeViewModel
    }

}