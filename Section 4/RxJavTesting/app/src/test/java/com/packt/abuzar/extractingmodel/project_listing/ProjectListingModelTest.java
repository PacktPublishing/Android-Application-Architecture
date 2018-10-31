package com.packt.abuzar.extractingmodel.project_listing;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import io.reactivex.Observable;

import static org.junit.Assert.*;

public class ProjectListingModelTest {


    ProjectListingModel projectListingModel;
    Boolean val;
    List<ProjectModel> projectModelList;


    @Before
    public void setUp() throws Exception {

        projectListingModel = new ProjectListingModel();
    }

    @Test
    public void getProjectListObservable() {

        projectListingModel.getProjectListObservable()
                .subscribe(s -> {

                    this.projectModelList = s;
                });

        assertNotNull(projectModelList);
    }

    @Test
    public void isNetworkAvailable() {

        projectListingModel.isNetworkAvailable().subscribe(s -> {
            val = s;
        });
        assertTrue(val);

    }
}