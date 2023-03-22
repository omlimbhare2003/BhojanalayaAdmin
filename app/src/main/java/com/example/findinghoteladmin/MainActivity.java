package com.example.findinghoteladmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    String title,adddress,contactus;
    EditText e1,e2,e3;
    Button b1;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference ref=database.getReference("mess");
        myRef=ref.child("purevegmess");

        e1=findViewById(R.id.name);
        e2=findViewById(R.id.address);
        e3=findViewById(R.id.contactus);
        b1=findViewById(R.id.submit);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              title=e1.getText().toString();
              adddress=e2.getText().toString();
              contactus=e3.getText().toString();
              Detail temp=new Detail(title,adddress,contactus);
              myRef.child(title).setValue(temp);
            }
        });
    }
}

















