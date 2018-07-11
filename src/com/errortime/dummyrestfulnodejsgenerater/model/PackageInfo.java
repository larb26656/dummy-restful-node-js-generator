/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.errortime.dummyrestfulnodejsgenerater.model;

/**
 *
 * @author Admin
 */
public class PackageInfo {
    private String applicationName;
    private String version;
    private String author;

    public PackageInfo(String applicationName, String version, String author) {
        this.applicationName = applicationName;
        this.version = version;
        this.author = author;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
