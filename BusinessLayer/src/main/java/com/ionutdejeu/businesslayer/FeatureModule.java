package com.ionutdejeu.businesslayer;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Module
public class FeatureModule {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeatureModule.class);

    public FeatureModule(){
        LOGGER.debug("FeatureModule::constructor called");
    }
    @Provides
    @Singleton
    FeatureA provideFeatureA(){
        LOGGER.debug("FeatureModule::provideFeatureA method called");
        return new FeatureAImpl();
    }
}
