package com.sokol.sigmafight.Game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MainHero {
    private int gold = 100;
    private int minDamage = 5;
    private int maxDamage = 10;
    private int heroHP = 100;

    public void setGold(int gold) {
        if (gold < 0) {
            throw new IllegalArgumentException("Gold must be a positive number");
        }
        this.gold = gold;
    }
}
