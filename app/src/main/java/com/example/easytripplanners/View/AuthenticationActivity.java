package com.example.easytripplanners.View;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import com.example.easytripplanners.R;
import com.example.easytripplanners.Utils.CNav;
import com.example.easytripplanners.Utils.CNav.CNavFragment;
import com.example.easytripplanners.View.ui.authentication.LoginFragment;
import com.example.easytripplanners.View.ui.authentication.RegisterFragment;

public class AuthenticationActivity extends AppCompatActivity {
    CNav cNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        setTitle("AuthenticationActivity");

        if(savedInstanceState==null){
            cNav = new CNav(this,
                R.id.fl_show_fragment,
                new CNav.CNavFragment[]{
                    new CNavFragment(new LoginFragment(),true),
                    new CNavFragment(new RegisterFragment(),false)
                },
                LoginFragment.class);
        }

        findViewById(R.id.btn_goto_login).setOnClickListener(this::goTo);
        findViewById(R.id.btn_goto_register).setOnClickListener(this::goTo);
    }

    @SuppressLint("NonConstantResourceId")
    public void goTo(View v){
        switch (v.getId()){
            case R.id.btn_goto_login:
                cNav.showFragment(LoginFragment.class);
                break;
            case R.id.btn_goto_register:
                cNav.showFragment(RegisterFragment.class);
                break;
            default:
                cNav.showDefault();
        }
    }


}