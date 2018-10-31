package com.example.abuzar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view)
    {
        UserModel userModel=new UserModel();
        EditText etUserName=(EditText) findViewById(R.id.et_user_name);
        userModel.name=etUserName.getText().toString();

    }

}
