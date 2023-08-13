package com.example.testaplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Settings extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_settings,container,false);
        btnLogin = view.findViewById(R.id.LoginFr);
        btnSignUp = view.findViewById(R.id.SignUpFr);
        btnContact = view.findViewById(R.id.btnContact);
        btnSupport = view.findViewById(R.id.btnSupport);
        btnLanguage = view.findViewById(R.id.btnLanguge);
        btnSettings = view.findViewById(R.id.btnSettings);
        btnHistory = view.findViewById(R.id.btnhistory_view);
        btnFavorite = view.findViewById(R.id.btnfavorite);
        btnSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Mọi yêu cầu hỗ trợ xin gửi về gmail quocta.gov@gmail.com", Toast.LENGTH_SHORT).show();
            }
        });
        btnLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Chức năng đang được hoàn thiện", Toast.LENGTH_SHORT).show();
            }
        });
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), History.class);
                startActivity(intent);
            }
        });
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Contact Me");
                builder.setMessage("Gmail : quocta.gov@gmail.com \n" + "Number : 0943756357");
                builder.show();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SignUp.class);
                startActivity(intent);
            }
        });
        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ListFavorite.class);
                startActivity(intent);
            }
        });
        return view;
    }
    private Button btnLogin;
    private Button btnSignUp;
    private Button btnContact;
    private Button btnSettings;
    private Button btnHistory;
    private Button btnFavorite;
    private Button btnLanguage;
    private Button btnSupport;
}