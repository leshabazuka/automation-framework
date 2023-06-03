package org.Tsyulia.util;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfListFromFile {
    public static List<List<String>> convertFileWords(File file) throws IOException {
        List<List<String>> result = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine())!=null){
            String[] wordsArray = line.split("\\s+");
            List<String> wordsList = Arrays.asList(wordsArray);
            System.out.println(wordsList);
            result.add(wordsList);
        }
        bufferedReader.close();
        return result;
    }
}
