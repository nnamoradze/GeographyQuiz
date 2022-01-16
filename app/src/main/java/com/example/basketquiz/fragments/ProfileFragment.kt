package com.example.basketquiz.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.basketquiz.Extensions.setImage
import com.example.basketquiz.MainActivity
import com.example.basketquiz.R
import com.example.basketquiz.User.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ProfileFragment : Fragment(R.layout.profile_fragment) {

    private lateinit var easyScore: TextView
    private lateinit var mediumScore: TextView
    private lateinit var hardScore: TextView
    private lateinit var changePass: AppCompatButton
    private lateinit var logOut: AppCompatButton

    private lateinit var userImage: ImageView

    private lateinit var dataBase: DatabaseReference
    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        easyScore = view.findViewById(R.id.easyScore)
        mediumScore = view.findViewById(R.id.mediumScore)
        hardScore = view.findViewById(R.id.hardScore)

        changePass = view.findViewById(R.id.changePassword)

        userImage = view.findViewById(R.id.imageView)

        logOut = view.findViewById(R.id.LogOut)


        dataBase = FirebaseDatabase.getInstance().getReference("Users")
        auth = FirebaseAuth.getInstance()

        dataBase.child(auth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener{
            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {

                val userInfo = snapshot.getValue(User::class.java) ?: return

                if (activity == null) {
                    return
                }


                userImage.setImage(userInfo.imageUrl)

                easyScore.text = "თქვენი უმაღლესი ქულა მარტივ ტესტში არის ${userInfo.easyScore}"
                mediumScore.text = "თქვენი უმაღლესი ქულა საშუალო ტესტში არის ${userInfo.mediumScore}"
                hardScore.text = "თქვენი უმაღლესი ქულა რთულ ტესტში არის ${userInfo.hardScore}"

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })


        changePass.setOnClickListener {

            findNavController().navigate(ProfileFragmentDirections.actionProfileFragment2ToChangePasswordFragment())

            val activity = requireActivity() as? MainActivity
            activity?.hideNavBar()

        }

        logOut.setOnClickListener {

            auth.signOut()
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragment2ToLoginFragment())

            val activity = requireActivity() as? MainActivity
            activity?.hideNavBar()

        }

        val activity = requireActivity() as? MainActivity
        activity?.showNavBar()

    }
}