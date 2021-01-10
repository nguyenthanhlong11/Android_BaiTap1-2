package com.example.thanhlong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class login extends AppCompatActivity {
    Database db;
    private Button btnLogins;
    private TextView btRegister;
    private EditText inputUsername;
    private EditText inputPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db= register.db;
        btRegister= findViewById(R.id.createnewaccount);

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(login.this,register.class);
                startActivity(intent);
            }
        });
        btnLogins = findViewById(R.id.btnlogin);

        btnLogins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputUsername=findViewById(R.id.etusername);
                inputPassword=findViewById(R.id.etpassword);
                String eUsername = inputUsername.getText().toString();
                String ePassword= inputPassword.getText().toString();



                if (eUsername.isEmpty()||ePassword.isEmpty()){


                    Toast.makeText(login.this,"Please fill out all brach",Toast.LENGTH_SHORT).show();

                }else {

                    boolean isValid= db.ckLUserName(eUsername);
                    if(!isValid){
                        Toast.makeText(login.this,"Accout is not exists!",Toast.LENGTH_SHORT).show();

                    }else{
                        Boolean ckLogin=db.ckLogin(eUsername,ePassword);
                        if(ckLogin){
                            Toast.makeText(login.this,"ok!",Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent( login.this, MainActivity.class);
                            startActivityForResult( intent, 0);

                        }
                        else{
                            String u = db.ckusername(eUsername,ePassword);
                            Toast.makeText(login.this,"error!"+u,Toast.LENGTH_SHORT).show();

                        }
                    }}


            }
        });
    }
}