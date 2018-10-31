package com.packt.abuzar.mvvm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements MainContractor.MainView {


    MainPresenter mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter=new MainPresenter(this);
    }

    public void onButtonClick(View view)
    {

        EditText etUserName=(EditText) findViewById(R.id.user_name);
        mainPresenter.onButtonClick(etUserName.getText().toString());
    }


}
