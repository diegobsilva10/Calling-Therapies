package com.example.callingtherapies


//INFLA A VIEW CRIADA E LIGAR COM CADA UM DOS PRODUTOS
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProdutoAdapter (
    val produtos: List<Produto>,
    val onClick: (Produto) -> Unit
    ):
    RecyclerView.Adapter<ProdutoAdapter.DisciplinasViewHolder>() {
        // ViewHolder com os elementos da tela
        class DisciplinasViewHolder(view: View): RecyclerView.ViewHolder(view) {
            val cardNome: TextView = view.findViewById<TextView>(R.id.cardNome)
            var cardView: CardView
            init {
                cardView = view.findViewById<CardView>(R.id.card_produtos)
            }
        }
        // Quantidade de disciplinas na lista
        override fun getItemCount() = this.produtos.size
        // inflar layout do adapter
        override fun onCreateViewHolder(
            parent: ViewGroup, viewType: Int): DisciplinasViewHolder {
            // infla view no adapter
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_produto, parent, false)
            // retornar ViewHolder
            val holder = DisciplinasViewHolder(view)
            return holder
        }
    // bind para atualizar Views com os dados
    override fun onBindViewHolder(holder: DisciplinasViewHolder, position: Int) {
        val context = holder.itemView.context
        // recuperar objeto disciplina
        val produto = produtos[position]
        // atualizar dados de disciplina
        holder.cardNome.text = produto.name

        // adiciona evento de clique
        holder.itemView.setOnClickListener {onClick(produto)}
    }
}