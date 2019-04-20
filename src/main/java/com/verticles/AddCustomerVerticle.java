package com.verticles;

import io.vertx.core.AbstractVerticle;

public class AddCustomerVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        System.out.println("BasicVerticle started");
    }

    @Override
    public void stop() throws Exception {
        System.out.println("BasicVerticle stopped");
    }
}
