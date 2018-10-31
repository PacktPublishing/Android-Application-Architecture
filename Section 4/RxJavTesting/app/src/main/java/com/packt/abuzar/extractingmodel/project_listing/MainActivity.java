package com.packt.abuzar.extractingmodel.project_listing;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import com.packt.abuzar.extractingmodel.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements LifecycleOwner, MainContractor.MainView {


    MainAdapter arrayAdapter;

    @BindView(R.id.project_list)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        arrayAdapter = new MainAdapter(this);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();


        final MainPresenter mainPresenter = ViewModelProviders.of(this).get(MainPresenter.class);
        mainPresenter.setUpPresenter(this);
        observeViewModel(mainPresenter);
    }

    private void observeViewModel(MainPresenter mainPresenter) {
        // Update the list when the data changes
        mainPresenter.getProjectListObservable().observe(this, new Observer<List<ProjectModel>>() {
            @Override
            public void onChanged(@Nullable List<ProjectModel> projects) {
                if (projects != null) {
                    arrayAdapter.addItems(projects);
                }
            }
        });
    }
}
