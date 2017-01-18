/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.configs;

import com.library.datamodel.jaxb.config.v1_0.LayoutType;
import java.util.Map;

/**
 * We will use this Jobs COnfig class for all Jobs, not only the ad Fetcher Job
 * Tweek, add a constructor if necessary to suit other jobs
 *
 * @author smallgod
 */
public class DisplayLayoutConfig {

    private int nh;
    private int nw;
    private int nx;
    private int ny;
    private final Map<String, LayoutType> layoutMap;

    /**
     *
     * @param layoutMap
     */
    public DisplayLayoutConfig(Map<String, LayoutType> layoutMap) {
        this.layoutMap = layoutMap;

    }

    public Map<String, LayoutType> getLayoutMap() {
        return layoutMap;
    }

    /**
     * Get layout config for given layout name
     *
     * @param layoutName
     * @return
     */
    public LayoutType getLayoutConfig(String layoutName) {

        return this.layoutMap.get(layoutName);
    }

    

}
