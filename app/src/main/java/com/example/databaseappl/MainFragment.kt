package com.example.databaseappl


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class MainFragment : Fragment(), View.OnClickListener{
    lateinit var addUserBtn: Button
    lateinit var viewButton: Button


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)
        addUserBtn = view.findViewById(R.id.add_user)
        addUserBtn.setOnClickListener(this)
        viewButton = view.findViewById(R.id.view_user)
        viewButton.setOnClickListener(this)

        return view
    }

    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id) {
                R.id.add_user -> fragmentManager!!.beginTransaction().replace(R.id.fragment_container,
                    AddUser()).addToBackStack(null).commit()

                R.id.view_user -> fragmentManager!!.beginTransaction().replace(R.id.fragment_container,
                    FetchUsers()).addToBackStack(null).commit()
            }

        }

    }
}
