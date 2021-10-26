package com.example.rentacab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;

import android.widget.Toast;


import com.example.rentacab.databinding.ActivityRegisterBinding;
import com.example.rentacab.modal.user;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.FirebaseDatabase;

public class registerActivity extends AppCompatActivity {

    public ActivityRegisterBinding binding;
private FirebaseAuth auth;
FirebaseDatabase database;
ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(registerActivity.this);
        progressDialog.setTitle("creating Account");
        progressDialog.setMessage("creating your account");
        binding.registerBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                auth.createUserWithEmailAndPassword(binding.emailData.getText().toString(),binding.passData.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            user u1 =new user(binding.custName.getText().toString(),binding.emailData
                                    .getText().toString(),binding.passData.getText().toString());
                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("User").child(id).setValue(u1);
                            Toast.makeText(registerActivity.this,"User created successfully",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(registerActivity.this, loginActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(registerActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }


}