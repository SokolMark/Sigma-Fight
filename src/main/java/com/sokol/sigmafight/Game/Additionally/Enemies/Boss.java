package com.sokol.sigmafight.Game.Additionally.Enemies;

import com.sokol.sigmafight.Game.Additionally.Enemy;
import com.sokol.sigmafight.Game.Additionally.Hero;
import com.sokol.sigmafight.Game.MainHero;

import java.util.concurrent.ThreadLocalRandom;

public class Boss implements Enemies {
    private final String NAME = "Boss";
    private int minDamage = 30;
    private int maxDamage = 40;
    private int bossHP = 200;

    private Hero hero;
    private Enemy enemy;
    private MainHero mainHero;

    public Boss(MainHero mainHero, Hero hero, Enemy enemy) {
        this.mainHero = mainHero;
        this.hero = hero;
        this.enemy = enemy;
    }

    @Override
    public void minusHpOfEnemy() {
        int heroDamage = hero.attack(mainHero.getMinDamage(), mainHero.getMaxDamage());

        bossHP -= heroDamage;
        System.out.println("✅ The hero deals damage to the " + NAME + " - " + heroDamage);
    }

    @Override
    public void minusHpOfHero() {
        int bossDamage = enemy.attack(minDamage, maxDamage);

        mainHero.setHeroHP(mainHero.getHeroHP() - bossDamage);
        System.out.println("\uD83D\uDC94 The " + NAME + " deals damage to the hero " + "-" + bossDamage);
    }

    @Override
    public int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(3);
    }

    @Override
    public void getResult() {
        if (mainHero.getHeroHP() <= 0) {
            System.out.println("☠\uFE0FYOU LOST☠\uFE0F");
            mainHero.setHeroHP(0);
            bossHP = 200;

        } else if (bossHP <= 0) {
            System.out.println("⚔\uFE0FYOU WON⚔\uFE0F");
            getGold(100);
            System.out.println("+20 gold");
            bossHP = 200;
        } else
            System.out.println("\uD83D\uDEE1DRAW\uD83D\uDEE1");
        getGold(50);
        bossHP = 200;
    }

    @Override
    public void getGold(int gold) {
        mainHero.setGold(mainHero.getGold() + gold);
    }

    @Override
    public void battle(MainHero mainHero) throws InterruptedException {
        while (mainHero.getHeroHP() > 0 && bossHP > 0) {

            Thread.sleep(1000); // kick waiting time

            int randomNumber = getRandomNumber();

            switch (randomNumber) {
                case 0 -> minusHpOfHero();
                case 1 -> minusHpOfHero();
                case 2 -> minusHpOfEnemy();
            }
        }
    }
}
