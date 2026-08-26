package com.example.formularioregistro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.formularioregistro.databinding.ActivityDetailBinding



class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Recuperar el dato enviado en el Intent
        val nombreRecibido = intent.getStringExtra("CLAVE_NOMBRE") ?: "Sin nombre"
        val apellidoRecibido=intent.getStringExtra("CLAVE_APELLIDO")?:"Sin apellido"
        val edadRecibida=intent.getStringExtra("CLAVE_EDAD")?:"Sin edad"
        binding.tvSaludo.text = "Nombre : $nombreRecibido\n Apellido: $apellidoRecibido\n Edad: $edadRecibida "
        }
}
