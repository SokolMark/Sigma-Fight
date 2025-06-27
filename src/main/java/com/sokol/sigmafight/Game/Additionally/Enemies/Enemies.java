package com.sokol.sigmafight.Game.Additionally.Enemies;

import com.sokol.sigmafight.Game.MainHero;

public interface Enemies {
    void minusHpOfEnemy();

    void minusHpOfHero();

    int getRandomNumber();

    void getResult();

    void getGold(int gold);

    void battle(MainHero mainHero) throws InterruptedException;
}
