package com.example.databaseappl


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class DeleteUser : Fragment(), View.OnClickListener {
    lateinit var userDeleteID: EditText
    lateinit var deleteUserButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_delete_user, container, false)
        userDeleteID = view.findViewById(R.id.delete_user_id)
        deleteUserButton = view.findViewById(R.id.delete_btn)
        deleteUserButton.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {
        val deleteID: Int = Integer.parseInt(userDeleteID.text.toString())
        val user = User()
        user.userId = deleteID
        val isDeleted: Int = UserDatabase.getDatabaseInstance(context!!.applicationContext)!!.userDao().deleteUser(user)
        if(isDeleted == 1) {
            Toast.makeText(context!!.applicationContext, "User Deleted Successfully", Toast.LENGTH_SHORT).show()
        }
        else
            Toast.makeText(context!!.applicationContext, "User Does Not Exist", Toast.LENGTH_SHORT).show()
    }
}
