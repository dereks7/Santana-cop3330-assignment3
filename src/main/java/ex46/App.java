package ex46;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Derek Santana
 */

import java.io.*;
import java.util.*;

public class App
{
    public static void main(String[] args)throws IOException
    {
        try
        {
            String str = "";
            String s = searching(str);
            histogram(s);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String searching(String s) throws IOException
    {
        String str = "";
        try
        {
            File f = new File("src/main/java/ex46/exercise46_input.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            while((s = br.readLine()) != null)
            {
                str += s;
                str += " ";
            }
            br.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }

    public static void histogram(String str)
    {
        Map<String,Integer> m = new TreeMap<>();
        String s[] = str.split(" ");
        for (int i=0; i < s.length;i++)
        {
            if(m.containsKey(s[i]))
            {
                m.put(s[i],m.get(s[i])+1);
            }
            else
            {
                m.put(s[i],1);
            }
        }
        for(Map.Entry<String,Integer> entry: m.entrySet())
        {
            System.out.print(entry.getKey()+": ");
            for(int i=0; i < entry.getValue();i++)
            {
                System.out.print("*");
            }
            System.out.printf("%n");
        }
    }
}
