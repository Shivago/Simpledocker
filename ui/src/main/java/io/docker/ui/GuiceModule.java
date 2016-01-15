package io.docker.ui;

import com.google.inject.AbstractModule;
import io.docker.ui.services.OrderDeliveryDataService;
import io.docker.ui.services.ProductService;
import io.docker.ui.services.TabService;

import javax.inject.Singleton;

/**
 * Created by johnny on 1/15/16.
 */
public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(OrderDeliveryDataService.class).in(Singleton.class);
        bind(ProductService.class).in(Singleton.class);
        bind(TabService.class).in(Singleton.class);
    }
}
