package com.sokol.sigmafight.Game;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Casino {
    MainHero mainHero;
    private final Scanner sc = new Scanner(System.in);
    private int money = 0;

    public Casino(MainHero mainHero) {
        this.mainHero = mainHero;
    }

    public void showCasino() throws InterruptedException {
        System.out.println("-Casino-");
        System.out.println("1. Rules");
        System.out.println("2. Start");
        System.out.println("3. Go back");

        int input = sc.nextInt();

        switch (input) {
            case 1 -> showRules();
            case 2 -> startGame();
            case 3 -> {
                return;
            }
        }
    }

    private void showRules() {
        System.out.println("1. (X X X)  - +50 %");
        System.out.println("2. (7 7 7) - +100%");
        System.out.println("3. ($ $ $) - +150%");
    }

    private void startGame() throws InterruptedException {
        char[] result = new char[3];

        payMoney();
        for (int i = 0; i < 3; i++) {
            int randomNumber = getRandomNumber();
            Thread.sleep(1000);
            switch (randomNumber) {
                case 0 -> {
                    result[i] = 'X';
                    System.out.println("X");
                }
                case 1 -> {
                    result[i] = 'X';
                    System.out.println("X");
                }
                case 2 -> {
                    result[i] = 'X';
                    System.out.println("X");
                }
                case 3 -> {
                    result[i] = 'X';
                    System.out.println("X");
                }
                //////////////////////////
                case 4 -> {
                    result[i] = 'X';
                    System.out.println("X");
                }
                case 5 -> {
                    result[i] = '7';
                    System.out.println("7");
                }
                case 6 -> {
                    result[i] = '7';
                    System.out.println("7");
                }
                //////////////////////////
                case 7 -> {
                    result[i] = '7';
                    System.out.println("7");
                }
                case 8 -> {
                    result[i] = '$';
                    System.out.println("$");
                }
                default -> System.out.println("Something went wrong");
            }
        }

        if (result[0] == 'X' && result[1] == 'X' && result[2] == 'X') {
            int percent = ((money * 50) / 100) + money;
            mainHero.setGold(mainHero.getGold() + percent);
            money = 0;
            System.out.println("Yoy won " + percent + "$");
        } else if (result[0] == '7' && result[1] == '7' && result[2] == '7') {
            int percent = ((money * 100) / 100) + money;
            mainHero.setGold(mainHero.getGold() + percent);
            money = 0;
            System.out.println("Yoy won " + percent + "$");
        } else if (result[0] == '$' && result[1] == '$' && result[2] == '$') {
            money = money * 3;
            mainHero.setGold(mainHero.getGold() + money);
            System.out.println("Yoy won " + money + "$");
            money = 0;
        } else {
            System.out.println("You lost");
            money = 0;
        }
    }

    private int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(8);
    }

    private void payMoney() {
        System.out.println("You can only bet 20$, 50$, 100$, 500$, 1000$");

        while (true) {
            int input = sc.nextInt();
            switch (input) {
                case 20, 50, 100, 500, 1000 -> {
                    if (mainHero.getGold() >= input) {
                        mainHero.setGold(mainHero.getGold() - input);
                        money = input;
                        System.out.println("Bet accepted: " + money + "$");
                        return;
                    } else {
                        System.out.println("You don't have enough gold!");
                    }
                }
                default -> System.out.println("You can only bet 20$, 50$, 100$, 500$, 1000$");
            }
        }
    }
}
