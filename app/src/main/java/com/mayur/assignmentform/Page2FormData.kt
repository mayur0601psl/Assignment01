package com.mayur.assignmentform

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Page2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Page2 : Fragment() {

    lateinit var emailId : EditText
    lateinit var phone : EditText
    lateinit var address : EditText
    lateinit var nextBtn : Button
    lateinit var prevBtn : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page2_filldata, container, false)
    }
    fun checkFields(emailId:EditText,phone:EditText,address:EditText) : Boolean {
        return emailId.text.toString().isNotEmpty() && phone.text.toString()
            .isNotEmpty() && address.text.toString().isNotEmpty()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Log.d("DEBUG_TEST", "onViewCreated: $arguments")
        emailId = view.findViewById(R.id.emailid)
        phone = view.findViewById(R.id.phone)
        address = view.findViewById(R.id.address)
        nextBtn = view.findViewById(R.id.next)
        prevBtn = view.findViewById(R.id.previous)

        val fragmentManager : FragmentManager = activity?.supportFragmentManager!!
        val fragmentTrasaction : FragmentTransaction = fragmentManager.beginTransaction()


        nextBtn.setOnClickListener {

            if(checkFields(emailId,phone,address)) {
                val bundle = Bundle()

                bundle.putString("username", arguments?.getString("username"))
                bundle.putString("password", arguments?.getString("password"))
                bundle.putString("emailId", emailId.text.toString())
                bundle.putString("phone", phone.text.toString())
                bundle.putString("address", address.text.toString())

                val page3 = Page3()
                page3.arguments = bundle
                fragmentTrasaction.replace(R.id.frame, page3)
                fragmentTrasaction.addToBackStack(null)
                fragmentTrasaction.commit()
            }else{
                if(!emailId.text.toString().isNotEmpty()){
                    emailId.error = "Please enter email"
                }

                if(!phone.text.toString().isNotEmpty()){
                    phone.error = "Please enter phone"
                }
                if(!address.text.toString().isNotEmpty()){
                    address.error = "Please enter address"
                }

            }

        }

        prevBtn.setOnClickListener {
            fragmentManager.popBackStack()
        }

    }


}