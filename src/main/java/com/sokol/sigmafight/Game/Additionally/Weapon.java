package com.sokol.sigmafight.Game.Additionally;

import com.sokol.sigmafight.Game.MainHero;

public enum Weapon {
    SWORD("Better Sword", 40, 10, 20 ),
    BOW("Bow", 50, 5, 25),
    HAMMER("Hammer", 80, 15, 25),
    WAND("Wizard Wand", 120, 20, 30);

    public final String name;
    public final int price;
    public final int minDamage;
    public final int maxDamage;

    Weapon(String name, int price, int minDamage, int maxDamage) {
        this.name = name;
        this.price = price;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public void applyWeapon (MainHero mainHero) {
        mainHero.setGold(mainHero.getGold() - price);
        mainHero.setMinDamage(minDamage);
        mainHero.setMaxDamage(maxDamage);
    }
}
