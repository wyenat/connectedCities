package com.cities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import static java.lang.System.exit;

/**
 * Parse the command line.
 */
public class CommandParser {
    private static void help(){
        System.out.print(
            "--Cities Connected help--\n"+
            "Required arguments: <filename> <cityname1> <cityname2> [verbose] where:\n" +
            "\tfilename: File containing the cities nodes. Please consult documentation for accepted formats.\n" +
            "\tcityname: Name of a city. Must be present in filename.\n" +
            "\tverbose: optional, set to true to print the command line."
        );
        exit(0);
    }

    public static void main(String[] args){
        if (args.length < 3){
            System.out.println("Incorrect command line. Expected at least 3 arguments but got " + args.length);
            help();
        }
        Connections cities = new Connections();
        FileParser parser = null;
        try {
            parser = new FileParser(args[0], cities);
        }
        catch (IOException e) {
            System.out.println("Couldn't read file at " + args[0] +"... " + e.getLocalizedMessage());
            help();
        }

        if (args.length==4 && args[3].contains("true")){
            System.out.println(Arrays.toString(args));
        }
        if (cities.isConnected(args[1].replace(" ",""), args[2].replace(" ", ""))){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
