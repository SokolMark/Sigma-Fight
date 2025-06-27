package com.sokol.sigmafight.Game.Additionally.Enemies;

import com.sokol.sigmafight.Game.Additionally.Enemy;
import com.sokol.sigmafight.Game.Additionally.Hero;
import com.sokol.sigmafight.Game.MainHero;

import java.util.concurrent.ThreadLocalRandom;

public class Robber implements Enemies {
    private final String NAME = "Robber";
    private int minDamage = 5;
    private int maxDamage = 10;
    private int robberHP = 100;
    private Hero hero;
    private Enemy enemy;
    private MainHero mainHero;

    public Robber(MainHero mainHero, Hero hero, Enemy enemy) {
        this.mainHero = mainHero;
        this.hero = hero;
        this.enemy = enemy;
    }

    @Override
    public void minusHpOfHero() {
        int enemyDamage = enemy.attack(minDamage, maxDamage);

        mainHero.setHeroHP(mainHero.getHeroHP() - enemyDamage);
        System.out.println("\uD83D\uDC94 The " + NAME + " deals damage to the hero " + "-" + enemyDamage);
    }

    @Override
    public void minusHpOfEnemy() {
        int heroDamage = hero.attack(mainHero.getMinDamage(), mainHero.getMaxDamage());

        robberHP -= heroDamage;
        System.out.println("✅ The hero deals damage to the " + NAME + " - " + heroDamage);
    }

    @Override
    public int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(2);
    }


    @Override
    public void getGold(int gold) {
        mainHero.setGold(mainHero.getGold() + gold);
    }

    @Override
    public void battle(MainHero mainHero) throws InterruptedException {
        while (mainHero.getHeroHP() > 0 && robberHP > 0) {

            Thread.sleep(1000); // kick waiting time

            int randomNumber = getRandomNumber();

            switch (randomNumber) {
                case 0 -> minusHpOfHero();
                case 1 -> minusHpOfEnemy();
            }
        }
    }

    @Override
    public void getResult() {
        if (mainHero.getHeroHP() <= 0) {
            System.out.println("☠\uFE0FYOU LOST☠\uFE0F");
            mainHero.setHeroHP(0);
            robberHP = 100;

        } else if (robberHP <= 0) {
            System.out.println("⚔\uFE0FYOU WON⚔\uFE0F");
            getGold(20);
            System.out.println("+20 gold");
            robberHP = 100;
        } else
            System.out.println("\uD83D\uDEE1DRAW\uD83D\uDEE1");
        getGold(10);
        robberHP = 100;
    }
}