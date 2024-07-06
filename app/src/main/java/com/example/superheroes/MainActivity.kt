package com.example.superheroes

import android.os.Build.VERSION_CODES.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpRecyclerView()
    }

    // Función para obtener la lista de superhéroes con descripciones extendidas
    private fun getSuperheros(): MutableList<Superhero> {
        val superheros: MutableList<Superhero> = ArrayList()

        // Añadir superhéroes a la lista con las URLs actualizadas
        superheros.add(Superhero(
            "Hulk",
            "Marvel",
            "Mark Ruffalo",
            "https://th.bing.com/th?id=OIF.W4WL4f4vqf%2b3bu0K2DS%2b1w&w=273&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",
            "Hulk: Millonario con habilidades detectivescas y combate, protege Gotham City sin poderes sobrenaturales.un ser humanoide enorme de piel verde, corpulento y musculoso que posee una gran fortaleza física, y su alter ego."
        ))
        superheros.add(Superhero(
            "Bruja Escarlata",
            "DC",
            "Elizabeth Olsen",
            "https://th.bing.com/th/id/OIP.98T_eTAQvhdyahotG1GnnQHaEK?w=277&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",
            "Bruja Escarlata: utilizó sus poderes y exterminó a toda la multitud ante la mirada horrorizada de su esposa, Magda, la cual huyó de su marido hacia la pequeña Nación de Transia en los Montes Balcanes, estando ya embarazada de mellizos. Magda dio a luz en la Montaña Wundagore."
        ))
        superheros.add(Superhero(
            "Loki",
            "Marvel",
            "Tom Hiddleston",
            "https://th.bing.com/th/id/OIP.y2OTkOs9lfM7565OL7NQrwHaJR?w=206&h=258&c=7&r=0&o=5&dpr=1.3&pid=1.7",
            "Loki: A lo largo de su infancia y en la adolescencia, Loki estaba resentido por las diferencias en las que él y Thor fueron tratados por los ciudadanos de Asgard. Los asgardianos valoraban la gran fuerza, tenacidad y valentía en la batalla por encima de todas las cosas, y Loki era claramente inferior a su hermano Thor en esas áreas."
        ))
        superheros.add(Superhero(
            "Spiderman",
            "Marvel",
            "Peter Parker",
            "https://th.bing.com/th/id/OIP.emhB84-CDmhww-0YmiRLlAHaEK?w=327&h=184&c=7&r=0&o=5&dpr=1.3&pid=1.7",
            "Spider-Man: Un héroe adolescente con habilidades arácnidas y un sentido de responsabilidad, lucha contra el crimen en Nueva York."
        ))
        superheros.add(Superhero(
            "Daredevil",
            "Marvel",
            "Matthew Michael Murdock",
            "https://th.bing.com/th/id/OIP.U2YwrG52CSwcH6iyfbmukgHaLA?w=205&h=304&c=7&r=0&o=5&dpr=1.3&pid=1.7",
            "Daredevil: Abogado ciego con sentidos amplificados, combate la injusticia en Hell's Kitchen, Nueva York, con habilidades acrobáticas y artes marciales."
        ))
        superheros.add(Superhero(
            "Wolverine",
            "Marvel",
            "James Howlett",
            "https://th.bing.com/th/id/OIP.xBJ0ozs26b3uUVA7WaHV0gHaEK?w=298&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",
            "Wolverine: Mutante con garras retráctiles y capacidad de regeneración, conocido por su naturaleza salvaje y moral ambigua."
        ))
        superheros.add(Superhero(
            "Batman",
            "DC",
            "Bruce Wayne",
            "https://th.bing.com/th/id/OIP.tI44rujibgrgL9X8jvZz-wHaFj?w=1400&h=1050&rs=1&pid=ImgDetMain",
            "Batman: Millonario con habilidades detectivescas y combate, protege Gotham City sin poderes sobrenaturales."
        ))
        superheros.add(Superhero(
            "Flash",
            "DC",
            "Jay Garrick",
            "https://th.bing.com/th/id/R.746b31ffd40b7c9bd7f61a2288b4bdb0?rik=PzvXjnPm9Fbz%2fQ&pid=ImgRaw&r=0",
            "Flash: Velocista con la capacidad de moverse a velocidades supersónicas y manipular el tiempo."
        ))
        superheros.add(Superhero(
            "Thor",
            "Marvel",
            "Thor Odinson",
            "https://th.bing.com/th/id/OIP.2-myfDbGsAtWj40xjuV0FgHaFj?w=239&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",
            "Thor: Príncipe asgardiano con poderes de manipulación de truenos y fuerza sobrehumana, defensor de los Nueve Reinos."
        ))
        superheros.add(Superhero(
            "Green Lantern",
            "DC",
            "Alan Scott",
            "https://th.bing.com/th/id/OIP.0z0ZqBaWI8yzwpxZUJsOUwHaEo?w=250&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",
            "Green Lantern: Guardián del universo con un anillo que crea manifestaciones de luz basadas en la fuerza de voluntad."
        ))
        superheros.add(Superhero(
            "Wonder Woman",
            "DC",
            "Princess Diana",
            "https://th.bing.com/th/id/OIP.TEw3MesPFRsnMglW31i2FAHaHa?w=187&h=187&c=7&r=0&o=5&dpr=1.3&pid=1.7",
            "Wonder Woman: Princesa amazona con fuerza sobrehumana, habilidades de combate avanzadas y una determinación imparable."
        ))
        superheros.add(Superhero(
            "Doctor Stranger",
            "Marvel",
            "Peter Hooten",
            "https://tse3.mm.bing.net/th?id=OIP.3lBkYZswoCHKw-cHEUCy6AHaHa&pid=Api&P=0&h=180",
            "Doctor Stranger: se convierte en un practicante tanto de las artes místicas como de las artes marciales. Además de conocer muchos hechizos poderosos, tiene un traje con dos objetos místicos: la Capa de Levitación y el Ojo de Agamotto, que le otorgan poderes adicionales."
        ))

        return superheros
    }

    private fun setUpRecyclerView() {
        val mRecyclerView: RecyclerView = findViewById(R.id.rvSuperheroList)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)

        val mAdapter = RecyclerAdapter(getSuperheros(), this)
        mRecyclerView.adapter = mAdapter
    }
}
