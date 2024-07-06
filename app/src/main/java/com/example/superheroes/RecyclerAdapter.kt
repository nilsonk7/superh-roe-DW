package com.example.superheroes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerAdapter(private val superheroes: MutableList<Superhero>, private val context: Context) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_superhero_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val superhero = superheroes[position]
        holder.bind(superhero, context)
    }

    override fun getItemCount(): Int {
        return superheroes.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val superheroName: TextView = itemView.findViewById(R.id.tvSuperhero)
        private val realName: TextView = itemView.findViewById(R.id.tvRealName)
        private val publisher: TextView = itemView.findViewById(R.id.tvPublisher)
        private val avatar: ImageView = itemView.findViewById(R.id.ivAvatar)

        private lateinit var superhero: Superhero

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(superhero: Superhero, context: Context) {
            this.superhero = superhero
            superheroName.text = superhero.name
            realName.text = superhero.realName
            publisher.text = superhero.publisher
            Picasso.get().load(superhero.photo).into(avatar)
        }

        override fun onClick(v: View?) {
            val intent = Intent(context, SuperheroDetailActivity::class.java).apply {
                putExtra("name", superhero.name)
                putExtra("realName", superhero.realName)
                putExtra("publisher", superhero.publisher)
                putExtra("photo", superhero.photo)
                putExtra("description", superhero.description)
            }
            context.startActivity(intent)
        }
    }
}
