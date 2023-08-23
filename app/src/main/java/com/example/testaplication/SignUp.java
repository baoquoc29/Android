package com.example.testaplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


import java.util.ArrayList;
import java.util.List;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mapping();
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = textPassword.getText().toString().trim();
                String repass = textRePassword.getText().toString().trim();
                if(!pass.equals(repass)){
                    Toast.makeText(SignUp.this, "Mật Khẩu Không Trùng Khớp Vui Lòng Nhập Lại", Toast.LENGTH_SHORT).show();
                }
                else if(!checkBox.isChecked()){
                    Toast.makeText(SignUp.this, "Vui Lòng Xác Nhận Đã Đủ 18 Tuoi", Toast.LENGTH_SHORT).show();
                }
                else{
                    clickSignUp();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this,Login.class);
                startActivity(intent);
                finishActivity(1);
            }
        });
    }
    public void mapping(){
            btnSignUp = findViewById(R.id.btnSignUpx);
            textPassword = findViewById(R.id.edtPassword);
            textGmail = findViewById(R.id.edtGmail);
            checkBox = findViewById(R.id.checkboxconfirm);
            textRePassword = findViewById(R.id.edtRePassword);
            btnBack = findViewById(R.id.btnLogin);
    }
    private void clickSignUp(){
        String password = textPassword.getText().toString().trim();
        String email = textGmail.getText().toString().trim();
       FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUp.this, "Sign Up Success", Toast.LENGTH_SHORT).show();
                            AlertDialog.Builder builder = new AlertDialog.Builder(SignUp.this);
                            builder.setTitle("Bạn Có Muốn Trở Về Đăng Nhập");
                            builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });
                            builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(SignUp.this,Login.class);
                                    startActivity(intent);
                                    finishActivity(1);
                                }
                            });
                            builder.show();
                        } else {
                            Toast.makeText(SignUp.this, "Tài Khoản Đã Tồn Tại Trong Hệ Thống", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }



    private CheckBox checkBox;
    private Button btnSignUp;
    private TextView textUsername;
    private TextView textPassword;
    private TextView textRePassword;
    private TextView textGmail;
    private ArrayAdapter adapter;
    private Button btnBack;
    private ListView listView;
    private  List<Account> list  = new ArrayList<>();

}