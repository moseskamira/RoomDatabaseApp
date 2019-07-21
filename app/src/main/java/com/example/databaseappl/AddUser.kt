package com.example.databaseappl

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class AddUser : Fragment(), View.OnClickListener {
    lateinit var userId: EditText
    lateinit var userName: EditText
    lateinit var userEmail: EditText
    lateinit var saveBtn: Button
    var userDatabase: UserDatabase? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.add_user, container, false)
        userId = view.findViewById(R.id.user_id)
        userName = view.findViewById(R.id.user_name)
        userEmail = view.findViewById(R.id.user_email)
        saveBtn = view.findViewById(R.id.save_user)
        saveBtn.setOnClickListener(this)
        return view
    }

    override fun onClick(view: View?) {
        if (view != null) {
            userDatabase = UserDatabase.getDatabaseInstance(context!!.applicationContext)
            populateDbWithData(userDatabase!!)
            killDatabase()
        }
    }
    private fun addUser(db: UserDatabase, user: User): User {
        db.userDao().insertUser(user)
        return user
    }

    private fun populateDbWithData(db: UserDatabase) {
        val userId = Integer.parseInt(userId.text.toString())
        val userName: String = userName.text.toString()
        val userEmail: String = userEmail.text.toString()
        val user = User()

        user.userId = userId
        user.userName = userName
        user.userEmail = userEmail
        addUser(db, user)
        Toast.makeText(activity, "User Added Successfully", Toast.LENGTH_SHORT).show()
    }
    private fun killDatabase () {
        UserDatabase.destroyDatabase()
    }
}
