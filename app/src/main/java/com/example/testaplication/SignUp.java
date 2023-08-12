package com.example.testaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        MyDataBase db = new MyDataBase(this,MyDataBase.DATA_NAME,null,1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mapping();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = textUsername.getText().toString();
                String pass = textPassword.getText().toString();
                String gmail = textGmail.getText().toString();
                String repass = textRePassword.getText().toString();
                 if(checkBox.isChecked() && pass.equals(repass)){
                    db.Insert_Data(user,pass,gmail);
                    Toast.makeText(SignUp.this, "Thanh Cong", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SignUp.this, "Please Confirm CheckBox or Confirm Password ", Toast.LENGTH_SHORT).show();
                }


            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor data = db.get_data("Select * from Account");
                while(data.moveToNext()){
                    String username = data.getString(0);
                    String password = data.getString(1);
                    String gmailne = data.getString(2);
                    list.add(new Account(username,"Đây Là Thông Tin Bảo Mật"));
                    adapter = new ArrayAdapter(SignUp.this,android.R.layout.simple_expandable_list_item_1,list);
                    listView.setAdapter(adapter);
                }
            }
        });

    }
    public void mapping(){
            btnSignUp = findViewById(R.id.btnSignUpx);
            textUsername = findViewById(R.id.edtUsername);
            textPassword = findViewById(R.id.edtPassword);
            textRePassword = findViewById(R.id.edtRePassword);
            textGmail = findViewById(R.id.edtGmail);
            btnBack = findViewById(R.id.btnBack);
            checkBox = findViewById(R.id.checkboxconfirm);
            listView = findViewById(R.id.list_item);
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