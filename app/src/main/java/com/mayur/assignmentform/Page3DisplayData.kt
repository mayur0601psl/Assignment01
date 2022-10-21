package com.mayur.assignmentform

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Page3.newInstance] factory method to
 * create an instance of this fragment.
 */
class Page3 : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var username : TextView
    lateinit var emailId : TextView
    lateinit var phone : TextView
    lateinit var address : TextView
    lateinit var backButton : Button
    lateinit var homeButton : Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page3_showdata, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Log.d("DEBUG_TEST", "onViewCreated: ")

        username = view.findViewById(R.id.userDetail)
        emailId = view.findViewById(R.id.user_emailid)
        phone = view.findViewById(R.id.user_phone)
        address = view.findViewById(R.id.user_address)
        homeButton = view.findViewById(R.id.user_home)


        username.text = "Welcome ${arguments?.getString("username")}"
        emailId.text = "Email id - ${arguments?.getString("emailId")}"
        address.text = "Address - ${arguments?.getString("address")}"
        phone.text = "Phone no is - ${arguments?.getString("phone")}"


        homeButton.setOnClickListener {
            val fragmentManager : FragmentManager = activity?.supportFragmentManager!!
            val fragmentTrasaction : FragmentTransaction = fragmentManager.beginTransaction()
            val page1login = Page1()
            fragmentTrasaction.replace(R.id.frame,page1login)
            fragmentManager.popBackStack("page1_frag",0)
            fragmentTrasaction.commit()
        }
    }
}