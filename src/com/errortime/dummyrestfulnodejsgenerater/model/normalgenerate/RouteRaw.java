/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.errortime.dummyrestfulnodejsgenerater.model.normalgenerate;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class RouteRaw {
    private String method;
    private ArrayList<String> path;
    private ArrayList<String> parameter;
    private String response;

    public RouteRaw(String method, ArrayList<String> path, ArrayList<String> parameter, String response) {
        this.method = method;
        this.path = path;
        this.parameter = parameter;
        this.response = response;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public ArrayList<String> getPath() {
        return path;
    }

    public void setPath(ArrayList<String> path) {
        this.path = path;
    }

    public ArrayList<String> getParameter() {
        return parameter;
    }

    public void setParameter(ArrayList<String> parameter) {
        this.parameter = parameter;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
    
}
