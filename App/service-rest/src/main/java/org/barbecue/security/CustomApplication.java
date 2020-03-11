package org.barbecue.security;


import org.barbecue.module.file.rest.FileRest;
import org.glassfish.jersey.server.ResourceConfig;

public class CustomApplication extends ResourceConfig
{
    private static final String packages = "org.barbecue.module.file.rest";

    public CustomApplication()
    {
        packages(packages);
        register( FileRest.class);

        //Register Auth Filter here
        register(AuthenticationFilter.class);
    }
}