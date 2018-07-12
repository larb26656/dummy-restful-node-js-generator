/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.errortime.dummyrestfulnodejsgenerater;

import static com.errortime.dummyrestfulnodejsgenerater.Config.getInstance;
import com.errortime.dummyrestfulnodejsgenerater.model.PackageInfo;
import com.errortime.dummyrestfulnodejsgenerater.model.ServerInfo;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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
        Writer consoleWriter = new OutputStreamWriter(System.out);
        template.process(input, consoleWriter);
        File packageFile = new File("output/package.json");
        Writer fileWriter = new FileWriter(packageFile);
        try {
            template.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }        
    }
    
      public static void generateServerFile(ServerInfo serverInfo) throws MalformedTemplateNameException, TemplateException, IOException{
        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(Generator.class, "templates");
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Map<String, Object> input = new HashMap<>();
        input.put("serverInfo", serverInfo);
        Template template = cfg.getTemplate("server.ftl");
        Writer consoleWriter = new OutputStreamWriter(System.out);
        template.process(input, consoleWriter);
        File packageFile = new File("output/server.js");
        Writer fileWriter = new FileWriter(packageFile);
        try {
            template.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }        
    }
        
    public static void main(String[] args) throws TemplateException, IOException {
//        PackageInfo packageInfo = new PackageInfo("Test","1.0.0","ErrorTime");
//        ArrayList<RouteRaw> routeRaw = new ArrayList<>();
//        String[] path= {"sds","dsds"};
//        String [] parameter = {"sds","dsds"};
//        routeRaw.add(new RouteRaw("post",path,parameter,"sss"));
//        ArrayList<Route> route = getRoute(routeRaw);
//        ServerInfo serverInfo = new ServerInfo(8000,route);
        getInstance().readApiInfo();
        generatePackageFile(getInstance().getPackageInfoOutput());
        generateServerFile(getInstance().getServerInfoOutput());
    }
}
