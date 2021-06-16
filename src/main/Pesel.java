package main;

public class Pesel {

    public boolean isCorrect(String pesel) {
        int[] weights = {1,3,7,9,1,3,7,9,1,3};

        if(pesel.length() != 11) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Integer.parseInt(pesel.substring(i, i + 1)) * weights[i];
        }
        int checkDigit = Integer.parseInt(pesel.substring(10,11));
        sum %= 10;
        sum = 10 - sum;
        sum %= 10;

        return sum == checkDigit;
    }
}
