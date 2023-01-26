# <div align="center">HICX Technical Assignment Template</div>


This technical assessment involves designing and building the following JAVA application:

* A console application takes a directory path as argument.
* The application will then monitor the folder for existing files, as well new files, with the supported file extensions (e.g. txt, pdf, doc...).
* For each supported file, the application needs to process the file and print statistics on the console (e.g. number of special characters, number of words...).
* After that, each processed file should be moved to a "processed" sub-folder inside the directory  that was passed as argument.
* Even though this is a simpler exercise treat it like a production situation and write the code that you would expect to deliver for a live system


The solution is built in java with Spring Framework and uses the follow libraries:


- Lombok :  https://mvnrepository.com/artifact/org.projectlombok/lombok




- Spring core : https://mvnrepository.com/artifact/org.springframework/spring-core



- JUnit :  https://mvnrepository.com/artifact/junit/junit



- Mockito Core : https://mvnrepository.com/artifact/org.mockito/mockito-core


## Overview



The main class is "MainApp" in this, the classes Extensions (which contains the accepted file types), FileEntity (which represents attributes of the file) and Analitycs(*) (wich has the methods asked) are initiliazed.

Then, the method run execute two functions :

* StorageFiles : store all the files that are in the recieved directory, and put that in a data structure.
* AnalitycsResponse : here the app prints the result of the 3 operations for each file


(*) We use an interface with an implementation class that works for txt files.





## Analitycs Methods




### Number of words:
* We use a File object to open the text file.
* We use a Scanner object to read the contents of the file, and use the next() method to read each word.
* We use a variable to keep count of the number of words read.
* Finally, we close the Scanner object and return the variable.




### Number of dots:
* We use a File object to open the text file.
* We use a Scanner object to read the contents of the file.
* We use a variable to keep count of the number of dots found in the file.
* We use the hasNext() method of the Scanner object to check if there is another line in the file, and the nextLine() method to read the line.
* We use the charAt() method to check each character in the line and check if it is a dot and increment the variable we use to count number of dots.
* Finally, we close the Scanner object when and return the variable.




### Most used word:
* We use a File object to open the text file.
* We use a Scanner object to read the contents of the file.
* Then, we split each line into words using the split() method of the String class.
* We create a HashMap to store the frequency of each word.
* Iterate through each word and add it to the HashMap, incrementing the frequency count if the word already exists in the map.
* Then, iterate towards the HashMap and keep track of the word with the highest frequency count.
* After we store the max frequency word, we validate if that variable is equals to "1" in order to check i there are not word repetead.
* Finally, if the variable is not "1" we return the most user word.



## Test Cases


For test we validate the following things:

* The app runs without error using mock files.
* The app crash out if the file does not exits.


## Execute the app


To execute the application you could grab the jar file in the path : out/artifacts/hicx_challenge_jar/hicx_challenge_jar.

Then, open the cmd or terminal and execute the following:

* java -jar hicx-challenge.jar  "{path where you have your txt files}"


<br/>  
