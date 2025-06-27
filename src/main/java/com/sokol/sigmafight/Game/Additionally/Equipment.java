package com.sokol.sigmafight.Game.Additionally;

import com.sokol.sigmafight.Game.MainHero;

public enum Equipment {
    KNIGHT("Knight Set", 40, 20);

    public final String name;
    public final int price;
    public final int hpBoost;

    Equipment(String name, int price, int hpBoost) {
        this.name = name;
        this.price = price;
        this.hpBoost = hpBoost;
    }

    public void applyEquipment (MainHero mainHero) {
        mainHero.setGold(mainHero.getGold() - price);
        mainHero.setHeroHP(mainHero.getHeroHP() + hpBoost);
    }

}
