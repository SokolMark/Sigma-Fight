package com.sokol.sigmafight.Game;

import com.sokol.sigmafight.Game.Additionally.Equipment;
import com.sokol.sigmafight.Game.Additionally.Potion;
import com.sokol.sigmafight.Game.Additionally.Weapon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MainHero {
    private int gold = 100;
    private int minDamage = 5;
    private int maxDamage = 10;
    private int heroHP = 1000;

    private List<Weapon> weaponInventory = new ArrayList<>();
    private List<Equipment> equipmentInventory = new ArrayList<>();
    private List<Potion> potionInventory = new ArrayList<>();

    public void setGold(int gold) {
        if (gold < 0) {
            throw new IllegalArgumentException("Gold must be a positive number");
        }
        this.gold = gold;
    }
}
