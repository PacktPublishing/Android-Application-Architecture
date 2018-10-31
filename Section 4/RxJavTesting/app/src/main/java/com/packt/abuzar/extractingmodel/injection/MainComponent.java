package com.packt.abuzar.extractingmodel.injection;


import com.packt.abuzar.extractingmodel.project_listing.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ProjectModule.class)
public interface MainComponent {

    void inject(MainApplication mainApplication);

    void inject(MainPresenter mainPresenter);

}
