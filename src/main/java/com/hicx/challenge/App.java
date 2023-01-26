package com.hicx.challenge;

import java.io.File;

public class App {
    public static void main(String[] args) {

        //validate if the directory exists
        File directory = new File(args[0]);
        if(! (directory.exists() && directory.isDirectory())){
            System.out.println("The directory does not exist");
            return;
        }
        MainApp app = new MainApp(args[0]);
        app.run();
    }

}
