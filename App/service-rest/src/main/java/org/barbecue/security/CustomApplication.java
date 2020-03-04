package org.barbecue.security;


import org.barbecue.module.file.rest.MyResource;
import org.glassfish.jersey.server.ResourceConfig;

public class CustomApplication extends ResourceConfig
{
    private static final String packages = "org.barbecue.module.file.rest";

    public CustomApplication()
    {
        packages(packages);
        register(MyResource.class);

        //Register Auth Filter here
        register(AuthenticationFilter.class);
    }
}