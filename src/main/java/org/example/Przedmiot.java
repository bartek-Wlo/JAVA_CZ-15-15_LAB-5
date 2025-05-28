package org.example;

import java.util.Random;

public class Przedmiot {
    public Double getCennosc() {return cennosc;}
    public Integer getWaga() {return waga;}
    public Integer getWartosc() {return wartosc;}
    public Integer getIlosc() {return ilosc;}
    public Integer getID() {return ID;}

    private final Integer wartosc;
    private final Integer waga;
    private final Double cennosc;
    private final Integer ilosc;
    private final Integer ID;
    static Integer new_id = 0;

    public Przedmiot(int LowerBound, int Bound, Random Rand) {
        wartosc = Rand.nextInt(Bound) + LowerBound;
        waga = Rand.nextInt(Bound) + LowerBound;
        cennosc = (double)wartosc/waga;
        ilosc = Rand.nextInt(Bound) + LowerBound;
        ID = new_id++;
    }

    @Override
    public String toString() {
        return(String.format("%2d. %2d  / %2d = %6.3f", ID, wartosc, waga, cennosc));
    }
}
