package com.geeks.tilek_talaibekov_hw6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvEntrance = findViewById(R.id.entrance);
        TextView tvWelcome = findViewById(R.id.welcome);
        TextView tvRegister = findViewById(R.id.register);

        EditText etMail = findViewById(R.id.mail);
        EditText etPassword = findViewById(R.id.password);
        Button btnNext = findViewById(R.id.button);


        etMail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (etMail.getText().toString().isEmpty()){
                    btnNext.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.gray));
                }else{
                    btnNext.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
                }
            }
        });
        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(etPassword.getText().toString().isEmpty()){
                    btnNext.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.gray));
                }else{
                    btnNext.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
                }
            }
        });

        btnNext.setOnClickListener(v -> {
            if(etMail.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin")){
                tvEntrance.setVisibility(View.GONE);
                tvRegister.setVisibility(View.GONE);
                etMail.setVisibility(View.GONE);
                etPassword.setVisibility(View.GONE);
                btnNext.setVisibility(View.GONE);
                Toast.makeText(this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this,"Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
            }
        });
    }
}