package com.bookly.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Main Dependency Injection Component, i. e. Injector Class
 * Created by cyn on 03/30/2017.
 */
@Singleton
@Component(modules = {BooklyModule.class})
public interface BooklyComponent {
}
