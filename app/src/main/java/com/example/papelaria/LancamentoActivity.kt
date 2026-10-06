package com.example.papelaria

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class LancamentoActivity : AppCompatActivity() {
    private lateinit var edtCod: EditText
    private lateinit var edtQuant: EditText
    private lateinit var edtValor: EditText
    private lateinit var edtDesconto: EditText

    private val resultadoLista = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { resultado ->
        if (resultado.resultCode == RESULT_OK) {
            val codigo = resultado.data?.getIntExtra("cod", 0) ?: 0
            if (codigo in 1..5) edtCod.setText(codigo.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lancamento)

        edtCod = findViewById(R.id.edtCod)
        edtQuant = findViewById(R.id.edtQuant)
        edtValor = findViewById(R.id.edtValor)
        edtDesconto = findViewById(R.id.edtDesconto)
    }

    fun btnListarOnClick(view: View) {
        resultadoLista.launch(Intent(this, ListarActivity::class.java))
    }

    fun btnConfirmarOnClick(view: View) {
        val codigo = edtCod.text.toString().trim()
        val quantidade = edtQuant.text.toString().trim()
        val valor = edtValor.text.toString().trim()
        val desconto = edtDesconto.text.toString().trim()

        val codigoNumero = codigo.toIntOrNull()
        if (codigoNumero == null || codigoNumero !in 1..5) {
            edtCod.error = getString(R.string.erro_codigo)
            edtCod.requestFocus()
            return
        }

        val quantidadeNumero = quantidade.toIntOrNull()
        if (quantidadeNumero == null || quantidadeNumero <= 0) {
            edtQuant.error = getString(R.string.erro_quantidade)
            edtQuant.requestFocus()
            return
        }

        val valorNumero = valor.toDoubleOrNull()
        if (valorNumero == null || !valorNumero.isFinite() || valorNumero <= 0.0) {
            edtValor.error = getString(R.string.erro_valor)
            edtValor.requestFocus()
            return
        }

        val descontoNumero = desconto.toDoubleOrNull()
        if (descontoNumero == null || !descontoNumero.isFinite() || descontoNumero !in 0.0..100.0) {
            edtDesconto.error = getString(R.string.erro_desconto)
            edtDesconto.requestFocus()
            return
        }

        val intent = Intent(this, ConfirmarActivity::class.java).apply {
            putExtra("cod", codigo)
            putExtra("quant", quantidade)
            putExtra("valor", valor)
            putExtra("desconto", desconto)
        }
        startActivity(intent)
    }
}
