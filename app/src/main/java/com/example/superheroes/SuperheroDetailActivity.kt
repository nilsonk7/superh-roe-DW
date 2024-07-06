package com.example.superheroes

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.superheroes.databinding.ActivitySuperheroDetailBinding
import com.squareup.picasso.Picasso

class SuperheroDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperheroDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperheroDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener los datos del intent
        val name = intent.getStringExtra("name")
        val realName = intent.getStringExtra("realName")
        val publisher = intent.getStringExtra("publisher")
        val photo = intent.getStringExtra("photo")
        val description = intent.getStringExtra("description")

        // Configurar la vista con los datos
        binding.tvSuperheroName.text = name
        binding.tvRealName.text = realName
        binding.tvPublisher.text = publisher
        binding.tvDescription.text = description
        Picasso.get()
            .load(photo)
            .transform(CircleTransform())
            .into(binding.ivAvatar)
    }

    // Método para el botón de retorno
    fun onReturnClick(view: View) {
        finish()
    }
}
