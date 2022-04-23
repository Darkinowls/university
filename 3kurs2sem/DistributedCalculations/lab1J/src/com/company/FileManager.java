package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FileManager {
    public static String PATH = "/home/denis/Documents/university/3kurs2sem/DistributedCalculations/lab1J/docs";

    public static List<String> getPaths() {
        File file = new File(PATH);
        return Arrays.stream(Objects.requireNonNull(file.list()))
                .filter(name -> name.endsWith(".txt"))
                .map(name -> PATH + "/" + name).toList();
    }

    public static String readFile(String path) {
        File file = new File(path);
        StringBuilder stringBuilder = new StringBuilder((int) file.length());
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int ch;
            while ((ch = br.read()) != -1) {
                stringBuilder.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static List<String> readFiles(List<String> paths) {
        return paths.stream().map(FileManager::readFile).toList();
    }

}
