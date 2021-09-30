package com.eup.mvp_demo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.eup.mvp_demo.LoginInterface;
import com.eup.mvp_demo.LoginPricenter;
import com.eup.mvp_demo.R;
import com.eup.mvp_demo.databinding.ActivityMainBinding;
import com.eup.mvp_demo.model.User;

public class MainActivity extends AppCompatActivity implements LoginInterface {
    private ActivityMainBinding binding;
    private LoginPricenter mLoginPricenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();
    }

    private void initView() {
        mLoginPricenter = new LoginPricenter(this);
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickLogin();
            }
        });
    }

    private void clickLogin(){
        String email = binding.edtEmail.getText().toString();
        String password = binding.edtPassword.getText().toString();
        User user = new User(email,password);
        mLoginPricenter.login(user);
    }

    @Override
    public void loginSuccess() {
        binding.tvMessage.setVisibility(View.VISIBLE);
        binding.tvMessage.setTextColor(getResources().getColor(R.color.black));
        binding.tvMessage.setText("Login success");
    }

    @Override
    public void loginError() {
        binding.tvMessage.setVisibility(View.VISIBLE);
        binding.tvMessage.setText("Email or Password invalid");
    }
}