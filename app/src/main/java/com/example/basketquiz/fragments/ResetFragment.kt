package com.example.basketquiz.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.basketquiz.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class ResetFragment : Fragment(R.layout.reset_fragment) {

    private lateinit var email: TextInputEditText

    private lateinit var resetPassword: AppCompatButton
    private lateinit var goBackButton: AppCompatButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        email = view.findViewById(R.id.EmailEditText)

        resetPassword = view.findViewById(R.id.ResetPasswordButton)
        goBackButton = view.findViewById(R.id.GoBackButtonReset)

        resetPassword.setOnClickListener {

            val email = email.text.toString()

            if (!email.contains("@")) {
                Toast.makeText(context, "შეიყავენთ მეილი სწორად", Toast.LENGTH_SHORT).show()
            } else {

                FirebaseAuth.getInstance()
                    .sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->

                        if (activity == null) return@addOnCompleteListener

                        if (task.isSuccessful) {
                            Toast.makeText(context, "შეამოწმეთ მეილი", Toast.LENGTH_SHORT).show()
                            findNavController().navigate(ResetFragmentDirections.actionResetFragmentToLoginFragment())
                        } else {
                            Toast.makeText(context, "დაფიქსირდა შეცდომა", Toast.LENGTH_SHORT).show()
                        }
                    }

            }


        }

        goBackButton.setOnClickListener {

            findNavController().navigate(ResetFragmentDirections.actionResetFragmentToLoginFragment())

        }


    }
}