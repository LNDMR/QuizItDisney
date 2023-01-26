package com.example.quizit

import androidx.lifecycle.ViewModel
import com.example.quizit.data.QuizRepository
import com.example.quizit.data.model.Question

class QuizViewModel : ViewModel() {

    // repository is our new datasource
    private val repository = QuizRepository()
    // make it mutable
    private var questions = repository.loadQuestions().toMutableList()

    // read-and-write for ViewModel & read-only for fragment
    private var _score = 0
    val score: Int
        get() = _score

    // read-and-write for ViewModel & read-only for fragment
    private var _quantity = questions.size
    val quantity: Int
        get() = _quantity

    val totalQuantity = questions.size
    var result: String = " "

    // read-and-write for ViewModel & read-only for fragment
    private var _currentQuestion = questions.random()
    val currentQuestion: Question
        get() = _currentQuestion


    fun checkAnswer(isCorrect: Boolean) {
        result = "false"
        if(isCorrect == currentQuestion.isCorrect) {
            _score++
            result = "true"
        }
        getNextQuestion()
    }

    private fun getNextQuestion() {
        if(questions.isEmpty()) {
            questions = repository.loadQuestions().toMutableList()
            _quantity = questions.size
        }

        val nextQuestion = questions.random()
        questions.remove(nextQuestion)
        _quantity--
        _currentQuestion = nextQuestion
    }

    fun restartGame() {
        _score = 0
        getNextQuestion()
    }

}