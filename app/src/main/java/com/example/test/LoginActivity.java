package com.example.test;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity  {

    String TAG="LoginActivity";
    EditText etEmail;
    EditText etPassword;
    String stEmail;
    String stPassword;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etEmail=(EditText)findViewById(R.id.etEmail);
        final EditText etPassword=(EditText)findViewById(R.id.etPassword);


        mAuth = FirebaseAuth.getInstance();
        mAuthListener=new FirebaseAuth.AuthStateListener(){

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser();
                if(user !=null){
                    Log.d(TAG, "onAuthStateChanged:signed_in"+user.getUid());
                }
                else{
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };




        Button btnRegister=(Button)findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                stEmail=etEmail.getText().toString();
                stPassword = etPassword.getText().toString();

                //Toast.makeText(LoginActivity.this, stEmail+","+stPassword, Toast.LENGTH_SHORT).show();
                registerUser(stEmail, stPassword);
            }
        });

        Button btnLogin= (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                stEmail=etEmail.getText().toString();
                stPassword = etPassword.getText().toString();

                userLogin(stEmail, stPassword);

            }
        });
    }
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        mAuth.addAuthStateListener(mAuthListener);
    }

    public void onStop(){
        super.onStop();
        if(mAuthListener !=null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public void registerUser(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:"+task.isSuccessful());

                        Toast.makeText(LoginActivity.this, "Authentication success.",
                                Toast.LENGTH_SHORT).show();

                        if(!task.isSuccessful()){
                            Toast.makeText(LoginActivity.this,"Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        // ...
                    }
                });
    }

    private void userLogin(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:"+task.isSuccessful());

                        Intent in = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(in);

                        if(!task.isSuccessful()){
                            Toast.makeText(LoginActivity.this,"Authentication success.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        // ...
                    }
                });
    }
}

