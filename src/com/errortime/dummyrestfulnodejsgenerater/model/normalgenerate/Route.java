/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.errortime.dummyrestfulnodejsgenerater.model.normalgenerate;

/**
 *
 * @author Admin
 */
public class Route {
    private String method;
    private String pathAndParameters;
    private String response;

    public Route(String method, String pathAndParameter, String response) {
        this.method = method;
        this.pathAndParameters = pathAndParameter;
        this.response = response;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPathAndParameter() {
        return pathAndParameters;
    }

    public void setPathAndParameter(String pathAndParameter) {
        this.pathAndParameters = pathAndParameter;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
    
}
