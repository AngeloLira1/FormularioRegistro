package com.example.formularioregistro

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.formularioregistro.databinding.ActivityMainBinding
import kotlin.toString

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Evento 1: Validar, guardar en ViewModel y navegar
        binding.btnEnviar.setOnClickListener {
            val textoIngresado = binding.etNombre.text.toString().trim()
            val textoIngresado2 = binding.etApellido.text.toString().trim()
            val textoIngresado3 = binding.etEdad.text.toString().trim()


            if (textoIngresado.isEmpty()) {
                // USO DE TOAST: Mensaje rápido si el campo está vacío
                Toast.makeText(this, "Por favor, escribe un nombre",
                    Toast.LENGTH_SHORT).show()
                }
            if (textoIngresado2.isEmpty()){
                // USO DE TOAST: Mensaje rápido si el campo está vacío
                Toast.makeText(this, "Por favor, escribe un apellido",
                    Toast.LENGTH_SHORT).show()
            }
            if (textoIngresado3.isEmpty()){
                Toast.makeText(this, "Por favor, escribe una edad",
                    Toast.LENGTH_SHORT).show()
            }
            else {
                viewModel.nombreUsuario = textoIngresado
                viewModel.apellidoUsuario=textoIngresado2
                viewModel.edadUsuario=textoIngresado3
                val intent = Intent(this, DetailActivity::class.java).apply {
                    putExtra("CLAVE_NOMBRE", viewModel.nombreUsuario)
                    putExtra("CLAVE_APELLIDO",viewModel.apellidoUsuario)
                    putExtra("CLAVE_EDAD", viewModel.edadUsuario)
                }
                startActivity(intent)
            }
        }




    }
}