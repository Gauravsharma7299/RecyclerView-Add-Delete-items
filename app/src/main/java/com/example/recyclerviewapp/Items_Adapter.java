package com.example.recyclerviewapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Items_Adapter extends RecyclerView.Adapter<Items_Adapter.ViewHolder> {
     ArrayList<Model_items> arrayList;
     Context context;
    Items_Adapter (Context context , ArrayList<Model_items> arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view=   LayoutInflater.from(context).inflate(R.layout.items_views ,parent,false);
      ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.txt_items.setText(arrayList.get(position).items);
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context)
                        .setTitle("Delete Item")
                        .setMessage("Are You sure want to Delete")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                   arrayList.remove(position);
                                   notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                builder.show();

                return true;
            }
        });



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
           TextView txt_items;
           CardView cardView;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            txt_items=itemView.findViewById(R.id.text_view);
            cardView=itemView.findViewById(R.id.cd);
        }
    }



}
