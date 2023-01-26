package com.hicx.challenge;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static org.junit.Assert.assertEquals;

public class AnalitycsTest {

    @Mock
    private FileEntity fileToScan;

    @Before
    public void setUp() throws FileNotFoundException {
        File file = new File("test.txt");
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println("This is a test.");
        printWriter.close();
        //get current directory
        String currentDirectory = System.getProperty("user.dir");
        fileToScan= FileEntity.builder().
                path(file.getPath())
                .name(file.getName())
                .directory(currentDirectory)
                .build()
                .withFileType();
    }

    @Test
    public void testCalculateNumWords() throws FileNotFoundException {
        AnalitycsImpl analitycs = new AnalitycsImpl();
        int numWords = analitycs.calculateNumWords(fileToScan);
        assertEquals(4, numWords);
    }

    @Test(expected = FileNotFoundException.class)
    public void testCalculateNumWordsException() throws FileNotFoundException {

        //test2.txt does not exist
        fileToScan.setPath(fileToScan.getDirectory()+"/test2.txt");

        AnalitycsImpl analitycs = new AnalitycsImpl();
        analitycs.calculateNumWords(fileToScan);
    }


    @Test
    public void testCalculateNumDots() throws FileNotFoundException {
        AnalitycsImpl analitycs = new AnalitycsImpl();
        int numDots = analitycs.calculateNumDots(fileToScan);
        assertEquals(1, numDots);
    }

    @Test(expected = FileNotFoundException.class)
    public void testCalculateNumDotsException() throws FileNotFoundException {

        //test2.txt does not exist
        fileToScan.setPath(fileToScan.getDirectory()+"/test2.txt");

        AnalitycsImpl analitycs = new AnalitycsImpl();
        analitycs.calculateNumDots(fileToScan);
    }

    @Test
    public void testGetMostUsedWordNoRepeated() throws FileNotFoundException {
        AnalitycsImpl analitycs = new AnalitycsImpl();
        String mostUsedWord = analitycs.getMostUsedWord(fileToScan);
        assertEquals("No words repeated", mostUsedWord);
    }


    @Test
    public void testGetMostUsedWord() throws FileNotFoundException {

        File newFile = new File("testNew.txt");
        PrintWriter printWriter = new PrintWriter(newFile);
        printWriter.println("This is a new file to determine the most used word, that is important. Test must return is");
        printWriter.close();

        fileToScan= FileEntity.builder().
                path(newFile.getPath())
                .name(newFile.getName())
                .build()
                .withFileType();

        AnalitycsImpl analitycs = new AnalitycsImpl();
        String mostUsedWord = analitycs.getMostUsedWord(fileToScan);
        assertEquals("is", mostUsedWord);
    }

    @Test(expected = FileNotFoundException.class)
    public void testGetMostUsedWordException() throws FileNotFoundException {

        //test2.txt does not exist
        fileToScan.setPath(fileToScan.getDirectory()+"/test2.txt");

        AnalitycsImpl analitycs = new AnalitycsImpl();
        analitycs.getMostUsedWord(fileToScan);
    }




}
