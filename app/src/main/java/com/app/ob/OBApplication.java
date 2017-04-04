package com.app.ob;

import android.app.Application;

import com.app.ob.component.ApplicationComponent;
import com.app.ob.component.DaggerApplicationComponent;
import com.app.ob.module.ApplicationModule;
import com.app.ob.module.DatabaseModule;
import com.app.ob.module.NetModule;


/**
 * Created by niranjan on 12/13/16.
 */
public class OBApplication extends Application {

    private static final String BASE_URL = "http://android.oliveboard.in/";

    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setApplicationComponent();
    }

    private void setApplicationComponent() {
        mComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .netModule(new NetModule(BASE_URL))
                .databaseModule(new DatabaseModule(this))
                .build();

        mComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return mComponent;
    }
}
