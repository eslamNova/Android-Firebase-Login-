package com.alien.islam.firebase1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DbActivity extends AppCompatActivity {

    EditText fName , lName , email , phone , gender ;
    Spinner type ;
    Button add;
    DatabaseReference usersDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        usersDB = FirebaseDatabase.getInstance().getReference("users_T");

        fName = (EditText) findViewById(R.id.editText);
        lName = (EditText) findViewById(R.id.editText6);
        email = (EditText) findViewById(R.id.editText7);
        phone = (EditText) findViewById(R.id.editText8);
        gender = (EditText) findViewById(R.id.editText9);

        add = (Button) findViewById(R.id.button);

        type = (Spinner) findViewById(R.id.spinner);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });

    }

    private void addUser(){
        String FName = fName.getText().toString();
        String LName = lName.getText().toString();
        String Phone = phone.getText().toString();
        String Email = email.getText().toString();
        String Gender = gender.getText().toString();
        Boolean type2 = false;
        String Type = type.getSelectedItem().toString();
        if(Type.equalsIgnoreCase("Donner"))
            type2 = true;

        String id = usersDB.push().getKey();

        users user = new users(id,FName,LName,Email,Phone,Gender,type2);

        usersDB.child(id).setValue(user);
        Toast.makeText(DbActivity.this, "Added Successful.",
                Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(DbActivity.this, MainActivity.class);
        startActivity(myIntent);

    }
}
