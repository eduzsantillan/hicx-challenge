package com.hicx.challenge;

import java.io.FileNotFoundException;

public interface IAnalitycs {

    int calculateNumWords(FileEntity fileToScan) throws FileNotFoundException;
    int calculateNumDots(FileEntity fileToScan) throws FileNotFoundException;
    String getMostUsedWord(FileEntity fileToScan) throws FileNotFoundException;

}
