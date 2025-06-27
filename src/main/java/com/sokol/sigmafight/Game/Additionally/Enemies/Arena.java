package com.sokol.sigmafight.Game.Additionally.Enemies;

import com.sokol.sigmafight.Game.Additionally.Enemy;
import com.sokol.sigmafight.Game.Additionally.Hero;
import com.sokol.sigmafight.Game.MainHero;

import java.util.concurrent.ThreadLocalRandom;

public class Arena implements Enemies {

    private int enemyHP = 50;
    private int minDamage = 5;
    private int maxDamage = 10;

    private Hero hero;
    private Enemy enemy;
    private MainHero mainHero;

    public Arena(MainHero mainHero, Hero hero, Enemy enemy) {
        this.mainHero = mainHero;
        this.hero = hero;
        this.enemy = enemy;
    }

    public String getName() {
        String[] names = {"Joffrey", "Drogo", "Ramsay", "Alliser", "Stannis",
                "Euron", "Kraznys", "Meryn", "Craster", "Gregor"};

        return names[ThreadLocalRandom.current().nextInt(names.length)];
    }

    @Override
    public void minusHpOfEnemy() {
        int heroDamage = hero.attack(mainHero.getMinDamage(), mainHero.getMaxDamage());

        mainHero.setHeroHP(mainHero.getHeroHP() - heroDamage);
        System.out.println("✅ The hero deals damage - " + heroDamage);
    }

    @Override
    public void minusHpOfHero() {
        int enemyDamage = enemy.attack(minDamage, maxDamage);

        enemyHP -= enemyDamage;
        System.out.println("\uD83D\uDC94" + "the hero took damage - " + enemyDamage);
    }

    @Override
    public int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(2);
    }

    @Override
    public void getResult() {
        if (mainHero.getHeroHP() <= 0) {
            System.out.println("☠\uFE0FYOU LOST☠\uFE0F");
            mainHero.setHeroHP(0);
            enemyHP = 50;

        } else if (enemyHP <= 0) {
            System.out.println("⚔\uFE0FYOU WON⚔\uFE0F");
            getGold(10);
            System.out.println("+10 gold");
            enemyHP = 50;
        } else
            System.out.println("\uD83D\uDEE1DRAW\uD83D\uDEE1");
        enemyHP = 50;
    }

    @Override
    public void getGold(int gold) {
        mainHero.setGold(mainHero.getGold() + gold);
    }

    @Override
    public void battle(MainHero mainHero) throws InterruptedException {
        final int GOLD = mainHero.getGold(); //find out the current balance

        for (int i = 1; i <= 10; i++) {
            System.out.println("Enemy № " + i + ": " + getName());
            while (mainHero.getHeroHP() > 0 && enemyHP > 0) {
                Thread.sleep(1000); // kick waiting time

                int randomNumber = getRandomNumber();

                switch (randomNumber) {
                    case 0 -> minusHpOfHero();
                    case 1 -> minusHpOfEnemy();
                }
            }
            if (mainHero.getHeroHP() <= 0) {
                System.out.println("you won " + i + " rounds");
                int goldAfterRound = mainHero.getGold();
                int finishGold = goldAfterRound - GOLD; //find out earnings
                System.out.println("+ " + finishGold + " gold");
                break;
            } else {
                getResult();
            }
        }
    }
}
