package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PrzedmiotTest {

    @Test
    public void DifferentIds() {
        int LowerBound = 1;
        int UpperBound = 10;
        int Bound = UpperBound - LowerBound + 1;
        int testWaga, testWart;
        Random Rand = new Random();
        ArrayList<Przedmiot> przedmioty = new ArrayList<>();
        for(int i=0; i<20; ++i) {
            przedmioty.add(new Przedmiot(LowerBound, Bound, Rand));
            testWaga = przedmioty.get(i).getWaga();
            testWart = przedmioty.get(i).getWartosc();

            assertTrue(LowerBound <= testWaga && testWaga <= UpperBound, "Waga w przedziale");
            assertTrue(LowerBound <= testWart && testWart <= UpperBound, "Wartość w przedziale");
        }
    }
}