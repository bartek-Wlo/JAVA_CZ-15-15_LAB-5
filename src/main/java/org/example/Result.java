package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Result {
    private ArrayList<Integer> spakowane_id;
    private ArrayList<Integer> spakowane_wartosc;
    private ArrayList<Integer> spakowane_masa;
    private static Integer liczba_przedmiotow = 0;
    private static Integer sumaryczna_masa = 0;
    private static Integer sumaryczna_wartosc = 0;

    public Result() {
        spakowane_id = new ArrayList<>();
        spakowane_wartosc = new ArrayList<>();
        spakowane_masa = new ArrayList<>();
    }

    public void addItem(Integer id, Integer value, Integer mass) {
        spakowane_id.add(id); spakowane_wartosc.add(value); spakowane_masa.add(mass);
        ++liczba_przedmiotow;
        sumaryczna_wartosc += value;
        sumaryczna_masa += mass;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Items number: %d,\nTotal value: %d,\nTotal weight: %d,\n", liczba_przedmiotow, sumaryczna_wartosc, sumaryczna_masa));
        sb.append("id. | war | waga\n");
        for(int i=0; i<liczba_przedmiotow; ++i) {
            sb.append(String.format("%2d. | %3d | %2d\n",
                    spakowane_id.get(i), spakowane_wartosc.get(i), spakowane_masa.get(i)));
        }
        return sb.toString();
    }
}
