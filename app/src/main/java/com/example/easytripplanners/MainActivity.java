package com.example.easytripplanners;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.example.easytripplanners.View.AuthenticationActivity;
import com.example.easytripplanners.View.HomeActivity;
import com.example.easytripplanners.View.TripCreationActivity;
import com.example.easytripplanners.View.TripDetailsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_goto_auth).setOnClickListener(v->
                startActivity(new Intent(this, AuthenticationActivity.class)));

        findViewById(R.id.btn_goto_creation).setOnClickListener(v->
                startActivity(new Intent(this, TripCreationActivity.class)));

        findViewById(R.id.btn_goto_tripDetails).setOnClickListener(v->
                startActivity(new Intent(this, TripDetailsActivity.class)));

        findViewById(R.id.btn_goto_home).setOnClickListener(v->
                startActivity(new Intent(this, HomeActivity.class)));

    }
}