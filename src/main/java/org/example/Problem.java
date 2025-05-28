package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Problem {
    private ArrayList<Przedmiot> przedmioty = new ArrayList<>();
    private ArrayList<Integer> zabranie;
    private final Random Rand;
    private final Integer n;

    public Problem(int N, int Seed, int LowerBound, int UpperBound, boolean ifSeed) {
        if(ifSeed) Rand = new Random(Seed);
        else Rand = new Random();
        final int Bound = UpperBound - LowerBound + 1;
        n = N;
        for(int i=0; i<n; ++i) {
            przedmioty.add(new Przedmiot(LowerBound, Bound, Rand));
        }
        zabranie = new ArrayList<>(Collections.nCopies(n, 0));
    }

    @Override
    public String toString() {
        System.out.println("The number of item types: "+n);
        StringBuilder sb = new StringBuilder();
        int i=0;
        sb.append("id. War / Wag = Ceność | zab z ilości\n");
        for(Przedmiot p : przedmioty) {
            sb.append(p);
            sb.append(String.format(" | %3d z %2d\n", zabranie.get(i++), p.getIlosc()));
        }
        sb.append("\n");
        return sb.toString();
    }

    public Result solve(int size) {
        Result rozwiazanie = new Result();
        int filling = 0;
        przedmioty.sort(Comparator.comparing(Przedmiot::getCennosc).reversed());
        /** Wylosowana ilość przedmiotów odpowida posortowanej po cenności liście przedmiotów. **/
        int index = 0;
        zabranie.clear();
        for(Przedmiot p : przedmioty) {
            zabranie.add(0);
            for(int i=0; i<p.getIlosc(); ++i) {
                if(filling + p.getWaga() <= size) {
                    filling += p.getWaga();
                    zabranie.set(index, zabranie.get(index) + 1);
                    rozwiazanie.addItem(p.getID(), p.getWartosc(), p.getWaga());
                } else break;
            }
            ++index;
        }
        return rozwiazanie;
    }
}
