package com.packt.abuzar.extractingmodel.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.CountDownTimer;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ProjectRepository {

    private static ProjectRepository projectRepository;
    List<ProjectModel> items;

    @Inject
    ProjectListModel projectListModel;


    @Inject
    public ProjectRepository() {
        //TODO this gitHubService instance will be injected using Dagger in part #2 ...
//        this.projectList = projectList;
    }


    public LiveData<List<ProjectModel>> getProjectList() {

        final MutableLiveData<List<ProjectModel>> data = new MutableLiveData<>();


        projectListModel.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable) {
                Log.d("no conn", "no connexion");
            }
        }).filter(isNetworkAvailable -> true).
                flatMap(isAvailable -> projectListModel.getProjectModelList()).
                subscribe(heroes -> {
                            Log.d("ok loaded", "cccc");

                            items = (ArrayList<ProjectModel>) heroes;
                        }
                );

        CountDownTimer counter = new CountDownTimer(1000, 500) {
            public void onTick(long millisUntilDone) {
                //Nothing for now..... Just for waiting
            }

            public void onFinish() {
                data.setValue(items);
            }
        }.start();

        return data;
    }

}
