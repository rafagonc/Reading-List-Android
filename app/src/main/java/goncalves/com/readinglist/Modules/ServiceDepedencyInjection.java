package goncalves.com.readinglist.Modules;

import com.google.inject.AbstractModule;

import goncalves.com.readinglist.Server.Proxy.Abstract.ServiceProxy;
import goncalves.com.readinglist.Server.Proxy.Concrete.ServiceProxyImpl;

/**
 * Created by rafagonc on 1/16/16.
 */
public class ServiceDepedencyInjection extends AbstractModule {

    //region Injections
    @Override
    protected void configure() {
        bind(ServiceProxy.class).to(ServiceProxyImpl.class);
    }
    //endregion
}
