package com.example.investeasy

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.investeasy.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btncalcular.setOnClickListener{

          val aporte = binding.tieaporte.text.toString().toDoubleOrNull() ?: 0.0
          val meses = binding.txtmeses.text.toString().toIntOrNull() ?: 0
          val juros = binding.txtjuros.text.toString().toDoubleOrNull() ?: 0.0



            val taxadejuros = juros/100
            val montante = aporte * Math.pow( 1 + taxadejuros, meses.toDouble())
            val lucro = montante - aporte


            val formatoBR = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
            val totalFormatado = formatoBR.format(montante)
            val lucroFormatado = formatoBR.format(lucro)

            binding.tvtotal.text = ("$totalFormatado")
            binding.tvjuros.text = "$lucroFormatado"


        }
          binding.btnlimpar.setOnClickListener{
              binding.tieaporte.setText("")
              binding.txtmeses.setText("")
              binding.txtjuros.setText("")

              binding.tvtotal.text = "0.0"
              binding.tvjuros.text = "0.0"


              Toast.makeText(this,"Valores limpos com sucesso!", Toast.LENGTH_LONG ).show()
          }

    }


    }
