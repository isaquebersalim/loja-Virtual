package com.example.loja_virtual

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loja_virtual.data.Product
import java.text.NumberFormat
import java.util.Locale

class ProductAdapter(private val products: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtNome: TextView = view.findViewById(R.id.txt_nome)
        val txtCodigo: TextView = view.findViewById(R.id.txt_codigo)
        val txtPreco: TextView = view.findViewById(R.id.txt_preco)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.txtNome.text = product.name
        holder.txtCodigo.text = "Código: ${product.code}"
        
        val format = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
        holder.txtPreco.text = format.format(product.price)
    }

    override fun getItemCount() = products.size
}
