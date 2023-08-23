package com.example.testaplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePassword extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        user = findViewById(R.id.user);
        pass = findViewById(R.id.password);
        repass = findViewById(R.id.passwordNew);
        change = findViewById(R.id.btnChangePass);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickChangePass();
            }
        });
    }
    private void onClickChangePass(){
        String newPassword = repass.getText().toString();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        user.updatePassword(newPassword)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ChangePassword.this, "Đổi mật khẩu thành công vui lòng đăng nhập lại", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ChangePassword.this,Login.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
    }
//    private void authVerification(){
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        AuthCredential credential = EmailAuthProvider
//                .getCredential(userverifi, passverifi);
//        user.reauthenticate(credential)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if(task.isSuccessful()){
//                            onClickChangePass();
//                        }
//                        else{
//                            Toast.makeText(ChangePassword.this, "Vui Lòng Nhập Đúng Thông Tin ", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//    }
//    public void openVerifiDialog(){
//        Button btnVerifi;
//        Dialog dialog = new Dialog(this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.customdialog);
//        Window window =  dialog.getWindow();
//        if(window == null){
//            return;
//        }
//        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
//        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        WindowManager.LayoutParams windowActibute = window.getAttributes();
//        window.setAttributes(windowActibute);
//        userverifi = dialog.findViewById(R.id.textUserVerifi);
//        passverifi = dialog.findViewById(R.id.textPasswordVerifi);
//        btnVerifi = dialog.findViewById(R.id.btnVerifi);
//        btnVerifi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onClickChangePass();
//            }
//        });
//        dialog.show();
//
//    }
    private EditText user;
    private EditText pass;
    private Button change;
    private EditText repass;
    private EditText userverifi;
    private EditText passverifi;
}