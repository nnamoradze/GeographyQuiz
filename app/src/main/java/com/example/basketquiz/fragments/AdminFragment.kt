package com.example.basketquiz.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basketquiz.Adapters.MyAdapter
import com.example.basketquiz.R
import com.example.basketquiz.User.User
import com.google.firebase.database.*

class AdminFragment : Fragment(R.layout.admin_fragment) {

    private lateinit var dataBaseReference: DatabaseReference
    private lateinit var adminRecyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<User>

    private lateinit var goBackButton: AppCompatButton


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adminRecyclerView = view.findViewById(R.id.adminRecyclerView)

        adminRecyclerView.layoutManager = LinearLayoutManager(context)

        adminRecyclerView.setHasFixedSize(true)


        userArrayList = arrayListOf<User>()

        getUserInfo()

        goBackButton = view.findViewById(R.id.goBackToLogin)

        goBackButton.setOnClickListener {

            findNavController().navigate(AdminFragmentDirections.actionAdminFragmentToLoginFragment())

        }


    }



    private fun getUserInfo() {

        dataBaseReference = FirebaseDatabase.getInstance().getReference("Users")

        dataBaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if (activity == null) {
                    return
                }

                if (snapshot.exists()) {
                    for (userSnapshot in snapshot.children) {

                        val user = userSnapshot.getValue(User::class.java)
                        userArrayList.add(user!!)
                    }
                    adminRecyclerView.adapter = MyAdapter(userArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })


    }
}