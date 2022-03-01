package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnEntrar, btnShow;
    EditText edtLogin, edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEntrar = findViewById(R.id.btnEntrar);
        btnShow = findViewById(R.id.btnShow);
        edtLogin = findViewById(R.id.edtLogin);
        edtSenha = findViewById(R.id.edtSenha);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("key_geral", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("key_login", edtLogin.getText().toString());
                editor.apply(); // Confirmar as alterações do SharedPreference
                Toast.makeText(MainActivity.this, "Gravado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login;
                SharedPreferences prefs = getSharedPreferences("key_geral", MODE_PRIVATE);
                login = prefs.getString("key_login", "");
                Toast.makeText(MainActivity.this, login, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        String login;
        SharedPreferences prefs = getSharedPreferences("key_geral", MODE_PRIVATE);
        login = prefs.getString("key_login", "");
        edtLogin.setText(login);
    }
}