package com.packt.abuzar.extractingmodel.project_listing;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.packt.abuzar.extractingmodel.injection.MainApplication;

import java.util.List;

import javax.inject.Inject;

public class MainPresenter extends AndroidViewModel implements MainContractor.MainPresenter {


    public final LiveData<List<ProjectModel>> projectListings;

    @Inject
    ProjectRepository projectRepository;

    MainContractor.MainView mainView;

    @Inject
    public MainPresenter(Application application) {
        super(application);
        MainApplication.getApp().getMainComponent().inject(this);
        projectListings = projectRepository.getProjectList();
    }

    @Override
    public void setUpPresenter(MainContractor.MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public LiveData<List<ProjectModel>> getProjectListObservable() {
        return projectListings;
    }
}
