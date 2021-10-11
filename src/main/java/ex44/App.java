package ex44;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Derek Santana
 */

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class App
{
    public static void main(String[] args)throws IOException
    {
        Scanner scnr = new Scanner(System.in);
        try
        {
            String str = scnr.nextLine();
            search(str);

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void search(String s) throws IOException
    {
        String str = "";
        try
        {
            File f = new File("src/main/java/ex44/exercise44_input.json");
            BufferedReader br = new BufferedReader(new FileReader(f));
            while((str = br.readLine()) != null)
            {
                if(str.contains(s))
                {
                    System.out.printf("Name: %s%n", s);
                }

                //toJson(); //??????
            }
            /*
            String[] sp = str.split("");
            for(int i=0; i < str.length();i++)
            {
                if(sp[i].contains("%f"))
                {
                    for(int j=i; j<i+4;j++)
                    {
                        System.out.printf("%s",sp[j]);
                    }
                }
            }*/
            br.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
