package com.example.thanhlong;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {
    static Database db;

    private EditText eName;
    private EditText ePassword;
    private Button bLogin;
    private TextView bChangeScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db= new Database(this);
        eName =findViewById(R.id.etname);
        ePassword=findViewById(R.id.etpass);
        bLogin=findViewById(R.id.btnregister);
        bChangeScreen=findViewById(R.id.loginaccount);



        bLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String inputName= eName.getText().toString();
                String inputPassword= ePassword.getText().toString();
                Boolean checkusername = db.ckUserName(inputName);

                if (checkusername==true){
                    Boolean insert= db.insert(inputName,inputPassword);
                    if (insert==true){
                        Toast.makeText(register.this,"Register successful!",Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(register.this,login.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(register.this,"Error!",Toast.LENGTH_SHORT).show();

                    }
                }else{
                    Toast.makeText(register.this,"Username exists!",Toast.LENGTH_SHORT).show();
                }


            }
        });


        bChangeScreen.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent=new Intent(register.this,login.class);
                startActivity(intent);

            }
        });
    }

}
