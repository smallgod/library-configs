/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.configs.utils;

import com.library.configs.DSMStorageConfig;
import com.library.configs.DatabaseConfig;
import com.library.configs.DisplayLayoutConfig;
import com.library.configs.HttpClientPoolConfig;
import com.library.configs.JettyServerConfig;
import com.library.configs.JobsConfig;
import com.library.datamodel.Constants.NamedConstants;
import com.library.datamodel.Constants.ProgDisplayLayout;
import com.library.datamodel.jaxb.config.v1_0.LayoutContentType;
import com.library.datamodel.jaxb.config.v1_0.LayoutType;
import com.library.sgsharedinterface.RemoteRequest;
import com.library.sgsharedinterface.SharedAppConfigIF;
import com.library.utilities.FileUtilities;
import java.io.File;
import java.util.HashMap;
import java.util.List;
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
     * Get config params for the different display layout types
     * 
     * @return 
     */
    public DisplayLayoutConfig getDisplayLayoutConfig() {

        Map<String, LayoutType> layoutMap = new HashMap<>();

        List<LayoutType> layoutTypes = appConfig.getLayoutConfig();

        for (LayoutType layout : layoutTypes) {

            String layoutName = layout.getName();
            layoutMap.put(layoutName, layout);

        }

        DisplayLayoutConfig layoutConfig = new DisplayLayoutConfig(layoutMap);

        return layoutConfig;
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
    public DSMStorageConfig getDSMStorageConfigs() throws IllegalArgumentException, Exception {

        String webAppHomePath = appConfig.getDsmWebAppDir();
        String xsdFilesDir = appConfig.getXsdFilesDir();

        String webAppHomeDir = setWorkRootPath(webAppHomePath);

        DSMStorageConfig config = new DSMStorageConfig(webAppHomeDir, xsdFilesDir);
        return config;
    }

    /**
     * Sets the work root folder
     *
     * @param path the ROOT folder for the app
     */
    private String setWorkRootPath(String path) throws IllegalArgumentException, Exception {

        //String path = rootFolder + File.separatorChar + "gnamp_work";
        File dir = new File(path);
        path = dir.getAbsolutePath();

        if ((dir.exists()) && (!dir.isDirectory()) && (!dir.delete())) {
            throw new IllegalArgumentException("path is not directory, delete file error: " + path);
        }
        if (!dir.exists()) {

            if (!FileUtilities.createDirectory(path)) {
                throw new Exception("Failed to create dsm work root directory");
            }
        }
        String workRoot = path + File.separatorChar;

        return workRoot;
    }

    /**
     * Get the config parameters for the AdDisplayProcessor Unit
     *
     * @return
     *
     * public AdDisplayProcessorConfig getAdDisplayProcessorConfig() {
     *
     * String adFetchJobTriggerName = appConfig.getAdFetcherTriggerName();
     * String adFetchJobName = appConfig.getAdFetcherJobName(); String
     * adFetchJobGroupName = appConfig.getAdFetcherGroupName();
     *
     * AdDisplayProcessorConfig adDisplayProcConfig = new
     * AdDisplayProcessorConfig(adFetchJobTriggerName, adFetchJobName,
     * adFetchJobGroupName);
     *
     * return adDisplayProcConfig; }
     *
     */
}
