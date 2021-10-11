package ex42;
import java.util.Objects;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.io.FileWriter;
import java.io.File;
import java.util.Iterator;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Derek Santana
 */

/*
Ling,Mai,55900
Johnson,Jim,56500
Jones,Aaron,46000
Jones,Chris,34500
Swift,Geoffrey,14200
Xiong,Fong,65000
Zarnecki,Sabrina,51500



Last      First     Salary
--------------------------
Ling      Mai       55900
Johnson   Jim       56500
Jones     Aaron     46000
Jones     Chris     34500
Swift     Geoffrey  14200
Xiong     Fong      65000
Zarnecki  Sabrina   51500
 */


public class App
{
    public static void main(String[] args) throws IOException
    {

        FileWriter fw = new FileWriter("src\\main\\java\\ex42\\exercise42_output.txt");
        List<String> data = Files.readAllLines(Paths.get("src\\main\\java\\ex42\\exercise42_input.txt"));
        Character[] first = new Character[100];
        Character[] last = new Character[100];
        Character[] sal = new Character[100];
        System.out.printf("Last\tFirst\tSalary%n--------------------------%n");
        fw.write("Last\tFirst\tSalary%n--------------------------%n");
        String[] strnew = new String[data.size()];
        String strin = "";

        for(int i=0;i<data.size();i++)
        {
            strnew[i] = data.get(i).toString();
        }
        for(int i=0; i<data.size(); i++)
        {
            for(int j=0;j<data.get(i).length();j++)
            {
                if(strnew[i].charAt(j)!=',')
                {
                    first[i]=strnew[i].charAt(j);
                    System.out.printf("%c",first[i]);
                }
                else
                {
                    System.out.printf("\t");
                    for(int a=j+1;a<data.get(i).length();a++)
                    {
                        if(strnew[i].charAt(a)!=',')
                        {

                            last[i]=strnew[i].charAt(a);
                            System.out.printf("%c",last[i]);

                        }
                        else
                        {
                            System.out.printf("\t");
                            for(int u = a+1;u<data.get(i).length();u++)
                            {
                                if (strnew[i].charAt(u) != ',')
                                {

                                    sal[i] = strnew[i].charAt(u);
                                    System.out.printf("%c", sal[i]);
                                }
                                else
                                {
                                    System.out.printf("%n");
                                    break;
                                }
                            }
                            System.out.printf("%n");
                            break;
                        }
                    }
                    break;
                }
            }
        }
        fw.close();
    }
}
