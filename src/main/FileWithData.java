package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileWithData {
    public boolean write(String fileName, List<UserData> data) {
        try {
            File file = new File(fileName);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }

            FileWriter fileWriter = new FileWriter(fileName, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (var el : data) {
                printWriter.println(el.Town);
                printWriter.println(el.Name);
                printWriter.println(el.Surname);
                printWriter.println(el.Pesel);
            }
            printWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
