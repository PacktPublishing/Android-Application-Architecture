package com.packt.abuzar.extractingmodel.injection;

import android.app.Application;

import com.packt.abuzar.extractingmodel.list.ProjectModule;

public class MainApplication extends Application {

    private static MainApplication app;
    MainComponent mainComponent;

    public static MainApplication getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;

        initMainComponent();

          mainComponent.inject(this);
    }

    private void initMainComponent() {
        mainComponent = DaggerMainComponent.builder()
                .projectModule(new ProjectModule(this))
                .build();
    }

    public MainComponent getMainComponent() {
       return mainComponent;
    }
}
