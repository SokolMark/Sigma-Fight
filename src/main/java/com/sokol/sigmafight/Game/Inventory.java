package com.sokol.sigmafight.Game;

import com.sokol.sigmafight.Game.Additionally.Equipment;
import com.sokol.sigmafight.Game.Additionally.Potion;
import com.sokol.sigmafight.Game.Additionally.Weapon;

import java.util.Scanner;

public class Inventory {
    private final Scanner scanner = new Scanner(System.in);
    private Weapon currentWeapon;
    private Equipment currentEquipment;

    public void showInventory(MainHero mainHero) {

        System.out.println("Inventory");
        System.out.println("What do you want to use?");
        System.out.println("1. Weapon");
        System.out.println("2. Equipment");
        System.out.println("3. Potion");
        System.out.println("4. Exit");

        int input = scanner.nextInt();
        scanner.nextLine();

        switch (input) {
            case 1 -> applyWeapon(mainHero);
            case 2 -> applyEquipment(mainHero);
            case 3 -> applyPotion(mainHero);
            case 4 -> {
                return;
            }
            default -> System.out.println("Invalid input");
        }
    }

    private void applyWeapon(MainHero mainHero) {
        int i = 1;
        System.out.println("-----------------------------------------------------------------------");
        for (Weapon w : mainHero.getWeaponInventory()) {
            System.out.println(i + " - " + w.toString());
            System.out.println("Name - " + w.name);
            System.out.println("Min damage - " + w.minDamage);
            System.out.println("Max damage - " + w.maxDamage);

            i++;
            System.out.println("-----------------------------------------------------------------------");
        }

        System.out.println("What weapon do you want to use?");
        System.out.println("If you write a wrong name you will return to last window!");
        System.out.print("Write name of weapon: ");

        String inputString = scanner.nextLine();

        for (Weapon w : mainHero.getWeaponInventory()) {
            if (inputString.equalsIgnoreCase(w.name)) {
                if (currentWeapon != null) {
                    mainHero.setMinDamage(mainHero.getMinDamage() - currentWeapon.minDamage);
                    mainHero.setMaxDamage(mainHero.getMaxDamage() - currentWeapon.maxDamage);
                }
                mainHero.setMinDamage(mainHero.getMinDamage() + w.minDamage);
                mainHero.setMaxDamage(mainHero.getMaxDamage() + w.maxDamage);
                currentWeapon = w;

                System.out.println("weapon " + w.name + " has been successfully applied!");
            }
        }
    }

    private void applyEquipment(MainHero mainHero) {
        int i = 1;
        System.out.println("-----------------------------------------------------------------------");
        for (Equipment e : mainHero.getEquipmentInventory()) {
            System.out.println(i + " - " + e.toString());
            System.out.println("Name - " + e.name);
            System.out.println("HP boost - " + e.hpBoost);

            i++;
            System.out.println("-----------------------------------------------------------------------");
        }

        System.out.println("What equipment do you want to use?");
        System.out.println("If you write a wrong name you will return to last window!");
        System.out.print("Write name of equipment: ");

        String inputString = scanner.nextLine();

        for (Equipment e : mainHero.getEquipmentInventory()) {
            if (inputString.equalsIgnoreCase(e.name)) {
                if (currentEquipment != null) {
                    mainHero.setHeroHP(mainHero.getHeroHP() - currentEquipment.hpBoost);
                }
                mainHero.setHeroHP(mainHero.getHeroHP() + e.hpBoost);
                currentEquipment = e;

                System.out.println("Equipment " + e.name + " has been successfully applied!");
            }
        }
    }

    private void applyPotion(MainHero mainHero) {
        int i = 1;
        System.out.println("-----------------------------------------------------------------------");
        for (Potion p : mainHero.getPotionInventory()) {
            System.out.println(i + " - " + p.toString());
            System.out.println("Name - " + p.name);
            System.out.println("HP boost - " + p.hpBoost);

            i++;
            System.out.println("-----------------------------------------------------------------------");
        }

        System.out.println("What potion do you want to use?");
        System.out.println("If you write a wrong name you will return to last window!");
        System.out.print("Write name of potion: ");

        String inputString = scanner.nextLine();

        for (Potion p : mainHero.getPotionInventory()) {
            if (inputString.equalsIgnoreCase(p.name)) {
                mainHero.setHeroHP(mainHero.getHeroHP() + p.hpBoost);
                mainHero.getPotionInventory().remove(p); // Potion is removed after use
                System.out.println("Potion " + p.name + " has been successfully applied!");
            }
        }
    }
}
