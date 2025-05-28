package org.example;
//TIP |To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.|
//TIP |Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
// to see how IntelliJ IDEA suggests fixing it.|
//TIP |Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
// for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.|
// |Alt + insert -> generate|

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int N, Seed = 0, pojemnosc;
    private static final int LowerBound = 1, UpperBound = 10;
    private static boolean SeedNeed = false;

    public static void main(String[] args) {
        ScannerFun();
        Problem prob = new Problem(N, Seed, LowerBound, UpperBound, SeedNeed);
        System.out.println(prob.solve(pojemnosc));
        System.out.println(prob);
    }

    private static void ScannerFun() {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.print("Give seed (\"not int\" for random seed): "); input = scanner.nextLine();
        if( ! input.equalsIgnoreCase("rand"))
            try {Seed = Integer.parseInt(input); SeedNeed = true;}
            catch (NumberFormatException e) {System.out.print("Invalid input, using random seed.");}

        System.out.print("Give number of item types: ");
        while(true) try {N = Integer.parseInt(scanner.nextLine()); break;}
                    catch (NumberFormatException e) {System.out.print("Invalid input, try again: ");}

        System.out.print("Give kanpsack capacity: ");
            while(true) try {pojemnosc = Integer.parseInt(scanner.nextLine()); break;}
            catch (NumberFormatException e) {System.out.println("Invalid input, try again: ");}
    }
}