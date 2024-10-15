package com.example.proyecto_trodam0.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.proyecto_trodam0.QuizViewModel
import com.example.proyecto_trodam0.api.QuestionResponse


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(viewModel: QuizViewModel = viewModel()) {
    val questions by viewModel.questions.observeAsState(initial = emptyList()) // Asegúrate de usar 'initial'

    LaunchedEffect(Unit) {
        viewModel.fetchQuestions()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Quiz App") },
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (questions.isEmpty()) {
                BasicText("Cargando preguntas...")
            } else {
                for (question in questions) {
                    QuestionItem(question)
                }

                // Botón para enviar respuestas
                Button(
                    onClick = {
                        // Aquí puedes agregar la lógica para enviar las respuestas
                    },
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text("Enviar Respuestas")
                }
            }
        }
    }
}

@Composable
fun QuestionItem(question: QuestionResponse) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = question.pregunta,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Start
        )

        question.respostes.forEach { answer ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Implementa la lógica para mostrar respuestas
            }
        }
    }
}
