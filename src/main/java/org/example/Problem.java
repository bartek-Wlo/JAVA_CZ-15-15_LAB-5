package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Problem {
    private ArrayList<Przedmiot> przedmioty = new ArrayList<>();
    private ArrayList<Integer> zabranie;
    private final Random Rand;

    public Problem(int N, int Seed, int LowerBound, int UpperBound, int size, boolean ifSeed) {
        if(ifSeed) Rand = new Random(Seed);
        else Rand = new Random();
        final int Bound = UpperBound - LowerBound + 1;
        for(int i=0; i<N; ++i) {
            przedmioty.add(new Przedmiot(LowerBound, Bound, Rand));
        }
        zabranie = new ArrayList<>(N);
        solve(size);
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i=0;
        sb.append("War / Wag = Cenn | zab z ilo\n");
        for(Przedmiot p : przedmioty) {
            sb.append(p.toString());
            sb.append(" | ");
            sb.append(String.format("%2d",zabranie.get(i)));
            sb.append(" z ");
            sb.append(String.format("%2d",p.getIlosc()));
            sb.append("\n");
            ++i;
        }
        sb.append("\n");
        return sb.toString();
    }

    private void solve(int size) {
        int filling = 0;
        przedmioty.sort(Comparator.comparing(Przedmiot::getCennosc).reversed());
        /** Wylosowana ilość przedmiotów odpowida posortowanej po cenności liście przedmiotów. **/
        int index;
        for(Przedmiot p : przedmioty) {
            zabranie.add(0);
            for(int i=0; i<p.getIlosc(); ++i) {
                if(filling + p.getWaga() <= size) {
                    filling += p.getWaga();
                    index = zabranie.size() - 1;
                    zabranie.set(index, zabranie.get(index) + 1);
                } else break;
            }
        }
    }
}
