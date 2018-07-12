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
public class RouteRaw {
    private String method;
    private String[] path;
    private String[] parameter;
    private String response;

    public RouteRaw(String method, String[] path, String[] parameter, String response) {
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

    public String[] getPath() {
        return path;
    }

    public void setPath(String[] path) {
        this.path = path;
    }

    public String[] getParameter() {
        return parameter;
    }

    public void setParameter(String[] parameter) {
        this.parameter = parameter;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
    
}
