package com.example.easytripplanners.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.easytripplanners.R;

public class TripDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_details);
        setTitle("TripDetailsActivity");
    }
}