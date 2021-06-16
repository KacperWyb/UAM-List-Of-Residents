package main;

import java.util.Locale;
import java.util.Scanner;

public class Interactions {
    static Scanner input = new Scanner((System.in));

    public boolean askYorN(String question, String positive, String negative) {
        System.out.println(question + " " + positive + "/" + negative);
        String repeat = input.nextLine();

        while (true) {
            if (repeat.toLowerCase(Locale.ROOT).equals(positive))
                return true;
            if (repeat.toLowerCase(Locale.ROOT).equals(negative))
                return false;
        }
    }

    public UserData getAnswers() {
        UserData userData = new UserData(Interactions.enterName("Podaj Miasto: "),
                Interactions.enterName("Podaj imię: "),
                Interactions.enterName("Podaj Nazwisko: "),
                Interactions.enterName("Podaj numer PESEL: "));

        return userData;
    }

    public static String enterName(String question) {
        System.out.println(question);
        return input.nextLine();
    }
}
