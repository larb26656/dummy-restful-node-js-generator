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
public class Route {
    private enum Method {
        get,post,put,delete
    }
    private String[] path;
    private String[] parameter;
    private String response;
}
