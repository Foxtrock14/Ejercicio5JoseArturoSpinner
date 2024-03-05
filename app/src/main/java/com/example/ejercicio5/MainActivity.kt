package com.example.ejercicio5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{

    lateinit var txtTitulo: TextView
    lateinit var spLenguaje: Spinner
    lateinit var txtDescripcion: TextView
    val lenguaje = arrayOf("PHP", "JAVA", "KOTLIN", "JAVASCRIPT", "RUBY", "C", "SWIFT")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtTitulo = findViewById(R.id.txtTitulo)
        spLenguaje = findViewById(R.id.spLenguaje)
        txtDescripcion = findViewById(R.id.txtDescripcion)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item,lenguaje)
        spLenguaje.adapter = adaptador
        spLenguaje.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.v("App Spinner", "Seleccionaste uno $position")
        val lenguajes = lenguaje[position]
        Log.w("App Spinner" , "$lenguajes")
        txtTitulo.text = lenguajes

        val descripcion = when(lenguajes){
            "PHP" -> "Es un lenguaje para el backend de las paginas"
            "JAVA" -> "Java es una plataforma informática de lenguaje de programación creada por Sun Microsystems en 1995. "
            "KOTLIN" -> "Kotlin es un lenguaje de programación multiplataforma, estáticamente tipado, de alto nivel y propósito general con inferencia de tipos. "
            "JAVASCRIPT" -> "JavaScript es un lenguaje de programación interpretado, dialecto del estándar ECMAScript. Se define como orientado a objetos, basado en prototipos, imperativo, débilmente tipado y dinámico."
            "RUBY" -> "Ruby es un lenguaje de programación dinámico y de código abierto. Fue creado por el programador japonés Yukihiro Matsumoto en 1995"
            "C" -> "C es un lenguaje de programación dinámico y de código abierto. Fue creado por el programador Dennis Ritchie entre 1969 y 1972 en los Laboratorios Bell."
            "SWIFT" -> "Swift es un lenguaje de programación multiparadigma creado por Apple. Está enfocado en el desarrollo de aplicaciones para iOS y macOS"
            else -> "No se ha definido"
        }
        txtDescripcion.text = descripcion
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}