package com.example.basketquiz.fragments

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.basketquiz.MainActivity
import com.example.basketquiz.R
import com.example.basketquiz.User.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class MediumQuestionsFragment : Fragment(R.layout.medium_questions_fragment) {

    private lateinit var questionTextView: TextView

    private lateinit var questionImageView: ImageView

    private lateinit var answer1: CheckBox
    private lateinit var answer2: CheckBox
    private lateinit var answer3: CheckBox

    private lateinit var dataBase: DatabaseReference
    private lateinit var auth: FirebaseAuth

    var mediumPlayerScore = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questionTextView = view.findViewById(R.id.mediumQuestionTextView)

        questionImageView = view.findViewById(R.id.mediumQuestionImageView)

        answer1 = view.findViewById(R.id.mediumAnswer1)
        answer2 = view.findViewById(R.id.mediumAnswer2)
        answer3 = view.findViewById(R.id.mediumAnswer3)

        dataBase = FirebaseDatabase.getInstance().getReference("Users")
        auth = FirebaseAuth.getInstance()


        questionTextView.text = "რომელი ქვეყნის დროშაა მოცემულ ფოტოზე"
        questionImageView.setImageResource(R.drawable.geo)



        answer1.text = "საქართველო"
        answer2.text = "ინგლისი"
        answer3.text = "რუსეთი"


        answer1.setOnClickListener {
            answer1.isChecked = false
            mediumPlayerScore++
            secondEasyQuestion()
        }

        answer2.setOnClickListener {
            answer2.isChecked = false
            secondEasyQuestion()
        }

        answer3.setOnClickListener {
            answer3.isChecked = false
            secondEasyQuestion()
        }


    }

    private fun secondEasyQuestion() {

        questionTextView.text = "რომელი ქვეყნის დროშაა მოცემულ ფოტოზე"

        questionImageView.setImageResource(R.drawable.usa)

        answer1.text = "მექსიკა"
        answer2.text = "აშშ"
        answer3.text = "მალაიზია"

        answer1.setOnClickListener {
            answer1.isChecked = false
            thirdEasyQuestion()
        }

        answer2.setOnClickListener {
            answer2.isChecked = false
            mediumPlayerScore++
            thirdEasyQuestion()
        }

        answer3.setOnClickListener {
            answer3.isChecked = false
            thirdEasyQuestion()
        }


    }

    private fun thirdEasyQuestion() {

        questionTextView.text = "რომელი ქვეყნის დროშაა მოცემულ ფოტოზე"

        questionImageView.setImageResource(R.drawable.chin)

        answer1.text = "ჩინეთი"
        answer2.text = "ჩილე"
        answer3.text = "მონაკო"

        answer1.setOnClickListener {
            answer1.isChecked = false
            mediumPlayerScore++
            fourthEasyQuestion()
        }

        answer2.setOnClickListener {
            answer2.isChecked = false
            fourthEasyQuestion()
        }

        answer3.setOnClickListener {
            answer3.isChecked = false
            fourthEasyQuestion()
        }

    }

    private fun fourthEasyQuestion() {
        questionTextView.text = "რომელი ქვეყნის დროშაა მოცემულ ფოტოზე"

        questionImageView.setImageResource(R.drawable.mexic)

        answer1.text = "კანადა"
        answer2.text = "იაპონია"
        answer3.text = "მექსიკა"

        answer1.setOnClickListener {
            answer1.isChecked = false
            fifthEasyQuestion()
        }

        answer2.setOnClickListener {
            answer2.isChecked = false
            fifthEasyQuestion()
        }

        answer3.setOnClickListener {
            answer3.isChecked = false
            mediumPlayerScore++
            fifthEasyQuestion()
        }
    }

    private fun fifthEasyQuestion() {

        questionTextView.text = "რომელი ქვეყნის დროშაა მოცემულ ფოტოზე"

        questionImageView.setImageResource(R.drawable.norwa)

        answer1.text = "ფინეთი"
        answer2.text = "ნორვეგია"
        answer3.text = "შვედეთი"

        answer1.setOnClickListener {
            answer1.isChecked = false
            sixthEasyQuestion()
        }

        answer2.setOnClickListener {
            answer2.isChecked = false
            mediumPlayerScore++
            sixthEasyQuestion()
        }

        answer3.setOnClickListener {
            answer3.isChecked = false
            sixthEasyQuestion()
        }

    }

    private fun sixthEasyQuestion() {

        questionTextView.text = "რომელი ქვეყნის დროშაა მოცემულ ფოტოზე"

        questionImageView.setImageResource(R.drawable.ital)

        answer1.text = "საბერძნეთი"
        answer2.text = "საფრანგეთი"
        answer3.text = "იტალია"

        answer1.setOnClickListener {
            answer1.isChecked = false
            seventhEasyQuestion()
        }

        answer2.setOnClickListener {
            answer2.isChecked = false
            seventhEasyQuestion()
        }

        answer3.setOnClickListener {
            answer3.isChecked = false
            mediumPlayerScore++
            seventhEasyQuestion()
        }

    }

    private fun seventhEasyQuestion() {

        questionTextView.text = "რომელი ქვეყნის დროშაა მოცემულ ფოტოზე"

        questionImageView.setImageResource(R.drawable.irela)

        answer1.text = "ირლანდია"
        answer2.text = "ისლანდია"
        answer3.text = "ბელგია"

        answer1.setOnClickListener {
            answer1.isChecked = false
            mediumPlayerScore++
            eighthEasyQuestion()
        }

        answer2.setOnClickListener {
            answer2.isChecked = false
            eighthEasyQuestion()
        }

        answer3.setOnClickListener {
            answer3.isChecked = false
            eighthEasyQuestion()
        }

    }

    private fun eighthEasyQuestion() {

        questionTextView.text = "რომელი ქვეყნის დროშაა მოცემულ ფოტოზე"

        questionImageView.setImageResource(R.drawable.azer)

        answer1.text = "სომხეთი"
        answer2.text = "აზერბაიჯანი"
        answer3.text = "თურქმენეთი"

        answer1.setOnClickListener {
            answer1.isChecked = false
            ninethEasyQuestion()
        }

        answer2.setOnClickListener {
            answer2.isChecked = false
            mediumPlayerScore++
            ninethEasyQuestion()
        }

        answer3.setOnClickListener {
            answer3.isChecked = false
            ninethEasyQuestion()
        }

    }

    private fun ninethEasyQuestion() {

        questionTextView.text = "რომელი ქვეყნის დროშაა მოცემულ ფოტოზე"

        questionImageView.setImageResource(R.drawable.franc)

        answer1.text = "რუსეთი"
        answer2.text = "ბულგარეთი"
        answer3.text = "საფრანგეთი"

        answer1.setOnClickListener {
            answer1.isChecked = false
            tenthEasyQuestion()
        }

        answer2.setOnClickListener {
            answer2.isChecked = false
            tenthEasyQuestion()
        }

        answer3.setOnClickListener {
            answer3.isChecked = false
            mediumPlayerScore++
            tenthEasyQuestion()
        }


    }

    private fun tenthEasyQuestion() {

        questionTextView.text = "რომელი ქვეყნის დროშაა მოცემულ ფოტოზე"

        questionImageView.setImageResource(R.drawable.arab)

        answer1.text = "ავღანეთი"
        answer2.text = "არაბეთი"
        answer3.text = "აზერბაიჯანი"


        answer1.setOnClickListener {
            answer1.isChecked = false
            findNavController().navigate(MediumQuestionsFragmentDirections.actionMediumQuestionsFragmentToProfileFragment2())

            updateScore()

        }

        answer2.setOnClickListener {
            answer2.isChecked = false
            mediumPlayerScore++
            findNavController().navigate(MediumQuestionsFragmentDirections.actionMediumQuestionsFragmentToProfileFragment2())

            updateScore()


        }

        answer3.setOnClickListener {
            answer3.isChecked = false
            findNavController().navigate(MediumQuestionsFragmentDirections.actionMediumQuestionsFragmentToProfileFragment2())

            updateScore()

        }

        val activity = requireActivity() as? MainActivity
        activity?.hideNavBar()

    }

    fun updateScore(){

        dataBase.child(auth.currentUser?.uid!!).addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val userInfo = snapshot.getValue(User::class.java) ?: return

                if (mediumPlayerScore>userInfo.mediumScore){
                    dataBase.child(auth.currentUser?.uid!!).child("mediumScore").setValue(mediumPlayerScore)
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

    }

}

