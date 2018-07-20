/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.errortime.dummyrestfulnodejsgenerater;

import com.errortime.dummyrestfulnodejsgenerater.model.normalgenerate.PackageInfo;
import com.errortime.dummyrestfulnodejsgenerater.model.normalgenerate.ServerInfo;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import static com.errortime.dummyrestfulnodejsgenerater.APIConfig.getApiConfigInstance;
import static com.errortime.dummyrestfulnodejsgenerater.CloneApiConfig.getCloneApiConfigInstance;
import static com.errortime.dummyrestfulnodejsgenerater.HTTPRequest.getRoutesOut;
import static com.errortime.dummyrestfulnodejsgenerater.HTTPRequest.sentHttpRequest;
import com.errortime.dummyrestfulnodejsgenerater.model.normalgenerate.Route;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Generator {

    public static void generatePackageFile(PackageInfo packageInfo) throws MalformedTemplateNameException, TemplateException, IOException{
        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(Generator.class, "templates");
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Map<String, Object> input = new HashMap<>();
        input.put("packageInfo", packageInfo);
        Template template = cfg.getTemplate("package.ftl");
        StringWriter stringWriter = new StringWriter();
        template.process(input, stringWriter);
        File packageFile = new File("output/package.json");
        Writer fileWriter = new FileWriter(packageFile);
        try {
            template.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }        
    }
    
    public static void generateServerNormalFile(ServerInfo serverInfo) throws MalformedTemplateNameException, TemplateException, IOException{
        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(Generator.class, "templates");
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Map<String, Object> input = new HashMap<>();
        input.put("serverInfo", serverInfo);
        Template template = cfg.getTemplate("server_normal.ftl");
        StringWriter stringWriter = new StringWriter();
        template.process(input, stringWriter);
        File packageFile = new File("output/server.js");
        Writer fileWriter = new FileWriter(packageFile);
        try {
            template.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }        
    }
    
    public static void generateServerCloneFile(ArrayList<Route> RouteInfosList) throws MalformedTemplateNameException, TemplateException, IOException{
        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(Generator.class, "templates");
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Map<String, Object> input = new HashMap<>();
        input.put("routeInfosList", RouteInfosList);
        Template template = cfg.getTemplate("server_clone.ftl");
        StringWriter stringWriter = new StringWriter();
        template.process(input, stringWriter);
        File packageFile = new File("output/server.js");
        Writer fileWriter = new FileWriter(packageFile);
        try {
            template.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }        
    }
 
    public static void generateWithPrototype() throws TemplateException, IOException{
        getApiConfigInstance().readApiInfo();
        generatePackageFile(getApiConfigInstance().getPackageInfoOutput());
        generateServerNormalFile(getApiConfigInstance().getServerInfoOutput());        
    }
    
    public static void generateWithCloneResponse() throws TemplateException, IOException{
        getCloneApiConfigInstance().readApiInfo();
        generateServerCloneFile(getRoutesOut());
    }
   
}
