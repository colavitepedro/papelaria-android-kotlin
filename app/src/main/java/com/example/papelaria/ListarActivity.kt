package com.example.papelaria

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)

        val lvMateriais = findViewById<ListView>(R.id.lvMateriais)
        lvMateriais.setOnItemClickListener { _, _, posicao, _ ->
            val codigo = posicao + 1
            val dados = Intent().putExtra("cod", codigo)
            setResult(RESULT_OK, dados)
            finish()
        }
    }
}
