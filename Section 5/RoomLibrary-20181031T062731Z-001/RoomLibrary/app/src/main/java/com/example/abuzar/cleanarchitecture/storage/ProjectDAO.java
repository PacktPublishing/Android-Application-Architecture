package com.example.abuzar.cleanarchitecture.storage;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.abuzar.cleanarchitecture.businesslayer.model.ProjectModel;

import java.util.List;

@Dao
public interface ProjectDAO {


    @Query("SELECT * FROM project")
    List<ProjectModel> getProjectList();

    @Query("SELECT * FROM project where title LIKE :projectTitle")
    ProjectModel getProjectByTitle(String projectTitle);


    @Insert
    void insertProject(ProjectModel projectModel);

    @Delete
    void deleteProject(ProjectModel projectModel);


}
