package com.example.databaseappl

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class UserAdapter(val context: Context, val allUsers: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_view,
            parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return allUsers.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.userId.text = allUsers[position].userId.toString()
        holder.userName.text = allUsers[position].userName
        holder.userEmail.text = allUsers[position].userEmail
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userId: TextView = itemView.findViewById(R.id.user_id_display)
        val userName: TextView = itemView.findViewById(R.id.user_name_display)
        val userEmail: TextView = itemView.findViewById(R.id.user_email_display)
    }
}