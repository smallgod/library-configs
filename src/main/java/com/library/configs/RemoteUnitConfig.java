/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.configs;

import com.library.datamodel.Constants.NamedConstants;
import com.library.sgsharedinterface.RemoteRequest;
import java.util.Map;

/**
 *
 * @author smallgod
 */
public class RemoteUnitConfig {

    private final Map<String, RemoteRequest> remoteUnits;

    public RemoteUnitConfig(Map<String, RemoteRequest> remoteUnits) {
        this.remoteUnits = remoteUnits;
    }

    public RemoteRequest getAdDisplayRemoteUnit() {

        return getRemoteUnits().get(NamedConstants.ADDISPLAY_UNIT_REQUEST);
    }

    public RemoteRequest getAdCentralRemoteUnit() {

        return getRemoteUnits().get(NamedConstants.CENTRAL_UNIT_REQUEST);
    }

    public RemoteRequest getAdDbManagerRemoteUnit() {

        return getRemoteUnits().get(NamedConstants.ADDBManager_UNIT_REQUEST);
    }

    public RemoteRequest getDSMBridgeRemoteUnit() {

        return getRemoteUnits().get(NamedConstants.DSM_UNIT_REQUEST);
    }

    public Map<String, RemoteRequest> getRemoteUnits() {
        return remoteUnits;
    }

}
