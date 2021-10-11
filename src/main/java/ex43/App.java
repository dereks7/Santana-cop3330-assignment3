package ex43;

import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Derek Santana
 */

public class App
{
    public static void main(String[] args) throws Exception
    {
        String name = getName();
        String author = getAuthor();
        char JS = jsFile();
        char CSS = cssFile();
        String path = "";
        String p = setPath(name,author,JS,CSS,path);
        files(name,author,JS,CSS,p);
    }

    public static String setPath(String n, String a, char JS, char CSS,String Path)
    {
        Path = System.getProperty("user.dir");
        Path += "\\"+n;
        File website = new File(Path);
        boolean createSite;
        createSite = website.mkdir();
        return Path;
    }

    public static void files(String n, String a, char JS, char CSS,String Path)
    {
        System.out.printf("Created %s%n",Path);
        try
        {
            FileWriter fw = new FileWriter(String.valueOf(new FileWriter(Path+"\\index.html")));
            // writing to file
            fw.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");
            fw.write("\t<meta author=\""+a+"\">\n");
            fw.write("\t<title>"+n+"</title>\n");
            fw.write("</head>\n<body>\n\n</body>\n</html>");
            fw.close();
            System.out.printf("Created %s\\index.html%n",Path);

            // if we want js fodler
            if(JS == 'y'||JS=='Y')
            {
                File JS_Folder = new File(Path+"\\js");
                boolean JS_Created = JS_Folder.mkdir();
                if(JS_Created)
                {
                    System.out.print("Created "+JS_Folder+"\\ \n");
                }
                else
                {
                    System.out.printf("JS Folder not made%n");
                }
            }

            //if we want css folder
            if(CSS == 'y'||CSS=='Y')
            {
                File CSS_Folder = new File(Path+"\\css");
                boolean CSS_Created = CSS_Folder.mkdir();
                if(CSS_Created)
                {
                    System.out.print("Created "+CSS_Folder+"\\ \n");
                }
                else
                {
                    System.out.printf("CSS Folder not made%n");
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("index.html not made");
        }
    }

    public static String getName()
    {
        Scanner scnr = new Scanner(System.in);
        System.out.printf("Website name: %n");
        String site = scnr.nextLine();
        return site;
    }

    public static String getAuthor()
    {
        Scanner scnr = new Scanner(System.in);
        System.out.printf("Author name: %n");
        String a = scnr.next();
        return a;
    }

    public static char jsFile()
    {
        Scanner scnr = new Scanner(System.in);
        char JS = 'N';
        System.out.printf("Do you want a folder for Java Script? %n");
        JS = scnr.next().charAt(0);
        return JS;
    }

    public static char cssFile()
    {
        Scanner scnr = new Scanner(System.in);
        char CSS = 'N';
        System.out.printf("Do you want a folder for CSS? %n");
        CSS = scnr.next().charAt(0);
        return CSS;
    }
}
