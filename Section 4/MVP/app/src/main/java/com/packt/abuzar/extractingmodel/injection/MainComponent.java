package com.packt.abuzar.extractingmodel.injection;


import com.packt.abuzar.extractingmodel.list.MainPresenter;
import com.packt.abuzar.extractingmodel.list.ProjectModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ProjectModule.class)
public interface MainComponent {

    void inject(MainApplication mainApplication);

    void inject(MainPresenter mainPresenter);

}
