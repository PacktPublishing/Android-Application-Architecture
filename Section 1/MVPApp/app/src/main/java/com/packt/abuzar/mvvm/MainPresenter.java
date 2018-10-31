package com.packt.abuzar.mvvm;

public class MainPresenter implements MainContractor.MainPresenter {


    MainContractor.MainView view;

    public MainPresenter(MainContractor.MainView view) {

        this.view = view;
    }

    @Override
    public void onButtonClick(String userName) {

        UserModel userModel=new UserModel();
        userModel.name=userName;

    }
}
