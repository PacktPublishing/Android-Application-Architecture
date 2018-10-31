package com.packt.abuzar.extractingmodel.list;

import android.app.Application;
import android.util.Log;

import com.packt.abuzar.extractingmodel.list.MainAdapter;
import com.packt.abuzar.extractingmodel.list.ProjectListModel;
import com.packt.abuzar.extractingmodel.list.ProjectModel;
import com.packt.abuzar.extractingmodel.list.ProjectRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ProjectModule {


    Application application;
    List<ProjectModel> items;

    public ProjectModule(Application application) {
        this.application = application;
    }


    @Provides
    @Singleton
    ProjectListModel provideProjectListModel() {
        return new ProjectListModel();
    }

    @Provides
    @Singleton
    MainAdapter provideMainAdapter() {
        return new MainAdapter(application.getApplicationContext());
    }

}
