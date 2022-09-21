package com.example.recyclerviewapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Items_Adapter adapter;
    ArrayList<Model_items> arrayList=new ArrayList<>();
    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.Recycler_view);
        floatingActionButton=findViewById(R.id.floating_button);





        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_items);

                EditText editText=dialog.findViewById(R.id.edit_Add_items);
                Button addItem =dialog.findViewById(R.id.btn_Add_items);

                addItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String item ="";
                        if (!editText.getText().toString().equals("")){
                             item=editText.getText().toString();
                        }else{
                            Toast.makeText(MainActivity.this,"teeeete" ,Toast.LENGTH_SHORT).show();
                            }
                        arrayList.add(new Model_items(item));
                        adapter.notifyItemInserted(arrayList.size()-1);
                        recyclerView.scrollToPosition(arrayList.size()-1);

                       dialog.dismiss();


                    }
                });

                dialog.show();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList.add(new Model_items("Vehicle Washing"));
        arrayList.add(new Model_items("Brake Shoe Rubbing"));
        arrayList.add(new Model_items("Carburetor cleaning"));
        arrayList.add(new Model_items("Greasing And Lubrication"));
        arrayList.add(new Model_items("Oil Leakage check"));
        arrayList.add(new Model_items("Lighting check"));
        arrayList.add(new Model_items("@123123"));

        adapter=new Items_Adapter(this,arrayList);
        recyclerView.setAdapter(adapter);


    }
}