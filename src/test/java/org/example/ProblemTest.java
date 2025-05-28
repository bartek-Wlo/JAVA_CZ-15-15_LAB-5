package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProblemTest {

    @Test
    public void OneItemCorrectMeanAtLeastOneInBag() {
        int size = 6;
        Problem prob = new Problem(30, 0, 5, 10, false);
        Result res =  prob.solve(size);
        ArrayList<Integer> Wagi =  prob.getWagi();
        for(Integer I : Wagi) {
            if(I <= size) assertEquals(res.getItemsNumber(), 1, "Jeżeli jakiś przedmiot jest <= size to torba powinna coś zawierać");
        }
    }

    @Test
    public void NoneItemCorrectMeanEmptyBag() {
        int size = 4;
        Problem prob = new Problem(30, 0, 5, 10, false);
        Result res =  prob.solve(size);
        ArrayList<Integer> Wagi =  prob.getWagi();
        assertEquals(res.getItemsNumber(), 0, "Torba powinna być pusta");

        size = 5;
        Problem prob2 = new Problem(30, 0, 5, 5, false);
        Result res2 =  prob2.solve(size);
        ArrayList<Integer> Wagi2 =  prob2.getWagi();
        assertFalse(res2.getItemsNumber() == 0,"Torba nie może być pusta");
    }

    @Test
    public void CorrectTotalWeightAndValue() {
        int size = 35;
        int itemsNumber = 30;
        Integer sumWartosc = 0, sumMasa = 0;
        Problem prob = new Problem(itemsNumber, 0, 5, 10, false);
        Result res = prob.solve(size);

        /**************************** sumy zapakowanych ****************************/
        ArrayList<Integer> Wartosc = res.getSpakowane_wartosc(); // Vector zapakowanych przedmiotów
        for(Integer I : Wartosc) sumWartosc += I;
        assertEquals(res.getTotalValue(), sumWartosc, String.format("Zgodność Wartosci ZAPAKOWANYCH, %d != %d",res.getTotalValue(),sumWartosc));

        ArrayList<Integer> Masy = res.getSpakowane_masa(); // Vector zapakowanych przedmiotów
        for(Integer I : Masy) sumMasa += I;
        assertEquals(res.getTotalMass(), sumMasa, String.format("Zgodność Mas ZAPAKOWANYCH, %d != %d",res.getTotalMass(),sumMasa));

        /**************************** ikisci zapakowanych ****************************/
        assertEquals(prob.getWagi().size(), itemsNumber, "Zgodność ilości przedmiotów - Result items number - Vector zapakowanych wag");
        assertEquals(prob.getWartosci().size(), itemsNumber, "Zgodność ilości przedmiotów - Result items number - Vector zapakowanych wartosci");
    }
}