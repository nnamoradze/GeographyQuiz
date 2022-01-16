package com.example.basketquiz.fragments

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.basketquiz.MainActivity
import com.example.basketquiz.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment(R.layout.login_fragment) {

    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText

    private lateinit var resetPassword: TextView

    private lateinit var loginButton: AppCompatButton
    private lateinit var registrationButton: AppCompatButton


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emailEditText = view.findViewById(R.id.EmailEditText)
        passwordEditText = view.findViewById(R.id.PasswordEditText)

        resetPassword = view.findViewById(R.id.ResetPasswordTextView)

        loginButton = view.findViewById(R.id.LoginButton)
        registrationButton = view.findViewById(R.id.RegistrationButton)


        val instaButton = view.findViewById<AppCompatButton>(R.id.instaButton)
        val fbButton = view.findViewById<AppCompatButton>(R.id.fbButton)

        instaButton.setOnClickListener {

            val url = Uri.parse("https://www.instagram.com/n_namoradze/")
            val instagram = Intent(Intent.ACTION_VIEW, url)
            instagram.setPackage("com.instagram.android")

            try {
                startActivity(instagram)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.instagram.com/n_namoradze/")
                    )
                )
            }

        }

        fbButton.setOnClickListener {

            val url2 = Uri.parse("https://www.facebook.com/profile.php?id=100008606868981")
            val facebook = Intent(Intent.ACTION_VIEW, url2)
            facebook.setPackage("com.facebook.android")

            try {
                startActivity(facebook)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.facebook.com/profile.php?id=100008606868981")
                    )
                )
            }

        }


        loginButton.setOnClickListener {

            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()


            if (email.isEmpty() || !email.contains("@")) {
                Toast.makeText(context, "გთხოვთ შეიყვანოთ მეილი ", Toast.LENGTH_SHORT).show()
            } else if (password.isEmpty() || password.length <= 7) {
                Toast.makeText(context, "გთხოვთ შეიყვანოთ პაროლი სწორად", Toast.LENGTH_SHORT).show()
            } else if (email == "admin@admin" && password == "admin123") {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToAdminFragment())
            } else {


                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->

                        if (activity == null) return@addOnCompleteListener

                        if (task.isSuccessful) {
                            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToLevelsFragment())
                        }

                    }
            }

            val activity = requireActivity() as? MainActivity
            activity?.hideNavBar()

        }



        registrationButton.setOnClickListener {

            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegistrationFragment())

            val activity = requireActivity() as? MainActivity
            activity?.hideNavBar()

        }

        resetPassword.setOnClickListener {

            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToResetFragment())

            val activity = requireActivity() as? MainActivity
            activity?.hideNavBar()

        }


    }


}

