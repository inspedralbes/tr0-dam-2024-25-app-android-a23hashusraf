package com.example.proyecte_trodam0.model

data class Resposta(
    val id: Int,
    val etiqueta: String
)

data class Question(
    val id: Int,
    val pregunta: String,
    val imatge: String?,
    val resposta_correcta: Int,
    val respostes: List<Resposta>
)
