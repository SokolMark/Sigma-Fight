package com.sokol.sigmafight.Game;

import java.util.Scanner;

public class Shop {
    public Game game;

    public Shop(Game game) {
        this.game = game;
    }

    public void showInf() {
        System.out.println("Gold: " + game.getGold());
        System.out.println("HP: " + game.getHeroHP());
        System.out.println("Damage: " + game.getMinDamage() + " - " + game.getMaxDamage());
    }

    public void shop() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--in-stock--");
            System.out.println("1. - Better sword (10 - 20 damage) - 40 gold");
            System.out.println("2. - Arm (+20hp) - 40 gold");
            System.out.println("3. - Potion (+10hp) - 20 gold");
            System.out.println("4. - Better Potion (+15hp) - 25 gold");
            System.out.println("5. - Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    game.setMinDamage(game.getMinDamage() + 5);
                    game.setMaxDamage(game.getMaxDamage() + 10);
                    game.setGold(game.getGold() - 40);
                    System.out.println("The better sword has been purchased");
                    break;

                case 2:
                    game.setHeroHP(game.getHeroHP() + 20);
                    game.setGold(game.getGold() - 40);
                    System.out.println("The Arm has been purchased");
                    break;

                case 3:
                    game.setHeroHP(game.getHeroHP() + 10);
                    game.setGold(game.getGold() - 20);
                    System.out.println("The Potion has been purchased");
                    break;

                case 4:
                    game.setHeroHP(game.getHeroHP() + 15);
                    game.setGold(game.getGold() - 25);
                    System.out.println("The Better Potion has been purchased");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
