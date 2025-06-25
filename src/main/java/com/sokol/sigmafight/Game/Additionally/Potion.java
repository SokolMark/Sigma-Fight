package com.sokol.sigmafight.Game.Additionally;

import com.sokol.sigmafight.Game.Game;

public enum Potion {
    POTION("Potion", 20, 10);

    public final String name;
    public final int price;
    public final int hpBoost;

    Potion (String name, int price, int hpBoost) {
        this.name = name;
        this.price = price;
        this.hpBoost = hpBoost;
    }

    public void applyPotion (Game game) {
        game.setGold(game.getGold() - price);
        game.setHeroHP(game.getHeroHP() + hpBoost);
    }

}
