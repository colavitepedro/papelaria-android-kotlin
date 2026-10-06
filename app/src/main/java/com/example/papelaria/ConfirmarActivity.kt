package com.example.papelaria

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.Locale

class ConfirmarActivity : AppCompatActivity() {
    private lateinit var txtCod: TextView
    private lateinit var txtQuant: TextView
    private lateinit var txtValor: TextView
    private lateinit var txtDesconto: TextView
    private lateinit var txtSubtotal: TextView
    private lateinit var txtValorDesconto: TextView
    private lateinit var txtTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmar)

        txtCod = findViewById(R.id.txtCod)
        txtQuant = findViewById(R.id.txtQuant)
        txtValor = findViewById(R.id.txtValor)
        txtDesconto = findViewById(R.id.txtDesconto)
        txtSubtotal = findViewById(R.id.txtSubtotal)
        txtValorDesconto = findViewById(R.id.txtValorDesconto)
        txtTotal = findViewById(R.id.txtTotal)

        txtCod.text = intent.getStringExtra("cod").orEmpty()
        txtQuant.text = intent.getStringExtra("quant").orEmpty()
        txtValor.text = intent.getStringExtra("valor").orEmpty()
        txtDesconto.text = intent.getStringExtra("desconto").orEmpty()
    }

    fun btnCalcularOnClick(view: View) {
        val quantidade = txtQuant.text.toString().toIntOrNull() ?: return
        val valorUnitario = txtValor.text.toString().toDoubleOrNull() ?: return
        val percentualDesconto = txtDesconto.text.toString().toDoubleOrNull() ?: return
        val subtotal = quantidade * valorUnitario
        val valorDesconto = subtotal * percentualDesconto / 100.0
        val total = subtotal - valorDesconto
        val formatoMoeda = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"))

        txtSubtotal.text = formatoMoeda.format(subtotal)
        txtValorDesconto.text = formatoMoeda.format(valorDesconto)
        txtTotal.text = formatoMoeda.format(total)
    }
}
