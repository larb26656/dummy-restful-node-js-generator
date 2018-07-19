/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.errortime.dummyrestfulnodejsgenerater.model.clonegenerate;

import java.util.ArrayList;

/**
 *
 * @author oem
 */
public class CloneTaskInfo {
    private ArrayList<RequestInfo> initData;

    public CloneTaskInfo(ArrayList<RequestInfo> initData) {
        this.initData = initData;
    }

    public ArrayList<RequestInfo> getInitData() {
        return initData;
    }
    
}
