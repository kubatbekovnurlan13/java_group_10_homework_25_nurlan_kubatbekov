package edu1;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        allRounds();
    }

    public static void allRounds() {
        double comp = 0;
        double user = 0;

        int z = 1;
        while (z < 7) {
            System.out.println("----- " + z + " round -----");
            double[] res = round(comp, user);
            comp = res[0];
            user = res[1];
            z++;
        }
    }

    public static double[] round(double comp, double user) {
        Random rnd = new Random();
        int random = rnd.nextInt(4) + 1;

        printConditions();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter comand: ");
        String input = sc.nextLine();
        try {
            int intInput = tryInt(input);
            checkComand(intInput);

            System.out.println("comp turn: " + random);
            System.out.println("user turn: " + intInput);

            if (random == intInput) {
                comp = comp + 0.5;
            } else if (random == 1 && intInput == 2) {
                comp++;
            } else if (random == 1 && intInput == 3) {
                user++;
            } else if (random == 2 && intInput == 1) {
                user++;
            } else if (random == 2 && intInput == 3) {
                comp++;
            } else if (random == 3 && intInput == 1) {
                comp++;
            } else if (random == 3 && intInput == 2) {
                user++;
            }
            System.out.println("Comp: " + comp);
            System.out.println("User: " + user);
        } catch (ParseException | IllegalArgumentException ex) {
            System.out.println("Please enter right comand!");
            round(comp,user);
        }
        return new double[]{comp, user};

    }

    public static void printConditions() {
        System.out.println("PAPER => enter 1");
        System.out.println("ROCK => enter 2");
        System.out.println("SCISSORS  => enter 3");
    }

    public static int tryInt(String birth) throws ParseException {
        NumberFormat nf = NumberFormat.getIntegerInstance();
        return nf.parse(birth).intValue();
    }

    public static void checkComand(int intInput) {
        if (intInput <= 0 || intInput > 3) {
            throw new IllegalArgumentException();
        }
    }

}
