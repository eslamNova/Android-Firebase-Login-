package com.alien.islam.firebase1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class SignUpActivity extends AppCompatActivity {


    Button register;
    ProgressBar registerProgress;
    EditText text , pass_text , pass_text_2 ;

    String email , password , passwors_2 ;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        register = findViewById(R.id.signup_button);
        registerProgress = findViewById(R.id.register_progress);
        registerProgress.setVisibility(View.INVISIBLE);
        text = findViewById(R.id.login_text);
        pass_text = findViewById(R.id.login_pass);
        pass_text_2 = findViewById(R.id.pass_confirm);

        mAuth = FirebaseAuth.getInstance();


        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                registerProgress.setVisibility(View.VISIBLE);
                register.setVisibility(View.INVISIBLE);
                SignUp();
            }
        });
    }



    private void SignUp(){

        email = text.getText().toString();
        password = pass_text.getText().toString();
        passwors_2 = pass_text_2.getText().toString();
        if(! password.equals(passwors_2))
        {
            Toast.makeText(SignUpActivity.this , "password not matching",Toast.LENGTH_LONG).show();
        }
        else
        {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(SignUpActivity.this, "Authentication Successful.",
                                        Toast.LENGTH_LONG).show();
                                Intent myIntent = new Intent(SignUpActivity.this, LoginActivity.class);
                                startActivity(myIntent);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                        Toast.LENGTH_LONG).show();
                            }

                            // ...
                        }
                    });
        }
    }
}
