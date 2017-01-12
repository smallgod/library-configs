/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.configs.utils;

import com.library.configs.DSMAdXpoBridgeConfigs;
import com.library.configs.DatabaseConfig;
import com.library.configs.HttpClientPoolConfig;
import com.library.configs.JettyServerConfig;
import com.library.configs.JobsConfig;
import com.library.datamodel.Constants.NamedConstants;
import com.library.sgsharedinterface.RemoteRequest;
import com.library.sgsharedinterface.SharedAppConfigIF;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author smallgod
 */
public class ConfigLoader {

    private final SharedAppConfigIF appConfig;

    public ConfigLoader(SharedAppConfigIF appConfig) {
        this.appConfig = appConfig;
    }

    /**
     * Get config parameters for the Ad Fetcher Job 
     * 
     * @return 
     */
    public JobsConfig getAdFetcherJobConfig() {

        String triggerName = appConfig.getAdFetcherTriggerName();
        String jobName = appConfig.getAdFetcherJobName();
        String groupName = appConfig.getAdFetcherGroupName();
        int repeatInterval = appConfig.getAdFetcherInterval();
        
        RemoteRequest dsmBridgeUnit = appConfig.getDSMBridgeUnit();
        RemoteRequest centralUnit = appConfig.getAdCentralUnit();
        
        Map<String, RemoteRequest> remoteUnits = new HashMap<>();
        
        remoteUnits.put(NamedConstants.DSM_UNIT_REQUEST, dsmBridgeUnit);
        remoteUnits.put(NamedConstants.CENTRAL_UNIT_REQUEST, centralUnit);

        JobsConfig jobConfig = new JobsConfig(triggerName, jobName, groupName, repeatInterval, remoteUnits);

        return jobConfig;
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
     * Get the config parameters for the Database setup
     *
     * @return
     */
    public DatabaseConfig getDatabaseConfig() {

        RemoteRequest remote = appConfig.getAdDbManagerUnit();

        DatabaseConfig databaseConfig = new DatabaseConfig(remote);

        return databaseConfig;
    }

    /**
     * Get the configuration parameters for the DSM8-AdvertXpo Bridge
     * application
     *
     * @return
     */
    public DSMAdXpoBridgeConfigs getDSMAdXpoBridgeConfigs() {

        String webAppHomeDir = appConfig.getDsmWebAppDir();
        String xsdFilesDir = appConfig.getXsdFilesDir();

        DSMAdXpoBridgeConfigs config = new DSMAdXpoBridgeConfigs(webAppHomeDir, xsdFilesDir);
        return config;
    }

    /**
     * Get the config parameters for the AdDisplayProcessor Unit
     *
     * @return
     
    public AdDisplayProcessorConfig getAdDisplayProcessorConfig() {

        String adFetchJobTriggerName = appConfig.getAdFetcherTriggerName();
        String adFetchJobName = appConfig.getAdFetcherJobName();
        String adFetchJobGroupName = appConfig.getAdFetcherGroupName();

        AdDisplayProcessorConfig adDisplayProcConfig = new AdDisplayProcessorConfig(adFetchJobTriggerName, adFetchJobName, adFetchJobGroupName);

        return adDisplayProcConfig;
    }
    * */
}
