package com.example.quizit.data

import com.example.quizit.data.model.Question

class QuizRepository {

    fun loadQuestions(): List<Question> {
        val questionList = listOf(
            Question("Mulan is set in Japan.", false),
            Question("Ursula is a character in ‘Cinderella’.", false),
            Question("Mufasa is Simba’s uncle.", false),
            Question("The Little Mermaid is called Ariel.", true),
            Question("Jiminy Cricket is a character in Pinocchio.", true),
            Question("Tinker Bell is a human girl.", false),
            Question("Belle’s dress in ‘Beauty and the Beast’ is blue.", false),
            Question("The carriage in Cinderella initially is a pumpkin.", true),
            Question("Geppetto is Peter Pan’s dad.", false),
            Question("Bambi was released in the 40s.", true)
        )

       //Mulan is set in Japan. False, it’s set in China
       //Ursula is a character in ‘Cinderella’. False, in the little Mermaid
       //Mufasa is Simba’s uncle. False, he is his dad.
       //The Little Mermaid is called Ariel. True
       //Jiminy Cricket is a character in Pinocchio. True
       //Tinker Bell is a human girl. False, she is a fairy
       //Belle’s dress in ‘Beauty and the Beast’ is blue. False, it’s yellow
       //The carriage in Cinderella initially is a pumpkin. True
       //Geppetto is Peter Pan’s dad. False, it’s Pinocchio’s
       //Bambi was released in the 40s. True

        return questionList

    }
}
