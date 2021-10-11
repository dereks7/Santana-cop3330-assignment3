package ex41;

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

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Derek Santana
 */

public class App
{
    public static void main(String[] args) throws IOException
    {
        FileWriter fw = new FileWriter("src\\main\\java\\ex41\\exercise41_output.txt");
        List<String> names = Files.readAllLines(Paths.get("src\\main\\java\\ex41\\exercise41_input.txt"));

        java.util.Collections.sort(names); // using collection to sort the list alphabetically

        System.out.printf("Total of %d names%n-----------------%n",names.size()); // don't hardcode number of names
        fw.write("Total of "+names.size()+" names\n-----------------\n");

        for (int i = 0; i < names.size(); i++)
        {
            System.out.printf("%s%n",names.get(i));
            fw.write(names.get(i)+"\n");
        }
        fw.close();
    }
}
