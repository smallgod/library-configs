/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.configs;

import com.library.sgsharedinterface.RemoteRequest;

/**
 *
 * @author smallgod
 */
public class DatabaseConfig {

    private final RemoteRequest remoteUnit;

    public DatabaseConfig(RemoteRequest remote) {
        this.remoteUnit = remote;
    }

    public RemoteRequest getRemoteUnit() {
        return remoteUnit;
    }

}
