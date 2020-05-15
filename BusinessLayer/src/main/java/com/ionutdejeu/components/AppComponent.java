package com.ionutdejeu.components;

import com.ionutdejeu.adapters.AdapterA;
import com.ionutdejeu.adapters.AdapterModule;
import com.ionutdejeu.businesslayer.FeatureA;
import com.ionutdejeu.businesslayer.FeatureModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {FeatureModule.class, AdapterModule.class})
public interface AppComponent {
    FeatureA getFeature();
    AdapterA getAdapter();
}
