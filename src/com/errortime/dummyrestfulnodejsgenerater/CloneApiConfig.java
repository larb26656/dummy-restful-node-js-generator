/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.errortime.dummyrestfulnodejsgenerater;

import static com.errortime.dummyrestfulnodejsgenerater.HTTPRequest.setUrlEndpoint;
import com.errortime.dummyrestfulnodejsgenerater.model.clonegenerate.CloneTaskInfo;
import com.errortime.dummyrestfulnodejsgenerater.model.clonegenerate.RequestInfo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Admin
 */
public class CloneApiConfig {
    private static CloneApiConfig instanace;
    private final String CLONE_URL_INFO_FILE = "clone_url_info.xml";
    private final String ENDPOINT = "endpoint";
    private final String URL = "url";
    private final String URI = "uri";
    private final String METHOD = "method";
    private final String VALUE = "value";
    private CloneTaskInfo cloneTaskOutput;
//    private ServerInfo serverinfof;
//    private ServerInfo serverinfoFailTemp;
    
    
    private CloneApiConfig(){
    }
    
    public static CloneApiConfig getCloneApiConfigInstance(){
        if(instanace == null){
            instanace = new CloneApiConfig();
        }
        return instanace;        
    }
    
    public void readApiInfo(){
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            File xmlFile = new File(CLONE_URL_INFO_FILE);
            Document document = (Document) saxBuilder.build(xmlFile);
            Element rootElement = document.getRootElement();
            Element endpoint = rootElement.getChild(ENDPOINT);
            Element url = rootElement.getChild(URL);
            List<Element> uris = url.getChildren(URI);
            setUrlEndpoint(endpoint.getValue());
            ArrayList<RequestInfo> initData = new ArrayList<>();
            for(Element uri : uris){
                Attribute method = uri.getAttribute(METHOD);
                Attribute value = uri.getAttribute(VALUE);
                initData.add(new RequestInfo(method.getValue(),value.getValue()));
            }
            cloneTaskOutput = new CloneTaskInfo(initData);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JDOMException ex) {
            ex.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }      
    }

    public CloneTaskInfo getCloneTaskOutput() {
        return cloneTaskOutput;
    }

}
