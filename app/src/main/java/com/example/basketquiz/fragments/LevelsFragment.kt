package com.example.basketquiz.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.basketquiz.MainActivity
import com.example.basketquiz.R

class LevelsFragment:Fragment(R.layout.levels_fragment) {

    private lateinit var easyLevelButton: AppCompatButton
    private lateinit var mediumLevelButton: AppCompatButton
    private lateinit var hardLevelButton: AppCompatButton

    private lateinit var goBackButton: AppCompatButton


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        easyLevelButton = view.findViewById(R.id.easyQuestions)
        mediumLevelButton = view.findViewById(R.id.mediumQuestions)
        hardLevelButton= view.findViewById(R.id.hardQuestions)

        goBackButton = view.findViewById(R.id.GoToRegistration)

        easyLevelButton.setOnClickListener {

            findNavController().navigate(LevelsFragmentDirections.actionLevelsFragmentToEasyQuestionsFragment2())

            val activity = requireActivity() as? MainActivity
            activity?.hideNavBar()

        }

        mediumLevelButton.setOnClickListener {

            findNavController().navigate(LevelsFragmentDirections.actionLevelsFragmentToMediumQuestionsFragment())

            val activity = requireActivity() as? MainActivity
            activity?.hideNavBar()

        }

        hardLevelButton.setOnClickListener {

            findNavController().navigate(LevelsFragmentDirections.actionLevelsFragmentToHardQuestionsFragment())

            val activity = requireActivity() as? MainActivity
            activity?.hideNavBar()

        }


        goBackButton.setOnClickListener {

            findNavController().navigate(LevelsFragmentDirections.actionLevelsFragmentToLoginFragment())

            val activity = requireActivity() as? MainActivity
            activity?.hideNavBar()

        }

        val activity = requireActivity() as? MainActivity
        activity?.showNavBar()


    }


}