package com.example.basketquiz.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.basketquiz.MainActivity
import com.example.basketquiz.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ChangePasswordFragment:Fragment(R.layout.change_password_fragment) {

    private lateinit var newPassword: TextInputEditText
    private lateinit var confirmNewPassword: TextInputEditText

    private lateinit var changePassword: AppCompatButton

    private lateinit var goBackToProfileButton: AppCompatButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        newPassword = view.findViewById(R.id.NewPasswordEditText)
        confirmNewPassword = view.findViewById(R.id.ConfirmNewPasswordEditText)

        changePassword = view.findViewById(R.id.ChangePassword)

        goBackToProfileButton = view.findViewById(R.id.goBackToProfile)


        changePassword.setOnClickListener {

            val newPass = newPassword.text.toString()
            val confirmNewPass = confirmNewPassword.text.toString()

            if (newPass.isEmpty() || confirmNewPass.isEmpty()){
                Toast.makeText(context, "შეიყვანეთ პაროლი", Toast.LENGTH_SHORT).show()
            }else if(!confirmNewPass.contains(newPass) || newPass.length <= 7){
                Toast.makeText(context, "შეიყვანეთ პაროლი სწორად", Toast.LENGTH_SHORT).show()
            }else{

                FirebaseAuth.getInstance()
                    .currentUser?.updatePassword(confirmNewPass)
                    ?.addOnCompleteListener { task ->

                        if (activity == null) return@addOnCompleteListener

                        if (task.isSuccessful){
                            Toast.makeText(context, "პაროლი შეცვლილია", Toast.LENGTH_SHORT).show()
                            findNavController().navigate(ChangePasswordFragmentDirections.actionChangePasswordFragmentToProfileFragment2())

                            val activity = requireActivity() as? MainActivity
                            activity?.showNavBar()

                        }else{
                            Toast.makeText(context, "დაფიქსირდა შეცდომა", Toast.LENGTH_SHORT).show()
                        }

                    }

            }


        }

        goBackToProfileButton.setOnClickListener {

            findNavController().navigate(ChangePasswordFragmentDirections.actionChangePasswordFragmentToProfileFragment2())

            val activity = requireActivity() as? MainActivity
            activity?.showNavBar()

        }

    }

}