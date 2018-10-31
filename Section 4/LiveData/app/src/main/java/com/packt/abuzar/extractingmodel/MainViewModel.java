package com.packt.abuzar.extractingmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainViewModel extends AndroidViewModel {

    public static LiveData<List<ProjectModel>> projectListings;
    List<ProjectModel> items = new ArrayList<>();


    public MainViewModel(Application application) {
        super(application);

//        simpleAsync();
        // If any transformation is needed, this can be simply done by Transformations class ...
        ProjectRepository.getInstance().getProjectList(projectListings);
    }

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    public LiveData<List<ProjectModel>> getProjectListObservable() {
        return projectListings;
    }

}
