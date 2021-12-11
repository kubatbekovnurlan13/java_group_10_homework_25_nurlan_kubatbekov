package edu1;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        allRounds();
    }

    public static String makeNormalOption(int index) {
        Options[] arr = new Options[]{
                Options.PAPER,
                Options.SCISSORS,
                Options.ROCK};
        return arr[index] + "";
    }

    public static String makeComlicatedOption(int index) {
        OptionsComplicated[] arr = new OptionsComplicated[]{
                OptionsComplicated.PAPER,
                OptionsComplicated.SCISSORS,
                OptionsComplicated.ROCK,
                OptionsComplicated.LIZARD,
                OptionsComplicated.SPOCK};
        return arr[index] + "";
    }

    public static void allRounds() {
        int[] comp = new int[3];
        int[] user = new int[3];

        int z = 1;
        while (z < 7) {
            System.out.println("----- " + z + " round -----");
            int[][] res = complicatedRound(comp, user);
            comp = res[0];
            user = res[1];
            z++;
        }

        printRes("Comp", comp[0], comp[1], comp[2], (z - 1));
        printRes("User", user[0], user[1], user[2], (z - 1));
    }

    public static void printRes(String name, int win, int lost, int equal, int rounds) {
        String line = "+-------------------------------------------------+";
        String format = "| %-7s | %-7s | %-7s | %-7s | %-7s |";
        String titles = String.format(format, "Wins", "Losts", "Equal", "Rounds", "Win %");
        String val = String.format(format, win, lost, equal, rounds, (100 * win / rounds));

        System.out.println(line);
        System.out.println(" " + name + " => ");
        System.out.println(titles);
        System.out.println(val);
        System.out.println(line);
        System.out.println();

    }

    public static int[][] normalRound(int[] comp, int[] user) {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(3) + 1;

        printNormalConditions();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter comand: ");
        String input = sc.nextLine();
        try {
            int intInput = tryInt(input);
            normalCheckComand(intInput);
            int userInput = intInput - 1;

            String userOption = makeNormalOption(userInput);

            switch (userOption) {
                case "PAPER":
                    if (randomNumber == 1) {
                        comp[2] = comp[2] + 1;
                        user[2] = user[2] + 1;
                    } else if (randomNumber == 2) {
                        comp[0] = comp[0] + 1;
                        user[1] = user[1] + 1;
                    } else {
                        user[0] = user[0] + 1;
                        comp[1] = comp[1] + 1;
                    }
                    break;
                case "SCISSORS":
                    if (randomNumber == 2) {
                        comp[2] = comp[2] + 1;
                        user[2] = user[2] + 1;
                    } else if (randomNumber == 1) {
                        comp[0] = comp[0] + 1;
                        user[1] = user[1] + 1;
                    } else {
                        comp[0] = comp[0] + 1;
                        user[1] = user[1] + 1;
                    }
                    break;
                case "ROCK":
                    if (randomNumber == 3) {
                        comp[2] = comp[2] + 1;
                        user[2] = user[2] + 1;
                    } else if (randomNumber == 1) {
                        comp[0] = comp[0] + 1;
                        user[1] = user[1] + 1;
                    } else {
                        user[0] = user[0] + 1;
                        comp[1] = comp[1] + 1;
                    }
                    break;
            }
        } catch (ParseException | IllegalArgumentException ex) {
            System.out.println("WARNING!!! =====> Please enter right comand!");
            normalRound(comp, user);
        }
        return new int[][]{comp, user};
    }

    public static int[][] complicatedRound(int[] comp, int[] user) {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(5) + 1;

        printComplicatedConditions();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter comand: ");
        String input = sc.nextLine();
        try {
            int intInput = tryInt(input);
            complicatedCheckComand(intInput);
            int userInput = intInput - 1;

            String userOption = makeComlicatedOption(userInput);

            switch (userOption) {
                case "PAPER":
                    if (randomNumber == 1) {
                        comp[2] = comp[2] + 1;
                        user[2] = user[2] + 1;
                    } else if (randomNumber == 2) {
                        comp[0] = comp[0] + 1;
                        user[1] = user[1] + 1;
                    } else if (randomNumber == 3) {
                        user[0] = user[0] + 1;
                        comp[1] = comp[1] + 1;
                    } else if (randomNumber == 4) {
                        comp[0] = comp[0] + 1;
                        user[1] = user[1] + 1;
                    } else {
                        user[0] = user[0] + 1;
                        comp[1] = comp[1] + 1;
                    }
                    break;
                case "SCISSORS":
                    if (randomNumber == 1) {
                        user[0] = user[0] + 1;
                        comp[1] = comp[1] + 1;
                    } else if (randomNumber == 2) {
                        comp[2] = comp[2] + 1;
                        user[2] = user[2] + 1;
                    } else if (randomNumber == 3) {
                        comp[0] = comp[0] + 1;
                        user[1] = user[1] + 1;
                    } else if (randomNumber == 4) {
                        user[0] = user[0] + 1;
                        comp[1] = comp[1] + 1;
                    } else {
                        comp[0] = comp[0] + 1;
                        user[1] = user[1] + 1;
                    }
                    break;
                case "ROCK":
                    if (randomNumber == 1) {
                        comp[0] = comp[0] + 1;
                        user[1] = user[1] + 1;
                    } else if (randomNumber == 2) {
                        user[0] = user[0] + 1;
                        comp[1] = comp[1] + 1;
                    } else if (randomNumber == 3) {
                        comp[2] = comp[2] + 1;
                        user[2] = user[2] + 1;
                    } else if (randomNumber == 4) {
                        user[0] = user[0] + 1;
                        comp[1] = comp[1] + 1;
                    } else {
                        comp[0] = comp[0] + 1;
                        user[1] = user[1] + 1;
                    }
                    break;
                case "LIZARD":
                    if (randomNumber == 1) {
                        user[0] = user[0] + 1;
                        comp[1] = comp[1] + 1;
                    } else if (randomNumber == 2) {
                        comp[0] = comp[0] + 1;
                        user[1] = user[1] + 1;
                    } else if (randomNumber == 3) {
                        comp[0] = comp[0] + 1;
                        user[1] = user[1] + 1;
                    } else if (randomNumber == 4) {
                        comp[2] = comp[2] + 1;
                        user[2] = user[2] + 1;
                    } else {
                        user[0] = user[0] + 1;
                        comp[1] = comp[1] + 1;
                    }
                    break;
                case "SPOCK":
                    if (randomNumber == 1) {
                        comp[0] = comp[0] + 1;
                        user[1] = user[1] + 1;
                    } else if (randomNumber == 2) {
                        user[0] = user[0] + 1;
                        comp[1] = comp[1] + 1;
                    } else if (randomNumber == 3) {
                        user[0] = user[0] + 1;
                        comp[1] = comp[1] + 1;
                    } else if (randomNumber == 4) {
                        comp[0] = comp[0] + 1;
                        user[1] = user[1] + 1;
                    } else {
                        comp[2] = comp[2] + 1;
                        user[2] = user[2] + 1;
                    }
                    break;
            }
        } catch (ParseException | IllegalArgumentException ex) {
            System.out.println("WARNING!!! =====> Please enter right comand!");
            complicatedRound(comp, user);
        }
        return new int[][]{comp, user};
    }

    public static void printNormalConditions() {
        System.out.println("● PAPER     => enter 1");
        System.out.println("● SCISSORS  => enter 2");
        System.out.println("● ROCK      => enter 3");
    }

    public static void printComplicatedConditions() {
        System.out.println("● PAPER     => enter 1");
        System.out.println("● SCISSORS  => enter 2");
        System.out.println("● ROCK      => enter 3");
        System.out.println("● LIZARD    => enter 4");
        System.out.println("● SPOCK     => enter 5");
    }

    public static int tryInt(String birth) throws ParseException {
        NumberFormat nf = NumberFormat.getIntegerInstance();
        return nf.parse(birth).intValue();
    }

    public static void normalCheckComand(int intInput) {
        if (intInput <= 0 || intInput > 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void complicatedCheckComand(int intInput) {
        if (intInput <= 0 || intInput > 5) {
            throw new IllegalArgumentException();
        }
    }
}
