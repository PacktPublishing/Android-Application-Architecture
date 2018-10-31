package com.example.abuzar.cleanarchitecture.storage;

import com.example.abuzar.cleanarchitecture.businesslayer.model.ProjectModel;
import com.example.abuzar.cleanarchitecture.businesslayer.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;


public class ProjectListingRepository implements ProjectRepository {

    @Override
    public List<ProjectModel> getProjectListing() {
        List<ProjectModel> projectModelList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            ProjectModel projectModel = new ProjectModel();
            projectModel.setTitle("Project " + i);
            projectModel.setDescription("Android Project sample");
            projectModelList.add(projectModel);
        }

        // let's simulate some network/database lag
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return projectModelList;
    }
}
