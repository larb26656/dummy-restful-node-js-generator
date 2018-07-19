/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.errortime.dummyrestfulnodejsgenerater.model.clonegenerate;

/**
 *
 * @author oem
 */
public class Route {
    private String method;
    private String pathAndParameters;
    private String response;

    public Route(String method, String pathAndParameters, String response) {
        this.method = method;
        this.pathAndParameters = pathAndParameters;
        this.response = response;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPathAndParameters() {
        return pathAndParameters;
    }

    public void setPathAndParameters(String pathAndParameters) {
        this.pathAndParameters = pathAndParameters;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
    
}
