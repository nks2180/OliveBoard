package com.app.ob.component;

import com.app.ob.OBApplication;
import com.app.ob.activity.HomeScreenActivity;
import com.app.ob.module.ApplicationModule;
import com.app.ob.module.DatabaseModule;
import com.app.ob.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by niranjan on 04/04/17.
 */
@Singleton
@Component(modules={ApplicationModule.class, NetModule.class, DatabaseModule.class})
public interface ApplicationComponent {

    void inject(OBApplication materialApplication);

    void inject(HomeScreenActivity homeScreenActivity);
}
