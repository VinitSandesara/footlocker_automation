package com.footlocker.core;


//import cucumber.runtime.java.picocontainer.PicoFactory;

import io.cucumber.core.backend.ObjectFactory;
import io.cucumber.picocontainer.PicoFactory;

public class PicoDependencyInjector implements ObjectFactory {

    private PicoFactory delegate = new PicoFactory();

    public PicoDependencyInjector() {
        addClass(PageContainer.class);
    }


    @Override
    public void start() {
        delegate.start();
    }

    @Override
    public void stop() {
        delegate.stop();
    }

    @Override
    public boolean addClass(Class<?> aClass) {
        return delegate.addClass(aClass);
    }

    @Override
    public <T> T getInstance(Class<T> aClass) {
        return delegate.getInstance(aClass);
    }
}

