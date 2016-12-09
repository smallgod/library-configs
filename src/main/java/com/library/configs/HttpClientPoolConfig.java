/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.configs;

/**
 *
 * @author smallgod
 */
public class HttpClientPoolConfig {

    private final int readTimeout;
    private final int connTimeout;
    private final int connPerRoute;
    private final int maxConnections;

    public HttpClientPoolConfig(int readTimeout, int connTimeout, int connPerRoute, int maxConnections) {
        this.readTimeout = readTimeout;
        this.connTimeout = connTimeout;
        this.connPerRoute = connPerRoute;
        this.maxConnections = maxConnections;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public int getConnTimeout() {
        return connTimeout;
    }

    public int getConnPerRoute() {
        return connPerRoute;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

}
