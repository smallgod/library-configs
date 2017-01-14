/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.configs;

import com.library.datamodel.Constants.NamedConstants;

/**
 *
 * @author smallgod
 */
public class DSMStorageConfig {

    private final String dsm8WebAppHome;
    private final String xsdFilesDir;

    public DSMStorageConfig(String dsm8WebAppHome, String xsdFilesDir) {
        this.dsm8WebAppHome = dsm8WebAppHome;
        this.xsdFilesDir = xsdFilesDir;
    }

    /**
     * @return the dsm8WebAppHome
     */
    public String getDsm8WebAppHome() {
        return dsm8WebAppHome;
    }

    /**
     * @return the xsdFilesDir
     */
    public String getXsdFilesDir() {
        return xsdFilesDir;
    }

    public int getCustomerId() {
        return NamedConstants.CUSTOMER_ID;
    }

}
