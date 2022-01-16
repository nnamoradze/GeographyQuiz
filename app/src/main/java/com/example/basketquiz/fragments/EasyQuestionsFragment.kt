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

class EasyQuestionsFragment : Fragment(R.layout.easy_questions_fragment) {


    private lateinit var questionTextView: TextView

    private lateinit var questionImageView: ImageView

    private lateinit var answer1: CheckBox
    private lateinit var answer2: CheckBox
    private lateinit var answer3: CheckBox

    private lateinit var dataBase: DatabaseReference
    private lateinit var auth: FirebaseAuth

    private var easyQuestScore = 0



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        questionTextView = view.findViewById(R.id.easyQuestionTextView)

        questionImageView = view.findViewById(R.id.easyQuestionImageView)

        answer1 = view.findViewById(R.id.easyAnswer1)
        answer2 = view.findViewById(R.id.easyAnswer2)
        answer3 = view.findViewById(R.id.easyAnswer3)


        dataBase = FirebaseDatabase.getInstance().getReference("Users")
        auth = FirebaseAuth.getInstance()


        questionTextView.text = "რომელ მდინარეს აქვს ყველაზე გრძელი კალაპოტი საქართელოში?"

        answer1.text = "ალაზანი"
        answer2.text = "რიონი"
        answer3.text = "ჭოროხი"




        answer1.setOnClickListener {
            answer1.isChecked = false
            easyQuestScore++
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

        questionTextView.text =
            "რა ქვია იმ წარმოსახვით  ხაზს რომელიც დედამიწას ჩრდილოეთ და სამხრეთ  ნაწილად ჰყოფს?"

        questionImageView.setImageResource(R.drawable.ekvatori)

        answer1.text = "მერიდიანი"
        answer2.text = "ეკვატორი"
        answer3.text = "პოლუსი"

        answer1.setOnClickListener {
            answer1.isChecked = false
            thirdEasyQuestion()
        }

        answer2.setOnClickListener {
            answer2.isChecked = false
            easyQuestScore++
            thirdEasyQuestion()
        }

        answer3.setOnClickListener {
            answer3.isChecked = false
            thirdEasyQuestion()
        }


    }

    private fun thirdEasyQuestion() {

        questionTextView.text = "რომელი ქვეყნის დროშაა?"

        questionImageView.setImageResource(R.drawable.checeti)

        answer1.text = "ჩეხეთი"
        answer2.text = "ჩილე"
        answer3.text = "მონაკო"

        answer1.setOnClickListener {
            answer1.isChecked = false
            easyQuestScore++
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
        questionTextView.text = "რომელი ქვეყნის კონტურია?"

        questionImageView.setImageResource(R.drawable.iaponia)

        answer1.text = "არგენტინა"
        answer2.text = "ინდონეზია"
        answer3.text = "იაპონია"

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
            easyQuestScore++
            fifthEasyQuestion()
        }
    }

    private fun fifthEasyQuestion() {

        questionTextView.text = "სად დგას იესოს ეს ცნობილი ქანდაკება?"

        questionImageView.setImageResource(R.drawable.ieso_brazilia)

        answer1.text = "მეხიკო"
        answer2.text = "რიო-დე-ჟანეირო"
        answer3.text = "ბარსელონა"

        answer1.setOnClickListener {
            answer1.isChecked = false
            sixthEasyQuestion()
        }

        answer2.setOnClickListener {
            answer2.isChecked = false
            easyQuestScore++
            sixthEasyQuestion()
        }

        answer3.setOnClickListener {
            answer3.isChecked = false
            sixthEasyQuestion()
        }

    }

    private fun sixthEasyQuestion() {

        questionTextView.text = "რომელ ქვეყნებს ჰყოფს ლა მანშის სრუტე?"

        questionImageView.setImageResource(R.drawable.lamanshi)

        answer1.text = "თურქეთი-საბერძნეთი"
        answer2.text = "ესპანეთი-მაროკო"
        answer3.text = "საფრანგეთი-ინგლისი"

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
            easyQuestScore++
            seventhEasyQuestion()
        }

    }

    private fun seventhEasyQuestion() {

        questionTextView.text = "რომელია ალპების უმაღლესი მწვერვალი?"

        questionImageView.setImageResource(R.drawable.alpebimomblani)

        answer1.text = "მონბლანი"
        answer2.text = "მატერჰორნი"
        answer3.text = "ევერესტი"

        answer1.setOnClickListener {
            answer1.isChecked = false
            easyQuestScore++
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

        questionTextView.text = "ვინ მიაღწია სამხრეთ პოლუსამდე პირველმა?"

        questionImageView.setImageResource(R.drawable.rualamundseni)

        answer1.text = "რობერტ სტოკი"
        answer2.text = "რუალ ამუნდსენი"
        answer3.text = "რობერტ პირი"

        answer1.setOnClickListener {
            answer1.isChecked = false
            ninthEasyQuestion()
        }

        answer2.setOnClickListener {
            answer2.isChecked = false
            easyQuestScore++
            ninthEasyQuestion()
        }

        answer3.setOnClickListener {
            answer3.isChecked = false
            ninthEasyQuestion()
        }

    }

    private fun ninthEasyQuestion() {

        questionTextView.text = "ვის საპატივცემულოდ დაერქვა კონტინენტს ამერიკა?"

        questionImageView.setImageResource(R.drawable.vespuchi)

        answer1.text = "ქრისტეფორე კოლუმბი"
        answer2.text = "ფერნანდო მაგელანი"
        answer3.text = "ამერიგო ვესპუჩი"

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
            easyQuestScore++
            tenthEasyQuestion()
        }


    }

    private fun tenthEasyQuestion() {

        questionTextView.text = "რომელ მეზობელთან აქვს საქართველოს ყველაზე მოკლე საზღვარი?"

        questionImageView.setImageResource(R.drawable.sazgvarisomxeti)

        answer1.text = "თურქეთთან"
        answer2.text = "სომხეთთან"
        answer3.text = "აზერბაიჯანთან"



        answer1.setOnClickListener {

            answer1.isChecked = false

            findNavController().navigate(EasyQuestionsFragmentDirections.actionEasyQuestionsFragment2ToProfileFragment2())

            updateScore()

        }

        answer2.setOnClickListener {
            answer2.isChecked = false
            easyQuestScore++
            findNavController().navigate(EasyQuestionsFragmentDirections.actionEasyQuestionsFragment2ToProfileFragment2())

            updateScore()

        }

        answer3.setOnClickListener {

            answer3.isChecked = false

            findNavController().navigate(EasyQuestionsFragmentDirections.actionEasyQuestionsFragment2ToProfileFragment2())

            updateScore()


        }

        val activity = requireActivity() as? MainActivity
        activity?.hideNavBar()

    }

    fun updateScore(){

        dataBase.child(auth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                val userInfo = snapshot.getValue(User::class.java) ?: return

                if (easyQuestScore>userInfo.easyScore){
                    dataBase.child(auth.currentUser?.uid!!).child("easyScore").setValue(easyQuestScore)
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

    }

}