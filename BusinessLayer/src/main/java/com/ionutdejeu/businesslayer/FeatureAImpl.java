package com.ionutdejeu.businesslayer;

import com.ionutdejeu.adapters.AdapterAImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class FeatureAImpl implements FeatureA {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeatureAImpl.class);
    @Inject
    public FeatureAImpl(){
        LOGGER.debug("FeatureAImpl::Constructor");
    }
    public boolean executeFeatureAMethodB() {
        LOGGER.debug("FeatureAImpl::executeFeatureAMethodB return");
        return false;
    }
}
