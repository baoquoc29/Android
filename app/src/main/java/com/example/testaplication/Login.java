package com.example.testaplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        mapping();
        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                final View alertLayout = inflater.inflate(R.layout.layoutforgotpass, null);
                final EditText textGmail = alertLayout.findViewById(R.id.gmail);
                Button send = alertLayout.findViewById(R.id.sendPass);
                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                builder.setView(alertLayout);
                builder.setCancelable(true);
                send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        FirebaseAuth auth = FirebaseAuth.getInstance();

                        auth.sendPasswordResetEmail(textGmail.getText().toString())
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(Login.this, "Mã Xác Nhận Đã Gửi Tới Email Của Bạn", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
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
                String email = user.getText().toString().trim();
                String password = pass.getText().toString().trim();
                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(Login.this, "Vui Long Nhap Day Du Thong Tin", Toast.LENGTH_SHORT).show();
                }
                else{
                    onClickLogin();
                }
            }
        });
    }
    private void onClickLogin(){
        String email = user.getText().toString().trim();
        String password = pass.getText().toString().trim();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(Login.this, "Đang Đăng Nhập....", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Login.this,MainActivity.class);
                                    startActivity(intent);
                                    finishActivity(1);
                                }
                            },3000);
                        }
                            else {

                            Toast.makeText(Login.this, "Tên Tài Khoản Hoặc Mật Khẩu Không Chính Xác", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
    public  void mapping(){
        user = findViewById(R.id.textUsername);
        pass = findViewById(R.id.textPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUpx);
        gmail = findViewById(R.id.edtGmail);
        forgotPass = findViewById(R.id.forgotPass);
    }
    private Button forgotPass;
    private TextView gmail;
    private TextView user;
    private TextView pass;
    private Button btnLogin;
    private Button btnSignUp;
}
