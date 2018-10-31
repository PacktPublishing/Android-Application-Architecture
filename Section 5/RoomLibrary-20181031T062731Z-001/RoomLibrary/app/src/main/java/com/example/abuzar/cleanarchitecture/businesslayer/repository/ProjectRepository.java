package com.example.abuzar.cleanarchitecture.businesslayer.repository;

import com.example.abuzar.cleanarchitecture.businesslayer.model.ProjectModel;

import java.util.List;


public interface ProjectRepository {
    List<ProjectModel> getProjectListing();
}
