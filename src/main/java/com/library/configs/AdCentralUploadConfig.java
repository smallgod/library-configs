/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.configs;

import java.io.File;

/**
 *
 * @author smallgod
 */
public class AdCentralUploadConfig {

    private final String tempDir;
    private final String previewUrl;

    public AdCentralUploadConfig(String tempDir, String previewUrl) {
        this.tempDir = tempDir;
        this.previewUrl = previewUrl;
    }

    /**
     * @return the tempDir
     */
    public String getFileUploadDir() {
        return this.tempDir + File.separator + "uploads";
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

}
