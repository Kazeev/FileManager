package org.barbecue.security;


import org.barbecue.module.account.rest.AccountRest;
import org.barbecue.module.file.rest.FileRest;
import org.glassfish.jersey.server.ResourceConfig;

public class CustomApplication extends ResourceConfig
{
    private static final String packages = "org.barbecue.module";

    public CustomApplication()
    {
        packages(packages);
        register(FileRest.class);
        register(AccountRest.class);

        //Register Auth Filter here
        register(AuthenticationFilter.class);
    }
}