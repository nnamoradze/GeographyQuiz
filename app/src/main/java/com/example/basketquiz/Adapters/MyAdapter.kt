package com.example.basketquiz.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basketquiz.Extensions.setImage
import com.example.basketquiz.R
import com.example.basketquiz.User.User

class MyAdapter(private val userList: ArrayList<User>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.admin_info,parent,false)
        return MyViewHolder(itemView)

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = userList[position]

        holder.name.text = currentItem.name
        holder.lastName.text = currentItem.lastName
        holder.email.text = "${currentItem.email}"
        holder.age.text = "ასაკი ${currentItem.age}"
        holder.easyScore.text = "მარტივი ${currentItem.easyScore}"
        holder.mediumScore.text = "საშუალო ${currentItem.mediumScore}"
        holder.hardScore.text = "რთული ${currentItem.hardScore}"

        holder.image.setImage(currentItem.imageUrl)

    }

    override fun getItemCount() = userList.size


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView = itemView.findViewById(R.id.userNameFromData)
        val lastName: TextView = itemView.findViewById(R.id.userLastNameFromData)
        val email: TextView = itemView.findViewById(R.id.userEmailFromData)
        val age: TextView = itemView.findViewById(R.id.userAgeFromData)
        val easyScore: TextView = itemView.findViewById(R.id.userEasyScoreFromData)
        val mediumScore: TextView = itemView.findViewById(R.id.userMediumScoreFromData)
        val hardScore: TextView = itemView.findViewById(R.id.userHardScoreFromData)

        val image: ImageView = itemView.findViewById(R.id.imageView2)

    }

}
