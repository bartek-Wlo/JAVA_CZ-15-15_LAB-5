package org.example;

import java.util.Random;

public class Przedmiot {
    public Double getCennosc() {return cennosc;}
    public Integer getWaga() {return waga;}
    public Integer getWartosc() {return wartosc;}
    public Integer getIlosc() {return ilosc;}

    private final Integer wartosc;
    private final Integer waga;
    private final Double cennosc;
    private final Integer ilosc;

    public Przedmiot(int LowerBound, int Bound, Random Rand) {
        wartosc = Rand.nextInt(Bound) + LowerBound;
        waga = Rand.nextInt(Bound) + LowerBound;
        cennosc = (double)wartosc/waga;
        ilosc = Rand.nextInt(Bound) + LowerBound;
    }

    @Override
    public String toString() {
        return(String.format("%2d",wartosc)+ "  / " +String.format("%2d",waga)+ " = " +String.format("%2.3f",cennosc));
    }
}
