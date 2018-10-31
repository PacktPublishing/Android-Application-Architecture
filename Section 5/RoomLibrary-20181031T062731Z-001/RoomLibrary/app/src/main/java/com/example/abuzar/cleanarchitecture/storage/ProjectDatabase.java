package com.example.abuzar.cleanarchitecture.storage;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.abuzar.cleanarchitecture.businesslayer.model.ProjectModel;

@Database(entities = {ProjectModel.class}, version = 1)
public abstract class ProjectDatabase extends RoomDatabase {


    private static ProjectDatabase INSTANCE;

    public abstract ProjectDAO projectDAO();

    public static ProjectDatabase getProjectDatabaseInstance(Context context) {
        if (INSTANCE == null) {

            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ProjectDatabase.class, "project-database").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

    public static void destroyDatabaseInstance()
    {
        INSTANCE=null;
    }

}
