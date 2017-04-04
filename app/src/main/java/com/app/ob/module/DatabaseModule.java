package com.app.ob.module;

import android.content.Context;

import com.app.ob.DBAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by niranjan on 04/04/17.
 */
@Module
public class DatabaseModule {

    private final Context context;

    public DatabaseModule(Context context){
        this.context = context;
    }

    @Provides
    @Singleton
    DBAdapter.DatabaseHelper provideDBHelper() {
        return new DBAdapter.DatabaseHelper(context);
    }


    @Provides
    @Singleton
    DBAdapter providesDBAdapter(DBAdapter.DatabaseHelper databaseHelper) {
        return new DBAdapter(context,databaseHelper);
    }


}
