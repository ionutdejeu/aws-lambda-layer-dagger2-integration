package com.ionutdejeu.adapters;

import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdapterAImpl implements AdapterA{

    private static final Logger LOGGER = LoggerFactory.getLogger(AdapterAImpl.class);


    @Inject
    public AdapterAImpl(){
        LOGGER.debug("AdapterAImpl Constructor");
    }
    public int getAdapterMethodA() {
        LOGGER.debug("AdapterAImpl::getAdapterMethodA");
        return 1989;
    }
}
