package com.cities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Given a file, generates a {@link Connections} structure.
 * File formats currently supported : txt
 */
public class FileParser {

    private final Connections cities;

    public FileParser(String filename, Connections cities) throws IOException {
        this.cities = cities;
        File f = new File(filename);
        if (f.length()>300000){
            System.err.println("Large file detected. If a stack overflow occures, you may need to increase the stack size, see README file to see how.");
        }
        Scanner fr = new Scanner(f);
        while (fr.hasNextLine()){
            String[] citiesAB = fr.nextLine().split(",");
            cities.addCityConnection(citiesAB[0].replace(" ", ""), citiesAB[1].replace(" ", ""));
        }
        fr.close();
    }

}
