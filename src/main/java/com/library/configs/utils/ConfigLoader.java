/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.configs.utils;

import com.library.configs.DSMAdXpoBridgeConfigs;
import com.library.configs.HttpClientPoolConfig;
import com.library.configs.JettyServerConfig;
import com.library.configs.JobsConfig;
import com.library.sgsharedinterface.SharedAppConfigIF;

/**
 *
 * @author smallgod
 */
public class ConfigLoader {

    private final SharedAppConfigIF appConfig;

    public ConfigLoader(SharedAppConfigIF appConfig) {
        this.appConfig = appConfig;
    }

    public JobsConfig getJobsConfig() {
        //To-Do
        return null;
    }

    /**
     * Get the configuration parameters necessary for an HTTP Client Pool
     * connection
     *
     * @return
     */
    public HttpClientPoolConfig getHttpClientPoolConfig() {

        int readTimeout = appConfig.getReadTimeout();
        int connTimeout = appConfig.getConnTimeout();
        int connPerRoute = appConfig.getConnPerRoute();
        int maxConnections = appConfig.getMaxConnections();

        HttpClientPoolConfig clientPoolConfig = new HttpClientPoolConfig(readTimeout, connTimeout, connPerRoute, maxConnections);

        return clientPoolConfig;

    }

    /**
     * Get the configuration parameters necessary for a JETTY server setup
     *
     * @return
     */
    public JettyServerConfig getJettyServerConfig() {

        String contextPath = appConfig.getContextpath();
        String resourceBase = appConfig.getResourceDirAbsPath();
        String webDescriptor = resourceBase + appConfig.getWebxmlfile();
        int httpPort = appConfig.getHttpport();

        JettyServerConfig serverConfig = new JettyServerConfig(contextPath, resourceBase, webDescriptor, httpPort);

        return serverConfig;
    }

    /**
     * Get the configuration parameters for the DSM8-AdvertXpo Bridge
     * application
     *
     * @return
     */
    public DSMAdXpoBridgeConfigs getDSMAdXpoBridgeConfigs() {

        String webAppHomeDir = appConfig.getDsmWebAppDir();
        DSMAdXpoBridgeConfigs config = new DSMAdXpoBridgeConfigs(webAppHomeDir);
        return config;
    }
}
