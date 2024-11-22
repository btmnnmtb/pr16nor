package com.example.pr16nor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdpterRecyclerView extends RecyclerView.Adapter<AdpterRecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<UserBook> userList;

    public AdpterRecyclerView(Context context, ArrayList<UserBook> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public AdpterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null ;
    }




    @Override
    public void onBindViewHolder(@NonNull AdpterRecyclerView.ViewHolder holder, int position) {
        UserBook book = userList.get(position);
        holder.nameAuthor.setText(book.getNameAuthor());
        holder.nameBook.setText(book.getNameBook());
        holder.emailAuthor.setText(book.getEmailAuthor());
        holder.numberPhone.setText(book.getNumberPhone());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameAuthor;
        TextView nameBook;
        TextView emailAuthor;
        TextView numberPhone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameAuthor = itemView.findViewById(R.id.nameauthor); // Замените на ваш ID
            nameBook = itemView.findViewById(R.id.namebook); // Замените на ваш ID
            emailAuthor = itemView.findViewById(R.id.email_author); // Замените на ваш ID
            numberPhone = itemView.findViewById(R.id.nuber_phone); // Замените на ваш ID
        }
    }
}