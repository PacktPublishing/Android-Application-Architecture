package com.packt.abuzar.extractingmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.CountDownTimer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ProjectRepository {

    private static ProjectRepository projectRepository;
    List<ProjectModel> items = new ArrayList<>();

    private ProjectRepository() {
        //TODO this gitHubService instance will be injected using Dagger in part #2 ...
    }

    public synchronized static ProjectRepository getInstance() {
        //TODO No need to implement this singleton in Part #2 since Dagger will handle it ...
        if (projectRepository == null) {
            if (projectRepository == null) {
                projectRepository = new ProjectRepository();
            }
        }
        return projectRepository;
    }

    public void getProjectList(LiveData<List<ProjectModel>> projectListings) {


        Observable.range(0, 5)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        ProjectModel projectModel = new ProjectModel();
                        projectModel.title = "Project " + integer;
                        items.add(projectModel);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        final MutableLiveData<List<ProjectModel>> data = new MutableLiveData<>();
                        data.setValue(items);
                        MainViewModel.projectListings = data;
                    }
                });

    }

}
