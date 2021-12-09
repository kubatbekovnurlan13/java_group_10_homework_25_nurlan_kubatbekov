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
        int[] comp = new int[3];
        int[] user = new int[3];

        int z = 1;
        while (z < 7) {
            System.out.println("----- " + z + " round -----");
            int[][] res = round(comp, user);
            comp = res[0];
            user = res[1];
            z++;
        }

//        System.out.println("comp: " + Arrays.toString(comp));
//        System.out.println("user: " + Arrays.toString(user));
        printRes("Comp",comp[0], comp[1], comp[2], (z - 1));
        printRes("User",user[0], user[1], user[2], (z - 1));
    }

    public static void printRes(String name, int win, int lost, int equal, int rounds) {
        String line = "+---------------------------------------------------------+";
        String format = "| %-10s | %-10s | %-10s | %-10s | %-10s |";
        String titles = String.format(format,
                "Wins",
                "Losts",
                "Equal",
                "Rounds",
                "Win %");
        String val = String.format(format,
                win, lost, equal, rounds, (100 * win / rounds));

        System.out.println(line);
        System.out.println("| " + name + " => ");
        System.out.println(titles);
        System.out.println(val);

    }

    public static int[][] round(int[] comp, int[] user) {
        Random rnd = new Random();
        int random = rnd.nextInt(4) + 1;

        printConditions();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter comand: ");
        String input = sc.nextLine();
        try {
            int intInput = tryInt(input);
            checkComand(intInput);

//            System.out.println("comp turn: " + random);
//            System.out.println("user turn: " + intInput);

            if (random == intInput) {
//                comp = comp + 0.5;
                comp[2] = comp[2] + 1;
                user[2] = user[2] + 1;
            } else if (random == 1 && intInput == 2) {
                comp[0] = comp[0] + 1;
                user[1] = user[1] + 1;
//                comp++;
            } else if (random == 1 && intInput == 3) {
//                user++;
                user[0] = user[0] + 1;
                comp[1] = comp[1] + 1;
            } else if (random == 2 && intInput == 1) {
//                user++;
                user[0] = user[0] + 1;
                comp[1] = comp[1] + 1;
            } else if (random == 2 && intInput == 3) {
//                comp++;
                comp[0] = comp[0] + 1;
                user[1] = user[1] + 1;
            } else if (random == 3 && intInput == 1) {
//                comp++;
                comp[0] = comp[0] + 1;
                user[1] = user[1] + 1;
            } else if (random == 3 && intInput == 2) {
//                user++;
                user[0] = user[0] + 1;
                comp[1] = comp[1] + 1;
            }
//            System.out.println("Comp: " + Arrays.toString(comp));
//            System.out.println("User: " + Arrays.toString(user));
        } catch (ParseException | IllegalArgumentException ex) {
            System.out.println("Please enter right comand!");
            round(comp, user);
        }
        int[][] res = {comp, user};
        return res;

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
