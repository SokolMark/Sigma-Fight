package com.sokol.sigmafight.Game;

import com.sokol.sigmafight.Game.Additionally.Equipment;
import com.sokol.sigmafight.Game.Additionally.Potion;
import com.sokol.sigmafight.Game.Additionally.Weapon;

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

    public void getWeapon() {
        while (true) {

            Scanner sc = new Scanner(System.in);

            Weapon[] weapon = Weapon.values();

            System.out.println("-----------------------------------------------------------------------");

            for (int i = 0; i < weapon.length; i++) {
                System.out.println((i + 1) + ". - " + weapon[i].name + " - " + weapon[i].price);
                System.out.println("Damage: " + weapon[i].minDamage + " - " + weapon[i].maxDamage);
                System.out.println("-----------------------------------------------------------------------");
            }
            System.out.println((weapon.length + 1) + ". - Exit");
            System.out.println("-----------------------------------------------------------------------");

            System.out.println("Choose: ");
            int choice = sc.nextInt();

            if (choice == weapon.length + 1) {
                System.out.println("Exiting...");
                return;
            }

            if (choice < 1 || choice > weapon.length) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            Weapon selected = weapon[choice - 1];

            if (game.getGold() < selected.price) {
                System.out.println("Not enough gold.");
            } else {
                selected.applyWeapon(game);
                System.out.println("You bought " + selected.name);
            }

        }
    }

    public void getEquipment() {
        while (true) {

            Scanner sc = new Scanner(System.in);

            Equipment[] equipment = Equipment.values();

            System.out.println("-----------------------------------------------------------------------");

            for (int i = 0; i < equipment.length; i++) {
                System.out.println((i + 1) + ". - " + equipment[i].name + " - " + equipment[i].price);
                System.out.println("HP Boost: " + equipment[i].hpBoost);
                System.out.println("-----------------------------------------------------------------------");
            }

            System.out.println((equipment.length + 1) + ". - Exit");
            System.out.println("-----------------------------------------------------------------------");

            int choice = sc.nextInt();

            if (choice == equipment.length + 1) {
                System.out.println("Exiting...");
                return;
            }

            if (choice < 1 || choice > equipment.length) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            Equipment selected = equipment[choice - 1];

            if (game.getGold() < selected.price) {
                System.out.println("Not enough gold.");
            } else {
                selected.applyEquipment(game);
                System.out.println("You bought " + selected.name);
            }
        }
    }

    public void getPotion() {
        while (true) {

            Scanner sc = new Scanner(System.in);

            Potion[] potion = Potion.values();

            System.out.println("-----------------------------------------------------------------------");

            for (int i = 0; i < potion.length; i++) {
                System.out.println((i + 1) + ". - " + potion[i].name + " - " + potion[i].price);
                System.out.println("HP Boost: " + potion[i].hpBoost);
                System.out.println("-----------------------------------------------------------------------");
            }

            System.out.println((potion.length + 1) + ". - Exit");
            System.out.println("-----------------------------------------------------------------------");

            int choice = sc.nextInt();

            if (choice == potion.length + 1) {
                System.out.println("Exiting...");
                return;
            }

            if (choice < 1 || choice > potion.length) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            Potion selected = potion[choice - 1];

            if (game.getGold() < selected.price) {
                System.out.println("Not enough gold.");
            } else {
                selected.applyPotion(game);
                System.out.println("You bought " + selected.name);
            }
        }
    }

    public void shop() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("--What products do you want to buy?--");
            System.out.println("1. - Weapon");
            System.out.println("2. - Equipment");
            System.out.println("3. - Potions");
            System.out.println("4. - Exit");

            int products = sc.nextInt();

            switch (products) {
                case 1 -> getWeapon();
                case 2 -> getEquipment();
                case 3 -> getPotion();
                case 4 -> {
                    return;
                }
            }
        }
    }
}
