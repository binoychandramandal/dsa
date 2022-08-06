package com.array;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SlidingWindow1 {

    public static void main(String[] args) throws IOException {
        String filePath ="/Users/binoy.mandal/Downloads/input.json";
        String outputFilePath ="/Users/binoy.mandal/Downloads/output.json";
        List<String> lines= Files.readAllLines(Paths.get(filePath));
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(outputFilePath));
        lines= lines.stream().map(x->x.substring(x.indexOf("=>")+3,x.indexOf("with header=>"))).map(x->x.trim().replace("\n", "").replace("\r", "")).collect(Collectors.toList());
        Files.write(Paths.get(outputFilePath),lines);
        Files.readAllLines(Paths.get(outputFilePath)).forEach(System.out::println);
    }


}
