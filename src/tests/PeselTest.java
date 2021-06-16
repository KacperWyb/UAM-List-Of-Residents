package tests;

import main.Pesel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeselTest {

    @Test
    void isCorrect() {
        Pesel pesel = new Pesel();

        Assertions.assertTrue(pesel.isCorrect("01210907813"));
        Assertions.assertTrue(pesel.isCorrect("00240938611"));

        Assertions.assertFalse(pesel.isCorrect("123"));
        Assertions.assertFalse(pesel.isCorrect("ABC123"));
    }
}