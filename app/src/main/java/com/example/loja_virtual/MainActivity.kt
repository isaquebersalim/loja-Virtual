package com.example.loja_virtual

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.loja_virtual.data.Product
import com.example.loja_virtual.data.ProductDatabase
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val editNome = findViewById<TextInputEditText>(R.id.edit_nome)
        val editCodigo = findViewById<TextInputEditText>(R.id.edit_codigo)
        val editPreco = findViewById<TextInputEditText>(R.id.edit_preco)
        val editQuantidade = findViewById<TextInputEditText>(R.id.edit_quantidade)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        val btnVerLista = findViewById<Button>(R.id.btn_ver_lista)

        val db = ProductDatabase.getDatabase(this)

        btnSalvar.setOnClickListener {
            val nome = editNome.text.toString()
            val codigo = editCodigo.text.toString()
            val precoStr = editPreco.text.toString()
            val qtdStr = editQuantidade.text.toString()

            // Validações
            if (nome.isEmpty() || codigo.isEmpty() || precoStr.isEmpty() || qtdStr.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val preco = precoStr.toDoubleOrNull() ?: 0.0
            val quantidade = qtdStr.toIntOrNull() ?: 0

            if (preco <= 0) {
                Toast.makeText(this, "Preço deve ser positivo!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (quantidade <= 0) {
                Toast.makeText(this, "Quantidade deve ser um inteiro positivo!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Salvar no Room
            val product = Product(name = nome, code = codigo, price = preco, quantity = quantidade)
            
            lifecycleScope.launch {
                db.productDao().insert(product)
                Toast.makeText(this@MainActivity, "Produto salvo com sucesso!", Toast.LENGTH_SHORT).show()
                
                // Limpar campos
                editNome.text?.clear()
                editCodigo.text?.clear()
                editPreco.text?.clear()
                editQuantidade.text?.clear()
            }
        }

        btnVerLista.setOnClickListener {
            val intent = Intent(this, ListagemActivity::class.java)
            startActivity(intent)
        }
    }
}
