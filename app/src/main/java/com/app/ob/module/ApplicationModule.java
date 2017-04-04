package com.app.ob.module;

import android.content.Context;

import com.app.ob.OBApplication;
import com.app.ob.executor.ParsingExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by niranjan on 04/04/17.
 */
@Module
public class ApplicationModule {

    private final OBApplication obApplication;

    public ApplicationModule(OBApplication obApplication) {
        this.obApplication = obApplication;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return obApplication;
    }

    @Provides
    @Singleton
    ParsingExecutor providesParsingExecutor() {
        return new ParsingExecutor();
    }

}
