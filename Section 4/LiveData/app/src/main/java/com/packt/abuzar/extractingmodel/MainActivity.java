package com.packt.abuzar.extractingmodel;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.packt.abuzar.extractingmodel.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    ActivityMainBinding binding;
    MainAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        arrayAdapter = new MainAdapter(this);
        binding.projectList.setAdapter(arrayAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        final MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        observeViewModel(viewModel);
    }

    private void observeViewModel(MainViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getProjectListObservable().observe(this, new Observer<List<ProjectModel>>() {
            @Override
            public void onChanged(@Nullable List<ProjectModel> projects) {
                if (projects != null) {
                    arrayAdapter.addItems(projects);
                }
            }
        });
    }
}
