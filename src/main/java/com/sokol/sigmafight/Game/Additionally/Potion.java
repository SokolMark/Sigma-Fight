package com.sokol.sigmafight.Game.Additionally;

import com.sokol.sigmafight.Game.MainHero;

public enum Potion {
    HP_POTION("HP_Potion", 20, 20, 0, 0),
    DAMAGE_POTION("Damage_Potion", 20, 0, 3, 5);

    public final String name;
    public final int price;
    public final int hpBoost;
    public final int minDamageBoost;
    public final int maxDamageBoost;

    Potion(String name, int price, int hpBoost, int minDamageBoost, int maxDamageBoost) {
        this.name = name;
        this.price = price;
        this.hpBoost = hpBoost;
        this.minDamageBoost = minDamageBoost;
        this.maxDamageBoost = maxDamageBoost;
    }

    public void applyPotion(MainHero mainHero) {
        mainHero.setGold(mainHero.getGold() - price);
        mainHero.getPotionInventory().add(this); // the potion is adding to the inventory after purchase
    }
}
