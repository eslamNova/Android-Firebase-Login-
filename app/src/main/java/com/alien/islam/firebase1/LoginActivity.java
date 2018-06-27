package com.alien.islam.firebase1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    ProgressBar loginProgress;
    EditText text , pass_text ;

    String email , password ;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.login_button);
        loginProgress = findViewById(R.id.login_progress);
        loginProgress.setVisibility(View.INVISIBLE);
        text = findViewById(R.id.login_text);
        pass_text = findViewById(R.id.login_pass);

        mAuth = FirebaseAuth.getInstance();



        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                loginProgress.setVisibility(View.VISIBLE);
                loginButton.setVisibility(View.INVISIBLE);
                SignIn();
            }
        });
    }


//    @Override
//    protected void onStart(){
//        super.onStart();
//
//        mAuth.addAuthStateListener(mAuthListener);
//    }
    private void SignIn (){

        email = text.getText().toString();
        password = pass_text.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(LoginActivity.this, "Authentication Successful.",
                                    Toast.LENGTH_LONG).show();
                            Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(myIntent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_LONG).show();
                            loginProgress.setVisibility(View.INVISIBLE);
                            loginButton.setVisibility(View.VISIBLE);

                        }

                        // ...
                    }
                });
    }

//    public void onClick(View view) {
//        loginProgress.setVisibility(View.VISIBLE);
//        loginButton.setVisibility(View.INVISIBLE);
//        SignIn(text.getText().toString(), pass_text.getText().toString());
//
//    }

}
