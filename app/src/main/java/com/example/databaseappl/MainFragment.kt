package com.example.databaseappl


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment(), View.OnClickListener{
    lateinit var addUserBtn: Button


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_main, container, false)
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)
        addUserBtn = view.findViewById(R.id.add_user)
        addUserBtn.setOnClickListener(this)
        return view
    }

    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id) {
                R.id.add_user -> fragmentManager!!.beginTransaction().replace(R.id.fragment_container,
                    AddUser()).addToBackStack(null).commit()
            }

        }

    }
}
