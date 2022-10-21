package com.mayur.assignmentform

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentTransaction
import kotlinx.coroutines.flow.combine
import androidx.fragment.app.FragmentManager as FragmentManager1

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Page1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Page1 : Fragment() {

     lateinit var username : EditText
     lateinit var password : EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page1_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentManager : FragmentManager1 = activity?.supportFragmentManager!!
        val fragmentTrasaction : FragmentTransaction = fragmentManager.beginTransaction()

        val loginbtn = view.findViewById<Button>(R.id.login)

        username = view.findViewById(R.id.username)
        password = view.findViewById(R.id.password)

        loginbtn.setOnClickListener {
            if(username.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()) {

                val bundle = Bundle()
                bundle.putString("username", username.text.toString())
                bundle.putString("password", password.text.toString())
                val page2 = Page2()
                page2.arguments = bundle
                fragmentTrasaction.replace(R.id.frame, page2)
                fragmentTrasaction.addToBackStack(null)
                fragmentTrasaction.commit()
            }else{
               if(!username.text.toString().isNotEmpty()){
                   username.error = "Please enter username"
               }
                if(!password.text.toString().isNotEmpty()){
                    password.error = "Please enter password"
                }

            }
        }


    }

}