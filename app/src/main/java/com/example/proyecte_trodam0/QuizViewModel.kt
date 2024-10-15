package com.example.proyecto_trodam0

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyecto_trodam0.api.ApiService
import com.example.proyecto_trodam0.api.QuestionResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuizViewModel : ViewModel() {

    private val _questions = MutableLiveData<List<QuestionResponse>>()
    val questions: LiveData<List<QuestionResponse>> get() = _questions

    private val apiService: ApiService by lazy {
        // Inicializa Retrofit para crear ApiService
        val retrofit = Retrofit.Builder()
            .baseUrl("http://a23hashusraf.dam.inspedralbes.cat:27777") // Cambia esto a tu IP o dominio
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiService::class.java)
    }

    fun fetchQuestions() {
        apiService.getQuestions().enqueue(object : Callback<List<QuestionResponse>> {
            override fun onResponse(call: Call<List<QuestionResponse>>, response: Response<List<QuestionResponse>>) {
                if (response.isSuccessful) {
                    _questions.value = response.body() // Asigna las preguntas recibidas
                }
            }

            override fun onFailure(call: Call<List<QuestionResponse>>, t: Throwable) {
                // Manejar el error
            }
        })
    }
}
