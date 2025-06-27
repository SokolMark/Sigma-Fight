package com.sokol.sigmafight.Game;

import java.util.Scanner;

public class MainMenu {
    public Shop shop;
    public Battle battle;

    public MainMenu(Shop shop, Battle battle) {
        this.shop = shop;
        this.battle = battle;
    }

    public void chooseOption() throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("--Main-menu--");
            System.out.println("1. - Information about Hero");
            System.out.println("2. - Shop");
            System.out.println("3. - Fight");
            System.out.println("4. - Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> shop.showInf();
                case 2 -> shop.shop();
                case 3 -> battle.fight();
                case 4 -> {
                    return;
                }
            }
        }
    }
}
