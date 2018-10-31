package com.example.abuzar.cleanarchitecture.businesslayer.interactors;


import com.example.abuzar.cleanarchitecture.businesslayer.model.ProjectModel;

import java.util.List;

public interface ProjectListingInteractor {

    interface Callback {
        void onProjectListRetrieved(List<ProjectModel> message);

        void onProjectListingFailed(String error);
    }

}
