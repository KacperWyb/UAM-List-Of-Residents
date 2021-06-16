package tests;

import main.FileWithData;
import main.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FileWithDataTest {

    @Test
    void write() {
        String fileName = "testFile.txt";
        boolean work = true;
        UserData userData = new UserData("Poznań123","Kacper","Wybierała","01210907813");
        List<UserData> listOfResidents = new ArrayList<>();
        List<String> dataFromProgram = new ArrayList<>();
        List<String> finalListFromProgram = new ArrayList<>();

        listOfResidents.add(userData);

        FileWithData fileWithData = new FileWithData();
        fileWithData.write(fileName, listOfResidents);

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                dataFromProgram.add(line);
            }
            scanner.close();
            Files.delete(Paths.get(fileName));
        } catch (FileNotFoundException e) {
            work = false;
            e.printStackTrace();
        } catch (IOException e) {
            work = false;
            e.printStackTrace();
        }

        for(var el : listOfResidents) {
            finalListFromProgram.add(el.Town);
            finalListFromProgram.add(el.Name);
            finalListFromProgram.add(el.Surname);
            finalListFromProgram.add(el.Pesel);
        }

        if (!dataFromProgram.equals(finalListFromProgram)) {
            System.out.println("Listy różnią się!");
            work = false;
        }

        Assertions.assertTrue(work);
    }
}
