/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.errortime.dummyrestfulnodejsgenerater.model;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Config {
    private String applicationName;
    private String version;
    private String author;
    private int port;
    private ArrayList<Route> routeList;

    public Config(String applicationName, String version, String author, int port, ArrayList<Route> routeList) {
        this.applicationName = applicationName;
        this.version = version;
        this.author = author;
        this.port = port;
        this.routeList = routeList;
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

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ArrayList<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(ArrayList<Route> routeList) {
        this.routeList = routeList;
    }
    
}
