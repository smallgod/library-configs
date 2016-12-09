/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.configs;

import com.library.httpconnmanager.HttpClientPool;
import com.library.sgsharedinterface.SharedAppConfigIF;

/**
 *
 * @author smallgod
 */
public class JobsConfig {
    
    private HttpClientPool httpClientPool;
    private SharedAppConfigIF appConfigs;

    public HttpClientPool getHttpClientPool() {
        return httpClientPool;
    }

    public void setHttpClientPool(HttpClientPool httpClientPool) {
        this.httpClientPool = httpClientPool;
    }

    public SharedAppConfigIF getAppConfigs() {
        return appConfigs;
    }

    public void setAppConfigs(SharedAppConfigIF appConfigs) {
        this.appConfigs = appConfigs;
    }
}
