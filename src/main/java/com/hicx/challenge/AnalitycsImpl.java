package com.hicx.challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class AnalitycsImpl implements IAnalitycs {

    //Implementation for txt file type.

    @Override
    public int calculateNumWords(FileEntity fileToScan) throws FileNotFoundException {
        File file = new File(fileToScan.getPath());
        Scanner scanner = new Scanner(file);
        int count = 0;
        while (scanner.hasNext()) {
            scanner.next();
            count++;
        }
        scanner.close();
        return count;
    }

    @Override
    public int calculateNumDots(FileEntity fileToScan) throws FileNotFoundException {
        File file = new File(fileToScan.getPath());
        Scanner scanner = new Scanner(file);
        int count = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '.') {
                    count++;
                }
            }
        }
        scanner.close();
        return count;
    }

    @Override
    public String getMostUsedWord(FileEntity fileToScan)  throws FileNotFoundException{

        File file = new File(fileToScan.getPath());
        Scanner scanner = new Scanner(file);
        HashMap<String, Integer> frequency = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split(" ");

            for (String word : words) {
                if (frequency.containsKey(word)) {
                    int count = frequency.get(word);
                    frequency.put(word, count + 1);
                } else {
                    frequency.put(word, 1);
                }
            }
        }
        String mostUsedWord = null;
        int maxFrequency = 0;
        for (String word : frequency.keySet()) {
            if (frequency.get(word) > maxFrequency) {
                maxFrequency = frequency.get(word);
                mostUsedWord = word;
            }
        }
        scanner.close();
        if(maxFrequency== 1){
            return "No words repeated";
        }
        return mostUsedWord;

    }

}
