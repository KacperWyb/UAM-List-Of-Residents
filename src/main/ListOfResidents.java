package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListOfResidents {

    public void startApp(String file) {
        Interactions interactions = new Interactions();
        List<UserData> listOfResidents = new ArrayList<UserData>();
        List<String> pesels = new ArrayList<String>();

        boolean canContinue = true;
        while (canContinue) {
            UserData answers = interactions.getAnswers();

            String actualPesel = answers.Pesel;

            Pesel pesel = new Pesel();
            if (!pesel.isCorrect(actualPesel)) {
                System.err.println("Podany numer PESEL jest niepoprawny.");
                canContinue = interactions.askYorN("Czy kontynuować?", "y", "n");
                continue;
            }

            if (pesels.contains(actualPesel)) {
                for (int i = 0; i < listOfResidents.size(); i++) {
                    UserData userData = listOfResidents.get(i);
                    if (userData.Pesel.equals(actualPesel)) {
                        System.out.println(userData.Town);
                        userData.Town = answers.Town;
                        System.out.println(userData.Town);
                        userData.Name = answers.Name;
                        userData.Surname = answers.Surname;
                    }
                }
            } else {
                pesels.add(actualPesel);
                listOfResidents.add(answers);
            }
            canContinue = interactions.askYorN("Czy kontynuować?", "y", "n");
        }

        FileWithData fileWithData = new FileWithData();
        fileWithData.write(file, listOfResidents);
    }
}
