package com.example.loja_virtual

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loja_virtual.data.ProductDatabase
import kotlinx.coroutines.launch

class ListagemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem)

        val recycler = findViewById<RecyclerView>(R.id.recycler_produtos)
        val btnVoltar = findViewById<Button>(R.id.btn_voltar)

        recycler.layoutManager = LinearLayoutManager(this)

        // Carregar produtos do banco
        val db = ProductDatabase.getDatabase(this)
        lifecycleScope.launch {
            val products = db.productDao().getAllProducts()
            recycler.adapter = ProductAdapter(products)
        }

        btnVoltar.setOnClickListener {
            finish() // Volta para a tela anterior
        }
    }
}
