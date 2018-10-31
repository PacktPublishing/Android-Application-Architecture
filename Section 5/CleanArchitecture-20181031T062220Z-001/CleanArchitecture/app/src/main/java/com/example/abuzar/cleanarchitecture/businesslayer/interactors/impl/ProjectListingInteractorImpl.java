package com.example.abuzar.cleanarchitecture.businesslayer.interactors.impl;

import com.example.abuzar.cleanarchitecture.businesslayer.interactors.ProjectListingInteractor;
import com.example.abuzar.cleanarchitecture.businesslayer.model.ProjectModel;
import com.example.abuzar.cleanarchitecture.businesslayer.repository.ProjectRepository;

import java.util.List;


public class ProjectListingInteractorImpl implements ProjectListingInteractor {

    private ProjectListingInteractor.Callback mCallback;
    private ProjectRepository mProjectRepository;

    public ProjectListingInteractorImpl(
            Callback callback, ProjectRepository messageRepository) {
        mCallback = callback;
        mProjectRepository = messageRepository;
    }

    private void notifyError() {


        mCallback.onProjectListingFailed("Projects list are empty :(");
    }

    private void postMessage(List<ProjectModel> msg) {
        mCallback.onProjectListRetrieved(msg);
    }


    public void getData() {
        // retrieve the message
        final List<ProjectModel> projectLists = mProjectRepository.getProjectListing();

        if (projectLists == null || projectLists.size() == 0) {

           notifyError();

            return;
        }

        postMessage(projectLists);
    }

}
