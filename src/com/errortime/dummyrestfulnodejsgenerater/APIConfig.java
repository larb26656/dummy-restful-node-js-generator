/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.errortime.dummyrestfulnodejsgenerater;

import static com.errortime.dummyrestfulnodejsgenerater.controller.RouteManage.getRoute;
import com.errortime.dummyrestfulnodejsgenerater.model.normalgenerate.PackageInfo;
import com.errortime.dummyrestfulnodejsgenerater.model.normalgenerate.Route;
import com.errortime.dummyrestfulnodejsgenerater.model.normalgenerate.RouteRaw;
import com.errortime.dummyrestfulnodejsgenerater.model.normalgenerate.ServerInfo;
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
public class APIConfig {
    private static APIConfig instanace;
    private final String API_INFO_XML_FILE = "api_info.xml";
    private final String APPLICATION_NAME = "application_name";
    private final String VERSION = "version";
    private final String AUTHOR = "author";
    private final String SERVER_INFO = "server_info";
    private final String PORT = "port";
    private final String ROUTE_LIST = "route_list";
    private final String ROUTE = "route";
    private final String METHOD = "method";
    private final String PATH = "path";
    private final String NAME = "name";
    private final String PARAMETER = "parameter";
    private final String RESPONSE = "response";
    private PackageInfo packageInfoOutput;
    private final ArrayList<RouteRaw> routeRaw = new ArrayList<>();
    private ArrayList<Route> routeLists;
    private ServerInfo serverInfoOutput;
    
    
    private APIConfig(){
    }
    
    public static APIConfig getApiConfigInstance(){
        if(instanace == null){
            instanace = new APIConfig();
        }
        return instanace;        
    }
    
    public void readApiInfo(){
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            File xmlFile = new File(API_INFO_XML_FILE);
            Document document = (Document) saxBuilder.build(xmlFile);
            Element rootElement = document.getRootElement();
            Element applicationName = rootElement.getChild(APPLICATION_NAME);
            Element version = rootElement.getChild(VERSION);
            Element author = rootElement.getChild(AUTHOR);
            Element serverInfo = rootElement.getChild(SERVER_INFO);
            Element port = serverInfo.getChild(PORT);
            Element routeList = serverInfo.getChild(ROUTE_LIST);
            List<Element> routes = routeList.getChildren(ROUTE);
            packageInfoOutput = new PackageInfo(applicationName.getValue(),version.getValue(),author.getValue());
            for(Element route : routes){
                Attribute method = route.getAttribute(METHOD);
                Element path = route.getChild(PATH);
                Element parameter = route.getChild(PARAMETER);
                List<Element> namesPath = path.getChildren(NAME);
                List<Element> parametersPath = parameter.getChildren(NAME);
                ArrayList<String> namesPathsArrayList= new ArrayList<>();
                ArrayList<String> namesParametersArrayList= new ArrayList<>();
                Element response = route.getChild(RESPONSE);
                for(Element name : namesPath){
                    if(!name.getValue().isEmpty() || !name.getValue().equals("")){
                        namesPathsArrayList.add(name.getValue());
                    }
                }
                for(Element name : parametersPath){
                    if(!name.getValue().isEmpty() || !name.getValue().equals("")){
                        namesParametersArrayList.add(name.getValue());
                    }
                }
                routeRaw.add(new RouteRaw(method.getValue(),namesPathsArrayList,namesParametersArrayList,response.getValue()));
            }
            routeLists = getRoute(routeRaw);
            serverInfoOutput = new ServerInfo(Integer.parseInt(port.getValue()),routeLists);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JDOMException ex) {
            ex.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }      
    }
    

    public PackageInfo getPackageInfoOutput() {
        return packageInfoOutput;
    }

    public ServerInfo getServerInfoOutput() {
        return serverInfoOutput;
    }
    
}
