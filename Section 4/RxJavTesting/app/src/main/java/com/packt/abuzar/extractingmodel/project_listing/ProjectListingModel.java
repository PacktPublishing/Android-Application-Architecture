package com.packt.abuzar.extractingmodel.project_listing;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class ProjectListingModel {

    List<ProjectModel> projectModelList;

    public ProjectListingModel() {

    }


    Observable<List<ProjectModel>> getProjectListObservable() {


        projectModelList=new ArrayList<>();
        return Observable.range(0, 5)
                .map(new Function<Integer, List<ProjectModel>>() {
                    @Override
                    public List<ProjectModel> apply(Integer integer) throws Exception {

                        ProjectModel projectModel = new ProjectModel();
                        projectModel.title = "Project " + integer;
                        projectModelList.add(projectModel);
                        return projectModelList;
                    }
                });

    }

    Observable<Boolean> isNetworkAvailable() {
        return Observable.just(true);
    }


}
