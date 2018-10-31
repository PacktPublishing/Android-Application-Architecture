package com.packt.abuzar.extractingmodel.injection;

import android.app.Application;

import com.packt.abuzar.extractingmodel.project_listing.MainAdapter;
import com.packt.abuzar.extractingmodel.project_listing.ProjectListingModel;
import com.packt.abuzar.extractingmodel.project_listing.ProjectModel;
import com.packt.abuzar.extractingmodel.project_listing.ProjectRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ProjectModule {


    Application application;

    public ProjectModule(Application application) {
        this.application = application;
    }



    @Provides
    @Singleton
    ProjectListingModel provideProjectListModel() {
        return new ProjectListingModel();
    }

    @Provides
    @Singleton
    MainAdapter provideMainAdapter() {
        return new MainAdapter(application.getApplicationContext());
    }

}
