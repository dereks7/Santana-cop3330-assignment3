package ex45;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Derek Santana
 */

import java.io.*;
import java.util.Scanner;

public class App
{
    public static void main(String[] args)throws IOException
    {
        Scanner scnr = new Scanner(System.in);
        String prev = "";
        String p = Prev(prev);
        String sub = "use";
        String s = Sub(sub,p);

        System.out.printf("What would you like the output file to be named? ");
        String out = scnr.nextLine();
        file(out,s);
    }

    public static String Prev(String prev)throws IOException
    {
        String line = "";

        try
        {
            File file = new File("src/main/java/ex45/exercise45_input.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null)
            {
                prev+=line + "\r\n";
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return prev;
    }

    public static String Sub(String s, String prev)
    {
        String sub = "";
        sub = prev.replaceAll("utilize",""+s);
        return sub;
    }

    public static void file(String name, String sub)throws IOException
    {
        try
        {
            name += ".txt";
            FileOutputStream outstrm = new FileOutputStream(name);
            byte[] strtobyte = sub.getBytes();
            outstrm.write(strtobyte);
            outstrm.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
