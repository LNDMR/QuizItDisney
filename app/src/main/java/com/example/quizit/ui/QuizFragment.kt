package com.example.quizit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.quizit.QuizViewModel
import com.example.quizit.databinding.FragmentQuizBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class QuizFragment : Fragment() {

    private lateinit var binding: FragmentQuizBinding

    // if ViewModel already exists take it, else create new ViewModel
    private val viewModel: QuizViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuizBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        updateUi()

        binding.trueButton.setOnClickListener {
            viewModel.checkAnswer(true)
            // Toast.makeText(this, viewModel.result, Toast.LENGTH_SHORT)
            //     .show()
            updateUi()
        }

        binding.falseButton.setOnClickListener {
            viewModel.checkAnswer(false)
            // Toast.makeText(this, viewModel.result, Toast.LENGTH_SHORT)
            //     .show()
            updateUi()
        }
    }

    private fun updateUi() {
        binding.questionText.text = viewModel.currentQuestion.question

        if(viewModel.quantity == 0) {
            showEndDiaglos()
        }
    }

    private fun showEndDiaglos() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Good job!")
            .setMessage("You are amazing.\nYou have answered ${viewModel.score} out of ${viewModel.totalQuantity} questions correctly!")
            .setCancelable(false)
            .setNegativeButton("exit") {_,_->
                activity?.finish()
            }
            .setPositiveButton("repeat") {_,_->
                viewModel.restartGame()
                updateUi()
            }
            .show()
    }
}

