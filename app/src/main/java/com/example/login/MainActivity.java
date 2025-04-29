package com.example.login;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText eId;
    private EditText ePassword;
    private Button eLogin;
    private Button eSignup;
    private TextView eTextView;
    private String id;
    private String pw;
    private String tryid;
    private String trypw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        eId = (EditText) findViewById(R.id.editText1);
        ePassword = (EditText) findViewById(R.id.editText2);
        eLogin = (Button) findViewById(R.id.button);
        eSignup = (Button) findViewById(R.id.button2);
        eTextView = (TextView) findViewById(R.id.textView3);

    }


    public void signup(View v){
        id = eId.getText().toString();
        pw = ePassword.getText().toString();
        eTextView.setText(id+"\n"+pw+"\n"+"회원가입 되었습니다.");
    }
    public void login(View v) {
        tryid = eId.getText().toString();
        trypw = ePassword.getText().toString();
        if (tryid.equals(id)) {
            if (trypw.equals(pw)) {
                eTextView.setText(tryid + "\n" + trypw + "\n" + "로그인 되었습니다.");
            } else {
                eTextView.setText(tryid + "\n" + trypw + "\n" + "패스워드가 틀렸습니다.");
            }
        } else {
            eTextView.setText(tryid+"\n"+trypw+"\n"+"없는 아이디 입니다.");
        }
    }
}
