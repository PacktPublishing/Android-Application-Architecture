package com.packt.abuzar.extractingmodel;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.packt.abuzar.extractingmodel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new MainViewModel();
        MainAdapter arrayAdapter = new MainAdapter(this, viewModel);
        binding.projectList.setAdapter(arrayAdapter);
        binding.setViewModel(viewModel);
        setProjectList();
    }

    private void setProjectList() {
        viewModel.setProjectList();
    }
}
