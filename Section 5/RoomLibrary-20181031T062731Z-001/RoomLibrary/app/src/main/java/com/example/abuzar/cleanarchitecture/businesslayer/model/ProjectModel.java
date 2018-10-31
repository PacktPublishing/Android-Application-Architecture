package com.example.abuzar.cleanarchitecture.businesslayer.model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "project")
public class ProjectModel {


    @PrimaryKey(autoGenerate = true)
    private int projectId;

    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "desc")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
