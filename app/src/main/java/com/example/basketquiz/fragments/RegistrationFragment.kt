package com.example.basketquiz.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.basketquiz.R
import com.example.basketquiz.User.User
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class RegistrationFragment : Fragment(R.layout.registration_fragment) {

    private lateinit var userEmail: TextInputEditText
    private lateinit var userPassword: TextInputEditText
    private lateinit var userConfirmPassword: TextInputEditText
    private lateinit var userName: TextInputEditText
    private lateinit var userLastName: TextInputEditText
    private lateinit var userAge: TextInputEditText
    private lateinit var userImageUrl: TextInputEditText

    private lateinit var registrationButton: AppCompatButton
    private lateinit var goBackButton: AppCompatButton

    private lateinit var dataBase: DatabaseReference
    private lateinit var auth: FirebaseAuth



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userName = view.findViewById(R.id.NameEditText)
        userLastName = view.findViewById(R.id.LastNameEditText)
        userEmail = view.findViewById(R.id.RegisterEmailEditText)
        userPassword = view.findViewById(R.id.RegisterPasswordEditText)
        userConfirmPassword = view.findViewById(R.id.ConfirmRegisterPasswordEditText)
        userAge = view.findViewById(R.id.UserAgeEditText)
        userImageUrl = view.findViewById(R.id.UserImageUrlEditText)

        registrationButton = view.findViewById(R.id.RegistrationButton)
        goBackButton = view.findViewById(R.id.GoBackButton)


        registrationButton.setOnClickListener {

            val name = userName.text.toString()
            val lastName = userLastName.text.toString()
            val email = userEmail.text.toString()
            val password = userPassword.text.toString()
            val confirmPassword = userConfirmPassword.text.toString()
            val age = userAge.text.toString()
            val image = userImageUrl.text.toString()

            dataBase = FirebaseDatabase.getInstance().getReference("Users")
            auth = FirebaseAuth.getInstance()

            val User = User(name, lastName, email, age, image, easyScore = 0, mediumScore = 0, hardScore = 0)


            if (name.isEmpty()) {
                Toast.makeText(context, "გთხოვთ შეიყვანოთ სახელი", Toast.LENGTH_SHORT).show()
            } else if (lastName.isEmpty()) {
                Toast.makeText(context, "გთხოვთ შეიყვანოთ გვარი", Toast.LENGTH_SHORT).show()
            } else if (age.isEmpty()) {
                Toast.makeText(context, "გთხოვთ შეიყვანოთ ასაკი", Toast.LENGTH_SHORT).show()
            } else if (!email.contains("@")) {
                Toast.makeText(context, "გთხოვთ შეიყვანოთ მეილი სწორად", Toast.LENGTH_SHORT).show()
            } else if (!confirmPassword.contains(password) || password.length <= 7) {
                Toast.makeText(context, "გთხოვთ შეიყვანოთ პაროლი სწორად", Toast.LENGTH_SHORT).show()
            } else {

                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            dataBase.child(auth.currentUser?.uid!!).setValue(User)

                            if (activity == null) return@addOnCompleteListener

                            findNavController().navigate(RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment())

                        } else {

                            Toast.makeText(context, "დაფიქსირდა შეცდომა", Toast.LENGTH_SHORT).show()

                        }

                    }

            }


        }

        goBackButton.setOnClickListener {

            findNavController().navigate(RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment())

        }



    }
}