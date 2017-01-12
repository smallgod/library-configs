/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.configs;

import com.library.sgsharedinterface.RemoteRequest;
import java.util.Map;

/**
 * We will use this Jobs COnfig class for all Jobs, not only the ad Fetcher Job
 * Tweek, add a constructor if necessary to suit other jobs
 *
 * @author smallgod
 */
public class JobsConfig {

    private final String jobTriggerName;
    private final String jobName;
    private final String jobGroupName;
    private final int repeatInterval;

    private final Map<String, RemoteRequest> remoteRequestUnits;

    /**
     *
     * @param jobTriggerName
     * @param jobName
     * @param jobGroupName
     * @param repeatInterval
     */
    public JobsConfig(String jobTriggerName, String jobName, String jobGroupName, int repeatInterval) {

        this(jobTriggerName, jobName, jobGroupName, repeatInterval, null);
    }

    /**
     *
     * @param jobTriggerName
     * @param jobName
     * @param jobGroupName
     * @param repeatInterval
     * @param remoteRequestUnit
     */
    public JobsConfig(String jobTriggerName, String jobName, String jobGroupName, int repeatInterval, Map<String, RemoteRequest> remoteRequestUnit) {

        this.jobTriggerName = jobTriggerName;
        this.jobName = jobName;
        this.jobGroupName = jobGroupName;
        this.repeatInterval = repeatInterval;

        this.remoteRequestUnits = remoteRequestUnit;
    }

    public String getJobTriggerName() {
        return jobTriggerName;
    }

    public String getJobName() {
        return jobName;
    }

    public String getJobGroupName() {
        return jobGroupName;
    }

    public int getRepeatInterval() {
        return repeatInterval;
    }

    public Map<String, RemoteRequest> getRemoteRequestUnits() {
        return remoteRequestUnits;
    }

}
