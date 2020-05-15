package com.ionutdejeu.adapters;

import com.sun.tracing.dtrace.ModuleName;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Module
public class AdapterModule {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdapterModule.class);

    public AdapterModule(){
        LOGGER.debug("AdapterModule::Constructor");
    }

    @Provides
    @Singleton
    AdapterA getAdapterA(){
        LOGGER.debug("AdapterModule::getAdapterA called");
        return new AdapterAImpl();
    }
}
