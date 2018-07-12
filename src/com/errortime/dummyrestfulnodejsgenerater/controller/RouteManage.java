/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.errortime.dummyrestfulnodejsgenerater.controller;

import com.errortime.dummyrestfulnodejsgenerater.model.Route;
import com.errortime.dummyrestfulnodejsgenerater.model.RouteRaw;
import java.util.ArrayList;
import java.util.StringJoiner;

/**
 *
 * @author Admin
 */
public class RouteManage {
    
    public static ArrayList<Route> getRoute(ArrayList<RouteRaw> routeRawTemps){
        ArrayList<Route> routeList = new ArrayList<>();
        for(RouteRaw routeRawTemp : routeRawTemps){
            String pathTemp = getPathFormat(routeRawTemp.getPath());
            String parameterTemp = getParameterFormat(routeRawTemp.getParameter());
            String pathAndParameters;
            if(pathTemp == null && parameterTemp == null){
                pathAndParameters = "/";
            }
            else if(pathTemp == null && parameterTemp != null){
                pathAndParameters = pathTemp;
            }
            else if(pathTemp != null && parameterTemp == null){
                pathAndParameters = parameterTemp;
            }
            else{
                pathAndParameters = pathTemp+"/"+parameterTemp;
            }
            routeList.add(new Route(routeRawTemp.getMethod(),pathAndParameters,routeRawTemp.getResponse()));
        }
        return routeList;
    }
    
    private static String getPathFormat(String[] values){
        if(values == null){
            return null;
        }
        if(values.length <= 0){
            return null;
        }
        StringJoiner valueBuilder = new StringJoiner("/");
        for(String value : values){
            valueBuilder.add(value);
        }
        return valueBuilder.toString();
    }
    
    private static String getParameterFormat(String[] values){
        if(values == null){
            return null;
        }
        if(values.length <= 0){
            return null;
        }
        StringJoiner valueBuilder = new StringJoiner("/");
        for(String value : values){
            String valueTemp = value+":";
            valueBuilder.add(valueTemp);
        }
        return valueBuilder.toString();
    }
    
}
