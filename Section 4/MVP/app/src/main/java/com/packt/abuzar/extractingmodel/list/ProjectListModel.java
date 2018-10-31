package com.packt.abuzar.extractingmodel.list;

import android.arch.lifecycle.MutableLiveData;
import android.content.pm.ApplicationInfo;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class ProjectListModel {

    List<ProjectModel> projectModleList;
    public ProjectListModel() {
    }
    Observable<List<ProjectModel>> getProjectModelList() {
        projectModleList = new ArrayList<>();
        return Observable
                .range(0, 5)
                .subscribeOn(Schedulers.computation())
                .map(new Function<Integer, List<ProjectModel>>() {
                    @Override
                    public List<ProjectModel> apply(Integer integer) {

                        ProjectModel projectModel = new ProjectModel();
                        projectModel.title = "Project " + integer;
                        projectModleList.add(projectModel);
                        return projectModleList;
                    }
                });
    }
    Observable<Boolean> isNetworkAvailable() {
        return Observable.just(true);
    }

}
