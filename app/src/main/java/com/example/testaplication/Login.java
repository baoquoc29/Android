package com.example.testaplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        mapping();
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,SignUp.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = user.getText().toString().trim();
                String password = pass.getText().toString().trim();

                String wherClause = "where " + MyDataBase.COLUMN_USERNAME + " = '" + userName + "' and " + MyDataBase.COLUMN_PASSWORD + " = '" + password + "' ";
                String query = "select * from " + MyDataBase.TABLE_NAME + " " + wherClause;

                MyDataBase myDataBase = new MyDataBase(Login.this);
                Cursor cursor = myDataBase.get_data(query);

                String message = cursor.moveToNext() ? "dang nhap thanh cong" : "fail roi";

               Intent intent = new Intent(Login.this, MainActivity.class);
               intent.putExtra("thong bao", message);
               setResult(Activity.RESULT_OK, intent);
               finish();
            }
        });
    }
    public  void mapping(){
        user = findViewById(R.id.textUsername);
        pass = findViewById(R.id.textPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUpx);
        gmail = findViewById(R.id.edtGmail);
    }
    private TextView gmail;
    private TextView user;

    private TextView pass;
    private Button btnLogin;
    private Button btnSignUp;
}
