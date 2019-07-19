package com.example.databaseappl

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FetchUsers : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var userAdapter: UserAdapter
    lateinit var layoutManager: LinearLayoutManager
//    var allUsers: List<User> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_fetch_users, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)
//        allUsers = retrieveAllusers()
        userAdapter = UserAdapter(context!!.applicationContext, retrieveAllusers())
        layoutManager = LinearLayoutManager(context!!.applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = userAdapter
        recyclerView.setHasFixedSize(true)
        return view
    }

    private fun retrieveAllusers(): List<User> {
        //        Log.d("Users",user.toString())
        return UserDatabase.getDatabaseInstance(context!!.applicationContext)!!.userDao().fetUsers()
    }
}
