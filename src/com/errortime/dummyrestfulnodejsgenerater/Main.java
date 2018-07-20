/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.errortime.dummyrestfulnodejsgenerater;

import static com.errortime.dummyrestfulnodejsgenerater.CloneApiConfig.getCloneApiConfigInstance;
import static com.errortime.dummyrestfulnodejsgenerater.Generator.generateWithCloneResponse;
import static com.errortime.dummyrestfulnodejsgenerater.Generator.generateWithPrototype;
import static com.errortime.dummyrestfulnodejsgenerater.HTTPRequest.sentHttpRequest;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author oem
 */
public class Main {
    private static void printTitle(){
        System.out.println("Dummy Restful Nodejs Generator");
    }
    
    private static void printProcessFinish(){
        System.out.println("Process finish!");
    }
    
    private static void printMenu() throws TemplateException, IOException{
        Scanner sc=new Scanner(System.in);  
        System.out.println("1. Generate with prototype");
        System.out.println("2. Clone response");
        System.out.println("3. Exit");
        System.out.print("Chose:");
        int choice = sc.nextInt();
        switch( choice ) {
            case 1:
                generateWithPrototype();
                printProcessFinish();
                printMenu();
                break;
            case 2:
                printCloneResponseMenu();
                break;
            case 3:
                System.out.println("3");
                break;
            default:
                System.out.println("No choice did you chose please try agian");
                printMenu();
        }
    }
    
    private static void printCloneResponseMenu() throws TemplateException, IOException{
        Scanner sc=new Scanner(System.in);  
        System.out.println("1. Clone response");
        System.out.println("2. Generate");
        System.out.println("3. Back");  
        System.out.print("Chose:");
        int choice = sc.nextInt();
        switch( choice ) {
            case 1:
                 sentHttpRequest();   
                 printCloneResponseMenu();
                 break;
            case 2:
                generateWithCloneResponse(); 
                printCloneResponseMenu();
                break;
            case 3:
                printMenu();
                break;
            default:
                System.out.println("No choice did you chose please try agian");
                printCloneResponseMenu();
        }
    }
    
    public static void main(String[] args) throws TemplateException, IOException {
        printTitle();
        printMenu();
    }
}
