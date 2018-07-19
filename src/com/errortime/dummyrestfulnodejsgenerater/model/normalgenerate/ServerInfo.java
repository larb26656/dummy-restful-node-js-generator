/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.errortime.dummyrestfulnodejsgenerater.model.normalgenerate;

import java.util.ArrayList;

/**
 *
 * @author oem
 */
public class ServerInfo {
    private int port;
    private ArrayList<Route> routeList;

    public ServerInfo(int port, ArrayList<Route> routeList) {
        this.port = port;
        this.routeList = routeList;
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
