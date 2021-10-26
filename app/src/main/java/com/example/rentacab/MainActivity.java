package com.example.rentacab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void register(View view){
        Intent intent = new Intent(this,registerActivity.class);
startActivity(intent);
    }
    public void login(View view ){
        Intent intent2 = new Intent(this, loginActivity.class);
        startActivity(intent2);
    }
//    public void login_owner(View view ){
//        Intent intent3 = new Intent(this, owner.class);
//        startActivity(intent3);
//    }


}