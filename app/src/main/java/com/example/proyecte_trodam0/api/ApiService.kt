package com.example.proyecto_trodam0.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

// Clase de datos para las preguntas
data class QuestionResponse(
    val id: Int,
    val pregunta: String,
    val imatge: String,
    val resposta_correcta: Int,
    val respostes: List<Response>
)

data class Response(
    val id: Int,
    val etiqueta: String
)

interface ApiService {
    // Método para enviar respuestas al servidor
    @POST("/api/respostes")
    fun submitAnswers(@Body answers: Map<String, Any>): Call<Void>

    // Método para obtener preguntas del servidor
    @GET("/api/preguntes")
    fun getQuestions(): Call<List<QuestionResponse>>
}
