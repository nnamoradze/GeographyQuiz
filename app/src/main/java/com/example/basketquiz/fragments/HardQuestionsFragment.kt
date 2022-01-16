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

class HardQuestionsFragment:Fragment(R.layout.hard_questions_fragment) {

    private lateinit var questionTextView: TextView

    private lateinit var questionImageView: ImageView

    private lateinit var answer1: CheckBox
    private lateinit var answer2: CheckBox
    private lateinit var answer3: CheckBox

    private lateinit var dataBase: DatabaseReference
    private lateinit var auth: FirebaseAuth

    private var hardPlayerScore = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questionTextView = view.findViewById(R.id.hardQuestionTextView)

        questionImageView = view.findViewById(R.id.hardQuestionImageView)

        answer1 = view.findViewById(R.id.hardAnswer1)
        answer2 = view.findViewById(R.id.hardAnswer2)
        answer3 = view.findViewById(R.id.hardAnswer3)

        dataBase = FirebaseDatabase.getInstance().getReference("Users")
        auth = FirebaseAuth.getInstance()

        questionTextView.text = "პირველი გეოგრაფიული რუკის ავტორია?"
        questionImageView.setImageResource(R.drawable.firsmap)

        answer1.text = "ერატოსთენე"
        answer2.text = "არისტოტელე"
        answer3.text = "სოკრატე"


        answer1.setOnClickListener {
            answer1.isChecked = false
            hardPlayerScore++
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

        questionTextView.text = "რომელ ზღვაში ჩაედინება მდინარე ნილოსი?"

        questionImageView.setImageResource(R.drawable.nilos)

        answer1.text = "წითელ ზღვაში"
        answer2.text = "ხმელთაშუა ზღვაში"
        answer3.text = "შავ ზღვაში"

        answer1.setOnClickListener {
            answer1.isChecked = false
            thirdEasyQuestion()
        }

        answer2.setOnClickListener {
            answer2.isChecked = false
            hardPlayerScore++
            thirdEasyQuestion()
        }

        answer3.setOnClickListener {
            answer3.isChecked = false
            thirdEasyQuestion()
        }


    }

    private fun thirdEasyQuestion() {

        questionTextView.text = "რომელია ყველაზე მაღალი კონტინენტი"

        questionImageView.setImageResource(R.drawable.continents)

        answer1.text = "ანტარქტიდა"
        answer2.text = "აზია"
        answer3.text = "სამხრეთ ამერიკა"

        answer1.setOnClickListener {
            answer1.isChecked = false
            hardPlayerScore++
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
        questionTextView.text = "სად მდებარეობს ვულკანი ერებუსი"

        questionImageView.setImageResource(R.drawable.erebus)

        answer1.text = "ევროპაში"
        answer2.text = "აზიაში"
        answer3.text = "ანტარქტიდაზე"

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
            hardPlayerScore++
            fifthEasyQuestion()
        }
    }

    private fun fifthEasyQuestion() {

        questionTextView.text = "რომელია სიდიდით მეოთხე ოკეანე?"

        questionImageView.setImageResource(R.drawable.continents)

        answer1.text = "ატლანტის ოკეანე"
        answer2.text = "სამხრეთის ოკეანე"
        answer3.text = "ჩრდილო-ყინულოვანი ოკეანე"

        answer1.setOnClickListener {
            answer1.isChecked = false
            sixthEasyQuestion()
        }

        answer2.setOnClickListener {
            answer2.isChecked = false
            hardPlayerScore++
            sixthEasyQuestion()
        }

        answer3.setOnClickListener {
            answer3.isChecked = false
            sixthEasyQuestion()
        }

    }

    private fun sixthEasyQuestion() {

        questionTextView.text = "რამდენი სახელმწიფოა გაწევრიანებული ნატოში?"

        questionImageView.setImageResource(R.drawable.nato)

        answer1.text = "28"
        answer2.text = "27"
        answer3.text = "29"

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
            hardPlayerScore++
            seventhEasyQuestion()
        }

    }

    private fun seventhEasyQuestion() {

        questionTextView.text = "სად მდებარეობს ყველაზე გრძელი საავტომობილო გზა?"

        questionImageView.setImageResource(R.drawable.longestroad)

        answer1.text = "აშშ-ში"
        answer2.text = "რუსეთში"
        answer3.text = "გერმანიაში"

        answer1.setOnClickListener {
            answer1.isChecked = false
            hardPlayerScore++
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

        questionTextView.text = "რომელია ბრაზილიის ეროვნული ვალუტა?"

        questionImageView.setImageResource(R.drawable.brazil)

        answer1.text = "დონგი"
        answer2.text = "რეალი"
        answer3.text = "პესო"

        answer1.setOnClickListener {
            answer1.isChecked = false
            ninethEasyQuestion()
        }

        answer2.setOnClickListener {
            answer2.isChecked = false
            hardPlayerScore++
            ninethEasyQuestion()
        }

        answer3.setOnClickListener {
            answer3.isChecked = false
            ninethEasyQuestion()
        }

    }

    private fun ninethEasyQuestion() {

        questionTextView.text = "ჩამოთვლილთაგან რომელი ქვეყანა არ ფლობს ბირთვულ იარაღს?"

        questionImageView.setImageResource(R.drawable.nuclearweapon)

        answer1.text = "ინდოეთი"
        answer2.text = "პაკისტანი"
        answer3.text = "იტალია"

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
            hardPlayerScore++
            tenthEasyQuestion()
        }


    }

    private fun tenthEasyQuestion() {

        questionTextView.text = "რომელი ქვეყნის სახელმწიფო რელიგიებია: კონფუციანელობა,სინტოიზმი და ბუდიზმი?"

        questionImageView.setImageResource(R.drawable.religions)

        answer1.text = "ჩინეთის"
        answer2.text = "იაპონიის"
        answer3.text = "ტაილანდის"


        answer1.setOnClickListener {
            answer1.isChecked = false
            findNavController().navigate(HardQuestionsFragmentDirections.actionHardQuestionsFragmentToProfileFragment2())

            updateScore()

        }

        answer2.setOnClickListener {
            answer2.isChecked = false
            hardPlayerScore++
            findNavController().navigate(HardQuestionsFragmentDirections.actionHardQuestionsFragmentToProfileFragment2())

            updateScore()

        }

        answer3.setOnClickListener {
            answer3.isChecked = false
            findNavController().navigate(HardQuestionsFragmentDirections.actionHardQuestionsFragmentToProfileFragment2())

            updateScore()

        }

        val activity = requireActivity() as? MainActivity
        activity?.hideNavBar()

    }

    fun updateScore(){

        dataBase.child(auth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val userInfo = snapshot.getValue(User::class.java) ?: return

                if (hardPlayerScore>userInfo.hardScore){
                    dataBase.child(auth.currentUser?.uid!!).child("hardScore").setValue(hardPlayerScore)
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

    }

}