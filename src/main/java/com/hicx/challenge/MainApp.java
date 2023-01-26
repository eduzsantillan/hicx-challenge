package com.hicx.challenge;

import org.springframework.util.StringUtils;

import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MainApp {

    private final Extensions extensions = new Extensions();
    Set<FileEntity> files = new HashSet<>();
    private final IAnalitycs analitycs = new AnalitycsImpl();
    private final String directory;



    MainApp(String directory) {
        this.directory=directory;
    }


    public void run(){

        storageFiles();
        analitycsResponse(files);
    }

    public void storageFiles(){
        File directory = new File(this.directory);
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isFile() &&
                    isFileExtensionValid(StringUtils.getFilenameExtension(file.getPath()))) {
                files.add(FileEntity.builder().
                        path(file.getPath())
                        .name(file.getName())
                        .directory(this.directory)
                        .build()
                        .withFileType());
            }
        }
    }

    void analitycsResponse(Set<FileEntity> files){
        for (FileEntity file : files) {
            try {
                String output ="";
                output = String.format("Analitycs for file %s \n Number of words: %s \n Number of dots : %s \n The most used word in this file is : %s",
                        file.getName(),
                        analitycs.calculateNumWords(file),
                        analitycs.calculateNumDots(file),
                        analitycs.getMostUsedWord(file));

                System.out.println(output + "\n*******************************************************************");
                file.moveToProccessed();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    boolean isFileExtensionValid(String extension){
        return extensions.getFileExtensions().contains(extension);
    }

}
